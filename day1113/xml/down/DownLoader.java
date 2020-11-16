package day1113.xml.down;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import fileCommon.FIleManager;

public class DownLoader extends JFrame {
	// 필요한것을 세팅 ! 밑작업을 해둔다.
	JButton bt_down;
	JProgressBar bar; // 진행모양의 바
	MovieHandler movieHandler; // 무비핸들러 클라스를 멤버변수로
	Thread parsingThread; // 쓰리드를 생성해준다.

	public DownLoader() {// 퍼블릭 다운을 생성해준다.
		// 밑장업한것들을 바탕으로 새롭게 생성해준다.
		bt_down = new JButton("다운로드");// 다운로드라는 버튼을 생성해준다.
		bar = new JProgressBar();
		// 바에 스타일 생성해주기 ,
		bar.setPreferredSize(new Dimension(580, 55)); // 바 사이즈는 가로 580* 세로 55
		bar.setForeground(Color.GREEN);// 바의 앞면에 깔릴 색은 그린
		bar.setBackground(Color.BLACK);// 바의 뒷면에 깔린 색은 검정

		bar.setFont(new Font("Verdana", Font.BOLD, 25)); // Verdana 폰트 , 두껍게 , 25사이즈로 새로운 폰트를 만들고 set시켜준다.
		bar.setStringPainted(true); // 바에 퍼센트 올라가는 것을 출력할 수 있는 기능을 탑제시켜주기 true로 하면 퍼센트가 올라감..
		bar.setValue(35); // 값을 35 퍼센트로 설정해주기

		setLayout(new FlowLayout()); // 레이아웃 설정해주기 .. 플로우 레이아웃을 만들어서 set해주기!
		add(bt_down);// 레이아웃을 생성해줬으니 그 안에 버튼담기
		add(bar);// 바도 담기!

		// 파싱쓰리드라는 메서드를 만들기.. 멤버변수에 선언했음! // 쓰리드는 메인에 들어가면 안됨.. 따로빼주기
		bt_down.addActionListener((e) -> {
			parsingThread = new Thread() { // new해서 클래스 생성해주면됨
				public void run() { // run이라는 메소드 만들어 주기 .. run을 시작하면 parsedata를 실행하게끔..
					parseData();// parseData라는 메서드를 출력
					System.out.println(movieHandler.movieList.size());
					int len=movieHandler.movieList.size();
					for (int i = 0; i < movieHandler.movieList.size(); i++) { // 위 멤버변수로 MovieHandler movieHandler; 했음..
						// movieHandler 안에있는 movieList 사이즈만큼 반복되게!
						Movie movie = movieHandler.movieList.get(i);// 영화 추출하기.. movie에 movieHandler 안에있는 movieList를 차례로
																	// 하나씩 얻어온다.
						download(movie.getUrl()); // movieList에 있는 내용물들이 담긴 movie에 getUrl()을 사용하여 url을 얻어온다
					}
					//반복문이 모두 수행된 이후 시점이 바로, 다운로드가 모두 완료된 시점이다. 
					JOptionPane.showMessageDialog(DownLoader.this,"총 "+len+"개의 파일 다운완료");
				}
			};
			parsingThread.start(); // 파싱스리드라는 메서들 만들기. 그 메서드를 .start()를 붙여서 시작해주기..
		});

		setSize(600, 200); // 윈도우에 뜨는창의 크기 가로 600*세로200
		setVisible(true);// 윈도우 창에 보이도록
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 윈도우끌때 안에 jvm죽이기
		setLocationRelativeTo(null); // 가운데 뜨게
	}

	public void parseData() {
		// xml을 파싱하여 url만 추출해야 함!!
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser(); // 파서객체 생성
			URL url = this.getClass().getClassLoader().getResource("res/marvel.xml");
			File file = new File(url.toURI());
			saxParser.parse(file, movieHandler = new MovieHandler());// 파싱 시작!!!
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 인터넷상의 자원과 연결한 후, 스트림으로 데이터를 읽어와! 로컬하드에 저장하자!
	public void download(String path) { // 매개변수를 통해서 가져올 자원을 지정한다.
		// 자바에서 데이터는 스트림(Stream)을 통해 입출력 됩니다. InputStream 입력받을때 쓰는 스트림 빨아들일떄!
		InputStream is = null; // 입력스트림을 초기화 시키고
		FileOutputStream fos = null; // 출력스트림도 초기화!
		int total = 0; // 다운로드 받을 자원의 총 바이트수
		int readCount = 0; // 현재까지 읽은 바이트수
		bar.setValue(0);// 프로그래스바 초기화
		try {

			URL url = new URL(path); // path안에 있는 url을 받아오고! 그것을 새롭게 생성된 url에 넣어주고. 연결시켜준다.
			URLConnection con = url.openConnection(); // url 생성후 ! url에서 커넥션생성 ! 그리고
			// URL 객체를 다른 클래스의 객체로 바꾸어서 더 다양한 메소드를 사용할 필요가있다. 그렇게 객체를 바꾸는데 이용되는것이 바로
			// openConnection() 메소드이다.
			HttpURLConnection http = (HttpURLConnection) con; // 웹에 특화된 커넥션 객체! http URL을 처리할 때 도움이 되는 몇 가지 추가적인 메서드를
																// 가지고 있다
			http.setRequestMethod("GET"); // GET이라는 메소드를 가져온다.
			total = con.getContentLength();// 연결된 자원의 총 바이트 반환

			is = http.getInputStream(); // http에서 인풋스트림얻어서 is에 넣기.
			long time = System.currentTimeMillis(); // 파일명으로 사용하자 , System.currentTimeMillis() -->현재시각을 나타내는 long 값이며,
													// 1/1000초의 값을 리턴한다.
			String ext = FIleManager.getExtend(path);
			String filename = time + "." + ext; // 최종으로 부여된 파일명
			System.out.println("생성된 파일명은" + filename);

			fos = new FileOutputStream("C:/Users/최은영/eclipse-workspace/seproject/res/DownLoad/" + filename);
			int data = -1;// data가 -1이라는건, 값이 없다는것.
			while (true) {
				data = is.read(); // 데이터는 is=http.getInputStream(); , 여기서 is란 http에서 스트림을 얻어들인것, 그것을 읽혀서 data에
									// 넣어둔다.
				readCount++;

				bar.setValue((int) getPercent(readCount, total)); // int형을 인수로 넣어야하므로, 형변환하자 ! bar에 벨류값을 점점 채워놓아라~
				System.out.println((int) getPercent(readCount, total));// test
				if (data == -1)
					break; // 데이터가 -1일때 멈춘다.. (다 읽어들이면)
				fos.write(data);// fileoutputStream 에 있는 출력시스템에 data값을 넣는다.
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	// 퍼센트르르 구하는 메서드 정의
	public float getPercent(int read, float total) {
		// 읽은수 / 총 바이트수 *100
		return (read / total) * 100;
	}

	public static void main(String[] args) {
		new DownLoader();
	}
}
