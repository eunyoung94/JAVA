package day1029.collection;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import day1029.DetailPanel;

public class choiceImg extends JFrame{
	String dir = "D:/workspace/js_workspace/images/";
	String[] path= {
			"1.jpg",
			"2.jpg",
			"3.jpg",
			"4.jpg",
			"5.jpg",
			"6.jpg",
			"7.jpg",
	};
	JPanel p_west;
	DetailPanel p_center;
	ThumbPanel[] thumb = new ThumbPanel[path.length];//path.length만큼 공간확보 
	
		public choiceImg() {
			p_west = new JPanel();
			p_center=new DetailPanel();
			
			//캔버스 생성 및 조립
			for(int i=0;i<thumb.length;i++) {
			thumb[i]=new ThumbPanel(dir+path[i],p_center);
			p_west.add(thumb[i]);//캔버스를 왼쪽패널에 부착
			}
			add(p_west,BorderLayout.WEST);
			add(p_center);
			
			setSize(770,600);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	public static void main(String[] args) {
		new choiceImg();
	}

}
