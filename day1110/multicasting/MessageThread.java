package day1110.multicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//이 쓰레드는 대화용 쓰레드이므로, 입출력 스트림을 각각의 인스턴스가 보유해야한다. 
public class MessageThread extends Thread{
	Socket socket;//각각의 쓰레드는 대화용 소켓을 보유해야 스트림을 뽑을 수 있으므로, 접속자가 감지되면 해당 소켓을 인수로 넘겨받자! 
	BufferedReader buffr;//듣기 
	BufferedWriter buffw;//말하기
	multiserver multiserver;
	boolean flag =true;
	
	public MessageThread(multiserver multiserver,Socket socket){
		this.multiserver=multiserver;
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
	// 메세지받기 (청취)
	public void listen(){
		String msg = null;
		try {
			while (flag) {
				msg = buffr.readLine();// 현재로서는 한번만 듣는다.
				//코드명령어 중 나간다는 뜻이면.. 나가는 처리, 아닌경우는 평상시대로 
				if(msg.equals("exit")) {
					//백터 명단에서 제거하자 2.flag도 false : 쓰레드 Dead
					multiserver.clientList.remove(this);
					flag=false;
					multiserver.area.append(msg + "\n");
				}else {
					multiserver.area.append("현재까지 접속자 수 "+multiserver.clientList.size()+ "\n");
					send(msg);// 클라이언트에게 다시 보내야한다 (서버의의무)					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 클라이언트에게 메세지를 보내기
	public void send(String msg) {
		try {
			//백터에 들어있는 메세지 스레드만큼 반복문을 수행하면서 .write,flush수행하면된다 (멀티케스팅)
			for(int i=0;i<multiserver.clientList.size();i++) {
			MessageThread messageThread=multiserver.clientList.get(i); //백터에 들어있는 메세지 쓰레드를 하나씩 꺼낸다. 
			messageThread.buffw.write(msg + "\n");
			messageThread.buffw.flush();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
