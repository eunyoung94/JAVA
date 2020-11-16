package day1110.gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EcoClient extends JFrame{
	JPanel p_north;
	Choice ch_ip;
	JTextField t_port;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	Socket socket; //대화용소켓 
	BufferedReader buffr;
	BufferedWriter buffw;
	public EcoClient() {
		p_north = new JPanel();
		p_south = new JPanel();
		ch_ip = new Choice();
		t_port = new JTextField("7777",10);
		bt_connect = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(10);
		bt_send = new JButton("전송");
		
		ch_ip.add("localhost");
		//조립 
		p_north.add(ch_ip);
		p_north.add(t_port);
		p_north.add(bt_connect);
		add(p_north,BorderLayout.NORTH);
		add(scroll);

		p_south.add(t_input);
		p_south.add(bt_send);
		add(p_south,BorderLayout.SOUTH);
		//접속버튼과 리스너 연결 
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		bt_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
				listen();
			}
		});
		setBounds(300,200,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//에코서버에 접속한다! 
	public void 	connect() {
		try {
			socket = new Socket(ch_ip.getSelectedItem(),Integer.parseInt(t_port.getText()));
			area.append("서버에 접속\n");
			//접속이 성공되었으므로, 스트림을 얻을 수 있다. 
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//서버에 메세지 보내기(출력)
	public void send() {
		String msg=t_input.getText();
		try {
			buffw.write(msg+"\n"); //반드시 스트림의 끝을 써줘야한다 "\n"
			buffw.flush(); // 남아있는 데이터 없이, 버퍼비우기 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//서버가 보낸 메세지 듣기 
	public void listen() {
		String msg =null;
		try {
			msg=buffr.readLine();
			area.append(msg+"\n");//대화기록하기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EcoClient();
	}

}
