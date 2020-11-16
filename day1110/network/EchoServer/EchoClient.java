package day1110.network.EchoServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
에코 서버에 접속하여 메세지를 주고받을 클라이언트 작성 
*/
public class EchoClient {
	Socket socket; // 대화용소켓
	String ip = "localhost";
	Thread thread;
	int port = 8989;

	public EchoClient() {
//소켓은 생성시 접속을 시도한다. 
//따라서 소켓의 인스턴스가 얻어졌다는 것은, 이미 서버와의 접속이 된 상태이다. 
		try {
			socket = new Socket(ip, port);// 접속
			System.out.println("접속성공");

			// 받는용, 듣는용 (빨대 업글)
			InputStream is = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(is);
			BufferedReader buffr = new BufferedReader(reader);

			// 보내는용, 말하는용 (빨대 업글)
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out);
			BufferedWriter buffw = new BufferedWriter(writer);
			
			thread = new Thread() {
				public void run() {
					while (true) {
						try {
							buffw.write("야호\n"); // 서버에 메세지 출력 \n을 반드시 해줘야한다. 안붙이면 줄이 끝없이 반복되므로...
							buffw.flush(); // 버퍼처리된 출력스트림의경우 , 스트림안의 데이터를 모두 비워버리는것,  write와 flush는 같이 쓰는것이 좋음..
							Thread.sleep(1000);
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}					
				};
			};
			thread.start();//Runnable 영영으로 밀어넣기 jvm에 맡기기 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}
}
