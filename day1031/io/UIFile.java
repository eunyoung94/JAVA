package day1031.io;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UIFile extends JFrame implements ActionListener{
	JLabel la_ori,la_dest;
	JTextField t_ori,t_dest;
	JButton bt;
	
	public UIFile() {
		la_ori=new JLabel("원본경로");
		la_dest=new JLabel("복사할 경로");
		t_ori=new JTextField(50); //텍스트 필드안에 문자가 50개 들어갈 수 있음..
		t_dest=new JTextField(50);
		bt=new JButton("복사실행");
		
		//스타일적용
		la_ori.setPreferredSize(new Dimension(130,30)); 
		la_dest.setPreferredSize(new Dimension(130,30)); 
		t_ori.setPreferredSize(new Dimension(500,30));
		t_dest.setPreferredSize(new Dimension(500,30));
		
		//조립 
		setLayout(new FlowLayout());
		add(la_ori);
		add(t_ori);
		add(la_dest);
		add(t_dest);
		add(bt);
		
		bt.addActionListener(this);//버튼과 리스너의 연결 
		JFileChooser choose = new JFileChooser();// 파일탐색기창 열기 
		setSize(740, 180);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//윈도우 창을 닫을때 같이 닫히게
	}

	public void copy() {
		//두개의 클래스가 메모리에 올라와야 하는 시점은? 
		//메서드내의 지역변수는 반드시! 반드시 개발자가 초기화해야한다.멤버변수가 아니므로
		FileInputStream fis =null;
		FileOutputStream fos = null;
		
		String ori = t_ori.getText();//원본경로 
		String dest= t_dest.getText();//복사본경로
		
		try {
			fis = new FileInputStream(ori);
			fos = new FileOutputStream(dest);
			
			int data; //읽혀진 데이터를 받을 변수 
			while(true) {
				data = fis.read();//1byte읽기 
				if(data==-1)break;///파일끝에 도달하면 반복문 빠져나옴..
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this, "복사완료!"); // prompt창 뜨는것 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if(fos!=null) {
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//bt을 누르면 발생되는 액션이벤드! -->copy라는 메서드를 생성해준다.
		copy();
		
	}

	public static void main(String[] args) {
		new UIFile();
	}
}
