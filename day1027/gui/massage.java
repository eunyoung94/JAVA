package day1027.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//ctrl + shift + o 한꺼번에 임폴트
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class massage extends JFrame implements KeyListener	{
//                              	is a                       is a
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	public massage() {
		
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(15);
		bt=new JButton("send");
	
		//패털조립
		p_south.add(t_input);
		p_south.add(bt);
		
		add(scroll);//센터에 스크롤 부착
		add(p_south,BorderLayout.SOUTH); //남쪽에 패널부착
		
		//스타일적용
		area.setBackground(Color.YELLOW);
		t_input.setBackground(Color.BLUE);
		t_input.setForeground(Color.WHITE);
		bt.setBackground(Color.black);
		bt.setForeground(Color.white);
		t_input.setPreferredSize(new Dimension(265,30));
		
		//보여주기 전에 미리 연결해놓자(컴포넌트와 리스너 연결)
		bt.addActionListener(new myactionListener(t_input,area));
		t_input.addKeyListener(this);//프레임이 곧 리스너다
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//어노테이션 java5부터 지원되는 일종의 주석..일반적인 주석은 프로그램에 관여하지 않지만, 어노테이션 프로그래밍에서 어떤 표시를 하기 위함이므로, 자주사용된다..
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
			//엔터키를 누르면, area에 입력 데이터를 반영하자.. (누적시키자!)
			int key=e.getKeyCode();//.e. 키코드값 반환..
		//	System.out.println("키코드값은 = "+key+" ,눌렀어~?");
			if(key==10) {		
				String msg=t_input.getText();//텍스트필드 값을 구하자..
				area.append(msg+"\n");
				t_input.setText("");//빈텍스트로 초기화
			}
		
	}

	public static void main(String[] args) {
		new massage();
	}
}
