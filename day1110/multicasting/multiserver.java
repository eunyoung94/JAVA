package day1110.multicasting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class multiserver extends JFrame {
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
	//자바의 컬렉션 프레임웍 중 순서있는 데이터를 처리해주는 객체   동기화->순서가 있다.안정적이다 /  비동기 ->순서가 없다. 
	Vector<MessageThread> clientList=new Vector<MessageThread>();
	public multiserver() {
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
				//다수의 접속자 수 정보를 어딘가에 저장해놓자! 
				
				MessageThread messageThread=new MessageThread(this, socket);
				messageThread.start();//Runnable로 진입! 
				
				clientList.add(messageThread);//지금접속한 클라이언트와 쌍을 이루는 서버측 대화쓰레드를 
				//백터에 담아두면, 총 몇명이 들어왔고, 누가 들어왓는지에 대한 데이터를 누적할 수 있게 된다. 
				area.append("현재까지 접속자는?"+clientList.size()+"명\n");
		
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		new multiserver();
	}
}
