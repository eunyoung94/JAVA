package day1028.grahpic.line;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LineMaker extends JFrame{
	//필요한것을 미리적어놓는다..
	JLabel la_x1,la_y1,la_x2,la_y2;
	JPanel p_north;
	JTextField t_x1,t_x2,t_y1,t_y2;
	MyButton bt;
	XCanvas can;
	
	public LineMaker() {
		
		la_x1= new JLabel("x1");
		la_y1= new JLabel("y1");
		la_x2= new JLabel("x2");
		la_y2= new JLabel("y2");

		t_x1 = new JTextField("0",10); //초기화 를 0으로 설정, 
		t_y1 = new JTextField("0",10);
		t_x2 = new JTextField("0",10);
		t_y2 = new JTextField("0",10);

		bt=new MyButton("커스텀버튼");
		p_north = new JPanel();
		can = new XCanvas();
		can.setLineMaker(this);//캔버스에게 나의 주소값 넘기기 
		
		
		can.setBackground(Color.ORANGE);
		p_north.setBackground(Color.YELLOW);
	
		//레고블럭 조립!
		
		p_north.add(la_x1);
		p_north.add(t_x1);
		p_north.add(la_x2);
		p_north.add(t_x2);
		p_north.add(la_y1);
		p_north.add(t_y1);
		p_north.add(la_y2);
		p_north.add(t_y2);
		p_north.add(bt);
		
		//부분 조립이 완성되었으므로, 최종적으로 프레임에 붙이자
		add(p_north,BorderLayout.NORTH);//프레임의 북쪽에 패널 추가
		add(can);//센터영역에 캔버스 추가
		
		//버튼과 리스너와의 연결 
		bt.addActionListener(new MyListener(can));
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LineMaker();
	}
}
