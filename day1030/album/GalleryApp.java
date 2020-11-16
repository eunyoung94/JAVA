package day1030.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class GalleryApp extends JFrame implements ActionListener{
	JPanel p_west;
	JPanel p_center;
	JPanel p_south;
	JButton bt_prev,bt_next;
	JScrollPane scroll;
	JLabel la_name; //제목나올라벨
	XCanvas can; //센터에 크게나올 이미지캔버스
	
	ArrayList<Thumb> list = new ArrayList<Thumb>(); // 썸네일 배열선언
	String dir = "D:/workspace/js_workspace/images/";
	String[] src = { "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg" };
	int n=0; //배열의 index
	public GalleryApp() {
		super("자바갤러리");
		// 생성
		p_west = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		scroll = new JScrollPane(p_west);
		la_name = new JLabel(src[n],SwingConstants.CENTER);
		can = new XCanvas(dir+src[n]);
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		
		// 썸네일생성
		for (int i = 0; i < src.length; i++) {
			Thumb thumb = null;
			list.add(thumb = new Thumb(dir + src[i],this));
			p_west.add(thumb);
		}

		// 스타일
		la_name.setPreferredSize(new Dimension(700,50));
		la_name.setFont(new Font("Verdana",Font.BOLD, 25));
		p_west.setPreferredSize(new Dimension(100, 600));
		p_center.setPreferredSize(new Dimension(700, 600));
		p_west.setBackground(Color.PINK);
		p_center.setBackground(Color.GREEN);

		// 조립
		p_south.add(bt_prev);
		p_south.add(bt_next);
		p_center.add(la_name);
		p_center.add(can);
		p_center.add(p_south);
		add(p_west, BorderLayout.WEST);
		add(p_center);

		bt_prev.addActionListener(this);//이전버튼과 연결
		bt_next.addActionListener(this);//이전버튼과 연결
		// 윈도우를 화면 중앙에 띄우는법
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();//이벤트 일으킨 컨포넌트 
		if(obj==bt_prev) {
			prev();
		}else if(obj==bt_next) {
			next();
		}
		updateData();
	}
	public void updateData() {//prev(),next()공통대이터
		can.setSrc(dir+src[n]);
		can.repaint();
		la_name.setText(src[n]+"("+(n+1)+"/"+src.length+")");  //이름도 바뀌게 설정		
	}
	public void prev() {
		if(n>=1) {
		n--;	
		}else {
			JOptionPane.showMessageDialog(this, "처음이미지입니다");
		}
	}
	public void next() {
		//그림은 XCanvas가 담당하기때문에 , 그려질 img를 변경시켜주고, 다시 그리라고 하면된다..
		//배열을 넘어서지 않는 범위내에서 ++허용
		if(n<src.length-1) {
		n++;
		}else {
			JOptionPane.showMessageDialog(this, "마지막이미지입니다");
		}
		//배열을 넘어서면 promp창 띄우기
	}

	public static void main(String[] args) {
		new GalleryApp();

	}


}
