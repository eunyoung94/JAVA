package day1028.graphic.color;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPicker extends JFrame {
	JPanel p_north;//칼라들을 감쌀 수 있는 JPanel
	JPanel p_center;
	ThumbPanel[] thumb=new ThumbPanel[7]; 
	//ThumbPanel을 배열로가기
	//7가지 색상을 배열로 보유하자(반복문마다 틀린색을 사용해야하기때문)
		Color[] colorArray= {
				Color.RED,
				Color.ORANGE,
				Color.YELLOW,
				Color.GREEN,
				Color.BLUE,
				Color.PINK,
				Color.CYAN
		};
	public ColorPicker() {
		p_north=new JPanel();
		p_center = new JPanel();
		
		for(int i=0;i<thumb.length;i++) {
			thumb[i]=new ThumbPanel(p_center,colorArray[i]);
			p_north.add(thumb[i]);
		}
		p_center.setBackground(Color.WHITE);
		
		//p_north를 프레임의 북쪽에 부착해야함
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
	
		setSize(770, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ColorPicker();
	}
}
