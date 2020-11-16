package day1029;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePicker extends JFrame{
	String dir="D:/workspace/js_workspace/images/";
	String[]path= {
			"1.jpg",
			"2.jpg",
			"3.jpg",
			"4.jpg",
			"5.jpg",
			"6.jpg",
			"7.jpg",
	};
	JPanel p_north;
	DetailPanel p_center;
	ThumbCanvas[] thumb = new ThumbCanvas[path.length];
	
		public ImagePicker() {
			p_north = new JPanel();
			p_center = new DetailPanel();
			
			//캔버스 생성 및 조립 
			for(int i=0;i<thumb.length;i++) {
				thumb[i]=new ThumbCanvas(dir+path[i],p_center);
				p_north.add(thumb[i]);//캔버스를 패널에 부착
			}
			//조립
			add(p_north,BorderLayout.NORTH);
			add(p_center);
			
			setSize(770,600);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	public static void main(String[] args) {
		new ImagePicker();
	}
	
}

