package day1103.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class KeyBoardFileApp {
	String dir;
	FileWriter writer;

	public KeyBoardFileApp() {
		URL url = this.getClass().getClassLoader().getResource("res/");

		try {
			URL url2 = new URL(url,"empty.txt"); //디렉토리 + 파일명
			URI uri = url2.toURI();
			System.out.println(uri);
			writer = new FileWriter(new File(uri));
		}catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//alt + shift + z --->try catch

	public void SaveFile() {
		InputStream is = System.in; // 바이트(영어)
		// 문자로 바꿔줌..빨대에 피복을 입혀줘서 업그레이드시켜줌! 2byte씩 읽어들일 수있다.
		InputStreamReader reader = new InputStreamReader(is);
		// 버퍼기반의 문자 스트림 , 버퍼는 줄바꿈표시가 있을경우 읽어들임..
		BufferedReader buffr = new BufferedReader(reader);
		// 파일 출력 스트림 계열은 (empty)빈파일을 생성해준다.
		// FileWriter writer = new FileWriter();

		String msg = null;
		try {
			msg = buffr.readLine();
			System.out.println(msg); // 모니터에 출력
			writer.write(msg);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new KeyBoardFileApp().SaveFile(); //생성과 동시에 메서드 호출 
	}
}
