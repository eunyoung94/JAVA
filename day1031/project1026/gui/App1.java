/*윈도우에 들어갈 수 잇는 여러 컴포넌트 알아보기 
ex) .버튼, 텍스트필드, 라디오박스,체크박스, 초이스, 이미지,textarea.... */

package gui;
import java.awt.Frame;//사용하려는 클래스의 위치등록
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;
class App1{
	public static void main(String [] args){
	/*윈도우생성*/
	/*난색 처음보는 클래스를 만났을때 대처법 
		대응,대처자세0) "사용하려는 클래스가 어떤목적으로 지원되는것인지 용도를 먼저 파악!"
		대응,대처자세1) 자바의 모든 객체는 결국 3가지 유형밖에 없다. 
		대응,대처자세1) "클래스는 쓰라고 만든것이다..따라서 메모리에 올리는 법을 알면된다!"
		1)일반클래스 : new하면된다. new뒤의 생성자조사 (api문서를통해)
		2)추상클래스 : new불가하므로, 자식을 정의해서new하거나 이미 존재하는 인스턴스를 이용하면된다. (api문서를통해)
		3)인터페이스 : new불가하므로, 자식을 정의해서 new하거나 이미 구현한 인스턴스를 이용하면된다. (api문서를통해)
	 */
	 //처음보지만, 일반이기 때문에 new 다음에 오는 생성자를 조사해서 사용하면된다. 
	Frame frame=new Frame(); //자바 윈도우 프로그래밍에서의 윈도우! 
	//프레임은 디폴트가 눈에 보이지 않는 상태임, 따라서 보이도록 메서드 호출!!
	frame.setVisible(true);//Window 객체로부터 상속받은 메서드 
	//매개변수로는 논리값을 사용할 수 있다..
	frame.setSize(300,400); //api찾기
	//윈도우가 생성되었으므로, 윈도우 안에 배치할 각종 컴포넌트를 올려보자 
	Button bt = new Button("나버튼");
	//버튼을 윈도우 컨테이너에 부착하자 

	FlowLayout flow=new FlowLayout(); 
	frame.setLayout(flow);//윈도우에 플로우 방식의 배치적용
	frame.add(bt);//add매서드는 매개변수는 Component형이므로, 
	//button도 component의 자식이기 때문에 같은 자료형에 해당하여, add()의 인수로 올 수 있다..

	//html에서 
	TextField t = new TextField("회원정보",10);
	frame.add(t);
	
	//CheckBox
	Checkbox ch1 = new Checkbox("수영");
	Checkbox ch2 = new Checkbox("음악감상");
	Checkbox ch3 = new Checkbox("독서");
	frame.add(ch1);
	frame.add(ch2);
	frame.add(ch3);

	//TextArea
	TextArea area = new TextArea(5,20); //5행 20열
	frame.add(area);

	//그냥 텍스트 
	Label la = new Label("회원가입양식입니다");
	frame.add(la);
	//이미지넣기 , Image는 추상클래스이며, 플랫폼(win,mac,linux)이 지정한 방식으로 얻을 수 있다..
	//플랫폼에 맞게 가져오려면, DefaultToolkit클래스로부터 자원을 얻어야한다..
	
	Toolkit kit=Toolkit.getDefaultToolkit();//static 메서드!! 따라서 클래스명으로 접근할 수 있다.
	//툴킷은 이미지를 로컬상의 경로로부터 얻어올 수 있다. 
	//경로사용시 주의할점 : 역슬래시는 윈도우OS에서만 사용하는 표기이므로, 자바는 모든 자바코드가 모든 OS에서 실행되려면, 사실 중립적인 경로로 가야한다..
	Image img=kit.getImage("D:/workspace/js_workspace/images/8.png");
	System.out.println("이미지 주소값은"+img); //만약 null이 나온다면 못가져온것임..
	//화면에 출력하는 수업은 오늘 불가..why? 지금까지 html에서는 이미지를 html문서에 덧붙여서 구현했으나, 자바와 같은 일반적인 컴파일 기반의 프로그래밍 언어에서는 랜더링(직접그리는작업)을 해야하기때문이다.

	}
}
