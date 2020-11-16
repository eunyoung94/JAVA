package day1110.multicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 채팅 메세지를 보내지 않더라도, 채팅에 참여하는 모든 사람이 보낸 메세지를 수신하려면 
 무한 루프로 실행되면서 스트림을 읽을 쓰레드가 필요하다!
 */
public class ClientThread extends Thread {
	multiClient multiClient;
	BufferedReader buffr;
	BufferedWriter buffw;
	Socket socket;
	boolean flag =true;
	
	public ClientThread(multiClient multiClient , Socket socket) {
		this.multiClient=multiClient;
		this.socket=socket;
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		listen();
	}
//서버가 보낸 메세지 듣기
	public void listen() {
		String msg = null;
		try {
			while (flag) {
				msg = buffr.readLine();
				multiClient.area.append(msg + "\n");// 대화기록하기
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		try {
			buffw.write(msg + "\n"); // 반드시 스트림의 끝을 써줘야한다 "\n"
			buffw.flush(); // 남아있는 데이터 없이, 버퍼비우기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}