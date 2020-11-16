//글씨 크기조절 ctrl + (-,+키)
//폰트 window > preferences>General>Appearance>Color and Fonts> Basic>Text Font >Verdana체 선택
//단축키 모두보기 ctrl + shift +L
//자동 import : 해당 클래스에 커서 올려놓고 , ctrl + shift + O
//자동 코드정렬 : ctrl + shift + F
//해당 객체의 api문서 바로가기 : 해당 클래스 커서 올린 후 shift + F2(기능키) 인터넷 연결이 전제됨
//출력 sout 이라는 단축단어 입력과 동시에 ctrl+space
//블럭 지정후 alt키를 누르고 방향키 위 아래로 블록이동가능.
//ctrl+space --->자동완성
//ctrl + alt ---> 블록복사하기

package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame {
	//자바에서는 체크박스를 라디오로 사용한다. 
	CheckboxGroup group;
	public RadioTest() {
		group = new CheckboxGroup();
		setLayout(new FlowLayout());

		this.add(new Checkbox("운동",group,false));
		this.add(new Checkbox("독서",group,false));
		this.add(new Checkbox("컴퓨터",group,false));
		this.add(new Checkbox("요리",group,false));
		this.add(new Checkbox("영화",group,false));
		this.add(new Checkbox("도시어부보기",group,false));
		this.add(new Checkbox("두리랑낮잠자기",group,true));
		
		setSize(300,400);
		setVisible(true);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("겁나빠름 ");
		new RadioTest();
	}


}
