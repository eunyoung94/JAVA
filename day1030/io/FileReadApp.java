package day1030.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//stream이란? 현실에서 흐르는 물줄기를 의미 
	/* 전산에서는 흐름의 대상이 물이 아닌 데이터 
	but전산에서는 흐름의 방향에 따라 다음과 같이 분류 (기준은 실행중인 프로그램)
	입력 (input) : 실행중인 프로그램으로 데이터가 흘러들어가는것 
	출력 (output) : 실행중인 프로그램으로 데이터가 흘러나오는것 
	자바에서는 입출력과 관련된 패키지명이 java.io이다. 여기에는 입출력처리를 위한 많은 api를 지원
	예외란? 프로그램이 정상 실행 되어질 수 없는 예외적인 상황을 의미한다. 
	에러가 발생하면? 프로그램이 비정상 종료되어버린다. 

	예외처리의 목적이란? 비정상 종료의 방지.. 원인을 분석할 수 있다..
	컴파일러가 하라는대로..컴파일 에러발생시 사용
	*/
public class FileReadApp {
//파일을 대상으로 데이터를 읽어들이는 fileInputstream을 학습해본다.
	FileInputStream fis;
	public FileReadApp() {
		File file = new File("C:/Users/최은영/eclipse-workspace/seproject/res/data/memo.txt");
		
		//로컬상의 파일을 대상으로 스트림(관)을 생성하자
		try{//이 영역은 에러가 발생할 가능성이 있는 코드임을 명시..
			fis = new FileInputStream(file);
			System.out.println("스트림 생성 성공입니다 ");
			//SUN 사에서 미리, 가능성있는 에러를 객체화 시켜놓은것 중에 하나..fis는 빨대역할..
			//만일 우려했던 에러가 발생하면, jvm에 의해 FileNotFoundException인스턴스가 메모리에 올라오고 catch문으로 인수를 전달하여, 개발자로 하여금 에러에 대한 정보를 
			//분석할 수 있는 기회를 주는것이다. 
			int data; 
			
			while(true) {//무한루프
			data = fis.read();//1byte읽어들이기..
			if(data==-1)break;//파일의 끝에 도달하면, 반복문 빠져나옴..
			System.out.print((char)data); //key코드값이 출력되니 char를 붙여서 형변환을 해주자..
			}
			
		}catch(FileNotFoundException e) {//혹여나 우려했던 에러가 발생한다면, 비정상 종료하지말고, 실행부는 이 catch문 블럭을 수행하라
			System.out.println("지정한 파일을 찾을 수 없습니다..");
			e.printStackTrace();//stack 구조로, 에러의 원인을 출력하자!에러처리 매우중요!
		}catch(IOException e){
			System.out.println("파일을 읽을 수 없습니다..");
			e.printStackTrace();
		}finally {
			//이 영역은 실행부가 try문을 수행하던, catch문을 수행하던 무조건 거쳐서 가야하는 영역이다. 
			//이 영역에 자원을 닫는 코드를 작성해야한다. 주로 DB와의 연결끊기, 스트림 연결끊기 
			if(fis != null) {//메모리 존재할때만, db,stream 닫을땐 반드시 null 여부를 따져보는 습관을 갖자
					try {
						//null이 아닐때만..
						fis.close();//스트림 닫음.. shift alt z --->try catch block
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
