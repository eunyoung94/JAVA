package day1028.grahpic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas{
	Toolkit kit; //플랫폼(os의 종류, win mac linux)에 따라 앎랒게 자원을 가져올 수 있도록 해주는 객체이다. 
	Image img; // 얘도 추상임, 근데 Toolkit을 통해 인스턴스를 얻을 수 있음..
	public MyCanvas() {
		kit=Toolkit.getDefaultToolkit(); //자체 클래스 메서드(static)를 통해 인스턴스 얻는방식 
		img=kit.getImage("C:/Users/최은영/eclipse-workspace/seproject/res/travel/aa.jpg");//윈도우 os 이기때문에 하드디스크 경로를 매개변수로 넣어준다. 
	}
	//부모인 켄버스가 보유한 paint메서드를 무시해버리고, 우리상황에 맞게 재정의하자! 오버라이드. over ride
	//매개변수인 Grahpics 객체는 현실에서의 팔레트와 비유할 수 있음..단순히 색만 관여하는 것이아니라, 도형,텍스트,이미지, 선,점 등 다양한 그래픽 처리를 위한 기능을 지원하는 실질적 그래픽 처리 담당자이다.
	public void paint(Graphics g) {
		g.drawLine(50,50, 300, 350); //캔버스에 선그리기 
		g.drawOval(0, 50, 200, 200);// 타원형그리기
		g.drawRect(50, 100, 100, 200);//사각형그리기

		//붓의 페인트 색상변경 
		g.setColor(Color.RED);
		g.fillRect(200,100,50, 50);
		
		g.setColor(Color.BLUE);
		g.drawString("이건그림그림", 50,200);
		
		//Image : 이비지를 표현한 객체 
		// 				일반이냐,추상, 인터페이스냐 조사하기 ,조사해보니 추상클래스이다.! 
		//추상클래스인 경우, 개발자가 자식클래스로 구연후, 자식을 new해서 사용해야 함이 원칙이지만. sun사가 제공해주는 대부분의 추상클래스는 사실, 
		//이미 인스턴스를 생성해놓고 간접적으로 쉽게 얻는 메서드를 재공해준다. 
		// 얻은 메서드를 제공해주거나, 인스턴스를 얻을 수 잇는 자체 메서드를 지원해주는 경우가 더 많다. 
		//시스템에 하드디스크 경로를 이용하여 이미지를 가져올 경우엔, 플랫폼을 통해 이미지 객체를 가져올 수 있는
		//Toolkit객체를 이용해야하므로, 이미지를 얻기전에 우선 툴킷 객체를 얻어와야한다.
		g.drawImage(img, 20, 20, this);//이미지 관찰자(observer)를 캔버스로 하면된다. 
	}
}
