package day1105db;
/*
 스윙 컴포넌트중 , 이차원 구조의 데이터(표)를 표현하기에 최적화된 JTable을 사용해보자
 
 */

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class tableApp extends JFrame{
	JTable table;
	String[] column = {"번호","이름","연락처","주소","성별"};
	String[][]data = {
			{"1","Batmam","011","고담","남"},	
			{"2","love","013","뉴욕","남"},	
			{"3","ann","012","하와이","여"}	
	};
	JScrollPane scroll;
	public tableApp() {
		// TODO Auto-generated constructor stub
		table = new JTable(data,column);//row 3 col 5
		scroll=new JScrollPane(table);
		
		setLayout(new FlowLayout());
		add(scroll);//CENTER
		
		//마우스이벤트 구현 
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				//System.out.println("눌렀니..?");
				int col = table.getSelectedColumn();//유저가 선택한 컬럼 index(호수)
				int row = table.getSelectedRow();//유저가 선택한 row(층수)
				System.out.println("좌표 ("+row+","+col+")");
				String value=(String)table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new tableApp();
	}
}
