package day1029.collection;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import day1029.DetailPanel;

public class ThumbPanel extends Canvas implements MouseListener{
	Toolkit kit;
	Image Img;
	JPanel p_west,p_center;
	//DtailPanel p_center;
	
	public  ThumbPanel(String path,DetailPanel p_center) {
		kit=Toolkit.getDefaultToolkit();//static메서드 호출 
		Img=kit.getImage(path);
		this.setPreferredSize(new Dimension(100,100));
		this.p_center=p_center;
		this.addMouseListener(this);//마우스 리스너와연결 
	}
	public void paint(Graphics g) {
		g.drawImage(Img, 0, 0, this);//observer는 관찰자
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	//마우스로 클릭할때 
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
