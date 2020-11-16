package day1029;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ThumbCanvas extends Canvas implements MouseListener{
	Toolkit kit; 
	Image img;
	private DetailPanel p_center;
	
	public ThumbCanvas(String path,DetailPanel p_center) {//string 으로 경로를 넘겨받자
		kit=Toolkit.getDefaultToolkit(); //static메서드 호출 
		img=kit.getImage(path);
		this.setPreferredSize(new Dimension(100, 100));
		this.p_center =p_center;
		
		this.addMouseListener(this);//마우스 리스너와연결 
		
	}
//도화지에 그림을 그리자! 모든 컴포넌트는 스스로 그림의 주체이자, 그려질 대상이기도 하다 
	public void paint(Graphics g) {
		g.drawImage(img,0,0,this);
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
		//p_center 패널에 , 이미지를 그리되,현재 나의 이미지를 가지고..
		//p_center에게 나의 img를 전달해야한다!
		p_center.setImg(img); //p_center에게 나의 img를 전달해야한다..
		p_center.repaint(); //다시그려라 -->update()화면지우기 ->paint() 그리기
		
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
