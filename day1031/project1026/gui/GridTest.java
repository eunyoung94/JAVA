/*
awt/swing/fx -->안드로이드
*/
package gui;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout; 
import java.awt.Panel;

class GridTest{
	public static void main(String[] args){
		Frame frame = new Frame("그리드레이아웃");

		//레이아웃 메니져 생성 및 등록 
		GridLayout layout = new GridLayout(1,3);//2행3열
		// 플로우배치에서는, 컴포넌트가 자신의 본래크기를 가질 수 있다. 
		// FlowLayout layout=new FlowLayout();-->에러뜸..GridLayout이랑 공존x
		
		//그리드를 유지하면서, 컴포넌트 크기를 유지하는방법..Panel ->배치능력이 있는 컴퍼런트.(마치 html에서 div로 영역을 나누는것과같이)
		//즉 부분적으로 다른 배치 관리자를 적용할 대 많이 사용된다.
		//
		
		frame.setLayout(layout);//프레임에 레이아웃 적용!
		Panel p = new Panel();//눈에 보이지않음..div랑 아주 흡사함
		Button b1= new Button("버튼1");
		Button b2= new Button("버튼2");
		Button b3= new Button("버튼3");
	
		//프레임에 패널넣기 
		frame.add(p);
		
		//패널에 버튼넣기 
		p.add(b1);
	
		frame.add(b2);//프레임에 버튼넣기
		frame.add(b3);//프레임에 버튼넣기
		//for(int i=0;i<9;i++){
		//	frame.add(new Button("버튼"+i));
		//}

		frame.setSize(300,200);
		frame.setVisible(true);

	}

}
