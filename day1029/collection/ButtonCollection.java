package day1029.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonCollection extends JFrame implements ActionListener{
	JButton bt_1,bt_2;
	JPanel p_north,p_center;
	JTextField t_input;
	//배열은 크기를 정해야 하기때문에 , 크기를 알 수 없는 프로그램에선 사용에 제한이 있다.
	//JButton[] btn = new JButton[]; //배열은 생성시 반드시 크기를 명시해야한다.
	ArrayList<JButton>btn = new ArrayList<JButton>();//크기가 0이다.
	
	public ButtonCollection() {
		bt_1=new JButton("생성");
		bt_2=new JButton("배경색");
		p_north=new JPanel();
		p_center=new JPanel();

		
		p_north.setBackground(Color.WHITE);
		this.setBackground(Color.GRAY);
		bt_1.setBackground(Color.ORANGE);
		bt_2.setBackground(Color.ORANGE);
		
		p_north.add(bt_1);
		p_north.add(bt_2);
		//프레임에 부착
		add(p_north,BorderLayout.NORTH);
		add(p_center);

		
		//리스너와 연결 (bt_1을 누르면 center에 버튼이 생성되는것.)
		bt_1.addActionListener(this);
		bt_2.addActionListener(this);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new ButtonCollection();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
	Object obj = e.getSource();
		if(obj==bt_1) {
			create();//메서드빼기
		}else if(obj==bt_2) {
			setBg();
		}		
	}
	
	public void create() {
		//버튼을 생성하여, p_center 부착 
		JButton bt=new CustomButton();
		p_center.add(bt);
		
		btn.add(bt);//리스트에 추가하기 !js의 push()메서드와 같다
		System.out.println("현재까지 누적된 리스트의 수는 "+btn.size());
		bt.setText("버튼"+Integer.toString(btn.size())); //integer.toString 문자를 숫자로..?
		//p_center에 버튼을 그린게 아니라, 버튼을 추가한 것이다. 따라서 이때는 p_center를 갱신하면된다..updateUI
		p_center.updateUI();
	}
	public void setBg() {
		//btn 리스트에 들어있는 모든 요소를 대상으로 배경색 바꾸기
		//ArrayList는 순서있는 집합이므로, for문을 사용할 수 있다. 
		for(int i=0;i<btn.size();i++) {
			JButton bt =btn.get(i);
			bt.setBackground(Color.YELLOW);
		}
	}
}
