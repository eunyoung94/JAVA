package day1102.Memo;
/*
 지난주에는 문서파일(영문)과 바이너리 파일(사진)등을 복사해보았다. 하지만, 문서파일의 경우 한글이 석여 있을때 어떤 결과가 나오는지 테스트해본다 
 [스트림의 유형]
 스트림의 기본은 1byte씩 처리하는 바이트 기반의 스트림이다. 
 하지만, 스트림상으로 흐르는 데이터를 문자로 해석할 수 있는 스트림을 문자기반 스트림이라고한다. 
 문자기반스트림은 접미어가 ~Reader, ~Writer로 끝난다. 
 
 * */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemoCopy {
	FileInputStream fis;
	FileOutputStream fos;
	// 영미권 의외의 국가는 필요함... 영어는 1byte차지하니 굳이..?
	FileReader reader;// 파일을 대상으로 문자기반의 입력스트림
	FileWriter writer; // 파일을 대상으로 문자기반의 출력스트림

	String path = "C:/Users/최은영/eclipse-workspace/seproject/res/data/memo.txt";
	String path2 = "C:/Users/최은영/eclipse-workspace/seproject/res/data/memo.txt2";

	public MemoCopy() {
		try {
			// fis = new FileInputStream(path);
			// fos= new FileOutputStream(path2); //파일출력스트림은 빈파일을 생성하는 특징이 있다.
			reader = new FileReader(path);
			writer = new FileWriter(path2);
			// 한 바이트씩 읽어들이면서 영문과 한글이 어떻게 되는지 환찰해보자 한글은 2byte, 영어는 1byte
			// 결론 :FileInputStream은 byte기반의 스트림이므로 1byte씩만 해석할 수 있다 . 따라서 한글의 경우 2byte로
			// 구성되어있으므로, 복사는 성공하겠으나,
			// 스트림상에서 흐르는 데이터를 한글로 보고자 할때는 깨져서 보일 수 밖에없다.

			int data;
			while (true) {
				data = reader.read();
				if (data == -1)
					break;
				System.out.print((char) data);
				writer.write(data);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new MemoCopy();

	}

}
