package day1109;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 최종목표는 채팅(멀티케스팅 구현)이지만, 일단 기초인 echo system을 먼저 학습한다. 
 */
public class EchoServer {
	ServerSocket server; //대화용 소켓이 아닌, 접속자 감지용 서버측 소켓 ; 
	int port=9999; //port 1~1024까지는 이미 시스템이 점유하므로, 사용불가 
	public EchoServer() {
		//서버소켓을 이용하여,접속자를 받아보자 
		try {
			server = new ServerSocket(9999);
			System.out.println("서버소켓생성완료");
			
			Socket socket = server.accept(); //접속자가 발견될때까지 블락상태로 기다림.. 
			System.out.println("접속자 발견");
			//반환받은 소켓을 이용하면, 현재 접속자에 대한 정보를 구할 수 있으며, 특히 ip를 조사해보자 
			InetAddress inet=socket.getInetAddress(); //인터넷 주소정보를 가진객체 
			String ip = inet.getHostAddress(); //ip추출 
			 System.out.println("접속한 클라이언트의 아이피는?"+ip);
			 
			//클라이언트가 보낸 메세지 받기!(메세지를 받는것은 실행중인 프로그램으로 데이터가 들어오는것이므로, 
			 //입력스트림..이라고한다 ) 
			 //소켓으로부터 스트림을 뽑아낼 수 있다.. 
			InputStream is =  socket.getInputStream(); //바이트 기반의 입력스트림(한글이 깨짐,, 영문으로하자)
			int data;
			
			while(true) {
			data=is.read(); //1byte를 읽어드림 
			System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} //서버소켓생성
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
