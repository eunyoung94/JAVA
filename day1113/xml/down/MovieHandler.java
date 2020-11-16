  
/*
 * SAX 방식의 파싱을 지원하는 핸들러
 * 
 * */
package day1113.xml.down;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MovieHandler extends DefaultHandler{
	//DefaultHandler는 SAX에서 제공되는 네가지 기본 핸드러 org.xml.sax외에도 helpers패키지에 포함되어있다. 
	//기본 핸들러가 제공하는 모든 이벤트 메소드가 구현되어 있는 클래스이다. 그러므로 DefaultHandler를 상속받아 필요한 이벤트 메소드만 재정의(Overriding)해서 사용하면 된다.! 
	ArrayList<Movie> movieList; //Movie를 담고 있는 arraylist를  movieList라고부르자. 
	Movie movie;
	boolean isTitle;
	boolean isUrl;
	
	public void startDocument() throws SAXException {
	}

	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("movies")) { //xml파일 안에서 movies라는 구문을 만나면!  movieList에 배열을 담기시작!! 
			movieList = new ArrayList<Movie>();
		}else if(tag.equals("movie")) {
			movie = new Movie(); //비어 잇는 인스턴스 생성
		}else if(tag.equals("title")) {
			isTitle=true; //true할때 담기! 
		}else if(tag.equals("url")) {
			isUrl=true;
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length); //케릭터 배열을 문자열로 변환
		if(isTitle) {
			movie.setTitle(data); //제목담기! 
		}else if(isUrl) { //url담기! 
			movie.setUrl(data);
		}
	}

	public void endElement(String uri, String localName, String tag) throws SAXException {
		//flag 값 다시 돌려놓기
		if(tag.equals("title")) {
			isTitle=false;
		}else if(tag.equals("url")) {
			isUrl =false;
		}else if(tag.equals("movie")) {
			movieList.add(movie);
		}
	}

	public void endDocument() throws SAXException {
		for(Movie obj : movieList) {
			System.out.println(obj.getTitle());
			System.out.println(obj.getUrl());
			System.out.println("-------------------------------------------");
		}
	}
	
}
