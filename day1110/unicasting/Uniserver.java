package day1110.unicasting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Uniserver extends JFrame {
	JTextField t_port;
	JButton bt;
	JPanel p_north;
	JTextArea area;
	JScrollPane scroll;
	ServerSocket server;
	int port = 7777;
	Thread thread;// 메인쓰레드 대신, 접속자를 감지하게될 쓰레드 (accept()메서드 때문에 )
	BufferedReader buffr;// 듣기
	BufferedWriter buffw;// 말하기

	public Uniserver() {
		t_port = new JTextField(Integer.toString(port), 10);
		bt = new JButton("서버가동");
		p_north = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(area);

		// 조립
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		// 가동버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread = new Thread() {
					public void run() {
						startServer();
					}
				};
				thread.start(); // Runnable로 진입 시키자
			}
		});

		setVisible(true);
		setBounds(600, 200, 300, 400);// x,y,width,height 순서
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// 서버가동
	public void startServer() {
		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText()));
			area.append("서버준비\n");
//서버는 여러명의 접속자를 감지해야한다면 , 각 접속자마다 비동기적으로 즉 독립적으로서 상관없이 대화를 주고받는 주체는 쓰레드의 인스턴스로 처리하자 
			while (true) {
				Socket socket = server.accept(); // 접속자 감지와 동시에 대화용 소켓반환
				area.append("접속자발견\n");
				MessageThread messageThread=new MessageThread(this, socket);
				messageThread.start();//Runnable로 진입! 
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		new Uniserver();
	}
}
