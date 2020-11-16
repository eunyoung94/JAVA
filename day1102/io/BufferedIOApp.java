package day1102.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 실행중인 프로그램으로 데이터를 읽거나 쓸때 , 한바이트, 한 문자씩 입출력을 수행하면, 데이터량이 많을때 너무많은 입출력을 수행하게된다. 
 속도저하가 발생한다. 
 마치 cmd창의 버퍼처리처럼 , 메모리상의 버퍼에 데이터를 모아놓고, 한줄이 끝나는 시점에만 입력및 출력을 처리하면 프로그램 실행의 효율성이 극대화됨..
 스트림중 버퍼를 지원하는 스트림은 접두어로 Buffered 가붙는다. 
 입출력 방향에 따라 입력과 출력으로 나눠짐, 문자처리 여부에 따라 바이트, 문자기반 
 버퍼처리 여부에 따라 Buffered
 */
public class BufferedIOApp {
	public static void main(String[] args) {
		//keyboard에 연결된 스트림은 개발자가 원하는 타임에 new할 수 없다. 
		//왜?? OS가 이미 얻어다 놓았으므로.. 따라서 자바에서는 시스템으로부터 얻어올 수 있다. 
		//입력스트림의 최상위 추상 클래스이다! (키보드, 스캐너 등등은 이 스트림으로 받을 수 있다. )
		InputStream is = System.in;
		
		//한글이 깨지지 않도록 문자기반으로 업그레이드
		InputStreamReader reader = new InputStreamReader(is);//바이트 기반을 문자기반 스트림으로 변경한다.
		BufferedReader buffr= new BufferedReader(reader); //버퍼처리된 문자기반의 입력스트림 한줄씩 입력처리..
		
		int data;
		String str =null;
		try {
			while(true) {
			str = buffr.readLine(); //1분자 읽음 			
			System.out.print(str);
			}
			} catch (IOException e) {
			 e.printStackTrace();
		}
	}
}
