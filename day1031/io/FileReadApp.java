package day1031.io;
/*자바에서는 입출력과 관련된 패키지명이 java.io이다. 여기에는 입출력처리를 위한 많은 api를 지원한다. 
예외란 ? 프로그램이 정상 실행 되어질 수 없는 예외적인 상황을 의미한다.
에러가 발생하면? 프로그램이 비정상 종료되어버린다.
예외처리의 목적이란? 비정상 종료의 방지, 원인을 분석할 수 있다. 
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadApp {
//파일을 대상으로 데이터를 읽어들이는 fileInputstream을 학습해보자 
	FileInputStream fis ;
	public FileReadApp() {
		//파일을 가져온다. 
		File file = new File("C:/Users/최은영/eclipse-workspace/seproject/res/data/memo.txt");
		//로컬상의 파일을 대상으로 스트림(관)을 생성하자
		try {
			fis = new FileInputStream(file);
			System.out.println("스트림 생성성공입니다. ");
			//sun사에서 미리, 가능성 있는 에러를 객체화 시켜놓은것 중 하나. fis는 빨대역할 
			//만약 우려했던 에러가 발생하면, jvm에 의해 filenotFoundException인스턴스가 메모리에 올라오고 catch문으로 인수를 전달
			//분석할 수 있는 기회를 주는것
			int data;
			
			while(true) {//무한루프 
				data = fis.read(); //1byte읽어들이기 
				if(data==-1)break;
				System.out.print((char)data);//key코드값이 출력되니 char를 붙여서 형변환을해주자  
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("지정한 파일을 찾을 수 없습니다.");
			e.printStackTrace();//stack구조로, 에러의 원인을 출력하자. 에러처리는 매우 중요하다. 
		}catch (IOException e) {
			System.out.println("파일을 읽을 수 없습니다.");
			e.printStackTrace();//에러의 발생 근원지를 찾아서 나열함
		}finally {
			//이 영역은 실행부가 try문을 수행하던, catch문을 수행하던 무조건 거쳐서 가야하는 영역이다. 
			//이 영역에 자원을 닫는 코드를 작성해야한다. 주고 db와 연결 끊기, 스트림 연결끊기
			if(fis!=null) { //FileInputStream=fis (들어오는시트림)
				//메모리가 존재할때만 , db, stream닫을 땐 반드시 null 의 여부를 따져보아야한다. 
				try {
					//null이 아닐때만 
					fis.close();//스트림 닫음..
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new FileReadApp();
	}
}
