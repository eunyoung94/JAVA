package day1102.Memo;
/*
 입력스트림 처리는 파일에 국한된 기술이 아니다. 
 실행중인 프로그램으로 데이터가 흘러들어온다면, 이 모든것이 다 입력스트림이다. 
 따라서 이 예제는 파일을 대상으로 데이터를 읽는것이아니라, 
 키보드를 대상으로 데이터를 읽어와보자 
 파일과 달리 , 키보드의 스트림은 자바에서 생성할 수 있는것이 아니라, 이미 os차원에서 스트림이 존재하므로, 
 자바는 단지 이미 존재하는 스트림을 얻어와 쓸 수 있다. 
 * */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInputApp {
	
	public static void main(String[] args) {
//키보드 스트림은 이미 시스템적으로 존재하므로, 자바의 system클래스로부터 얻자 
		InputStream is =System.in ; //표준 입력스트림(키보드 or 기타 입력도구에 대한 스트림)
		InputStreamReader reader = new InputStreamReader(is);
		//inputstream -->문자기반 x 바이트 기반이라서 한글을 쓰면 안나옴..
		int data;
		try {
			while(true) {				
				data = reader.read();// 2byte씩 묶어서 해석할 수 있는 능력이 생겼음
			//	1byte읽기, read()의 특징, 입력이 완료되지 않으면 무한대기상태로 머물러 있음
				//즉, 입력이 되어야 read()메서드 이후의 문장이 수행 될 수있다. 
				System.out.print((char)data);
			}
		} catch (IOException e) {
			//shift alt z --> try catch단축키 
			e.printStackTrace();
		}
	}
	
}
