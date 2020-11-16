package gui;
/*
import java.awt.Frame;//사용하려는 클래스 위치등록
import java.awt.Button;
import java.awt.TextField;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
*/
import java.awt.*; 
class LoginForm extends Frame{
	/*has a 관계는 멤버변수가 객체형일때를 의미한다.*/
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;//센터에 그리드를 적용할 패널
	Panel p_south;//남쪽에 붙일 패널(여기서 버튼2개붙일예정)

	public LoginForm(){

			//부품관계로 보유한 변수들을 모두 초기화시키자
			//특히 부품은 , 이 객체가 태어날때 같이 함꼐 태어나야하므로, 생성자의 타이밍을 놓치지만말자
			la_id=new Label("ID");
			la_pass=new Label("Password");
			t_id=new TextField(15);
			t_pass=new TextField(15);
			bt_login=new Button("Login");
			bt_regist=new Button("가입");
			p_center=new Panel();
			p_south = new Panel();

			//생성만 한 상태이고, 아직 조립이나 스타일은 부여하지않음..
			//Frame은 개발자가 레이아웃을 지정하지 않으면 디폴트가 BorderLayout이다. 
			//this.setLayout(new BorderLayout()); 필요없다! 왜 ? 디폴트가 이미 보더레이아웃이므로..
			 //처음보는 객체에 대한 대응법, 2.메모리에 올리는법(일상,추상,인터페이스)
			 p_center.setBackground(new Color (153,255,0));
			 //센터패널을 윈도우의 BorderLayout센터에 넣자..
			 this.add(p_center,BorderLayout.CENTER);//BorderLayout.CENTER 생략가능..
			 //p_south.setBackground(new Color(255,255,0));
			 //상수는 직관성을 부여한 데이터이다. final로 더이상 값을 변경할 수 없으며, static으로 인스턴스간 공유가 가능하며, 
			 //public 으로 선언하여, 모든 객체가 접근할 수 있도록 접근제한을 풀어놓은 데이터..
			 p_south.setBackground(Color.YELLOW);//위와동일
			 this.add(p_south,BorderLayout.SOUTH);

			 //p_center에 적용
			 p_center.setLayout(new GridLayout(2,2));//2행 2열짜리 그리드 적용
			 p_center.add(la_id);//라벨부착 1행1열
			 p_center.add(t_id);//id텍스트박스부착 1행2열
			 p_center.add(la_pass);//라벨부착 2행1열
			 p_center.add(t_pass);//id텍스트박스부착 2행2열
			 //Panel은 아무런 배치관리자를 적용하지 않으면 디폴트가 Flowlayout이다. 
			 p_south.add(bt_login);
			 p_south.add(bt_regist);

			/*this의 정확한 의미: 레퍼런스변수이다. 나 자신의 인스턴스의 주소값을 가진..
			해당인스턴스가 자기자신을 가리킬때
			*/
			this.setSize(400,150);
			this.setVisible(true);
	}
	public static void main (String[] args){
		new LoginForm();
	}

}

