package day1027.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//GUI 즉 보여지는 객체들은 거의 일반 클래스..
public class MemoApp extends JFrame{
	JMenuBar bar; //메뉴들을 올려놓을 막대
	JMenu m_file,m_edit,m_style,m_view,m_help;
	//객체자료형도 자료형이므로, 배열이 가능함..
	JMenuItem[] items; //m_file 메뉴의 하위 메뉴로 총 8개의 아이템을 추가해본다.
	String[] item_title= {"새로만들기","새창","열기","저장","다른이름으로저장","페이지설정","인쇄","끝내기"};
	JTextArea area;
	JScrollPane scroll ;//area에 붙여질 스크롤
	public MemoApp() {
		bar = new JMenuBar(); //바생성
		//메뉴생성
		m_file=new JMenu("파일");
		m_edit=new JMenu("편집");
		m_style=new JMenu("서식");
		m_view=new JMenu("보기");
		m_help=new JMenu("도움말");
		
		//아이템생성
		items = new JMenuItem[item_title.length]; // 메뉴 아이템이 생성된게 아니라, 아이템이 들어갈 자리를 8칸 확보한 상태임 
		//js 와 달리, 자바에서는 배열의 자료형이 이미 결정되면, 해당 자료형만 넣을수 있음..
		for(int i=0;i<items.length;i++) {
			items[i]=new JMenuItem(item_title[i]);
			//5번째 도달하면 구분선 추가 
			if(i==5||i==7) {
				m_file.addSeparator(); //구분선 긋기
			}
			m_file.add(items[i]);//파일메뉴에 아이템부착
		}
		
		area = new JTextArea();
		scroll=new JScrollPane(area);//스크롤 달고싶은 컴포넌트를 생성자 매개변수로 넣는다. 
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);
		
		//바는 워낙 특수성이 있기때문에 배치관리자와 상관없이 언제나 윈도우의 상단에 붙여집니다. 
		this.setJMenuBar(bar);
		//프레임에 scroll부착 
		add(scroll);
		
		//bar 스타일 적용
		bar.setBackground(Color.RED);
		m_file.setForeground(Color.BLACK);
		m_edit.setForeground(Color.BLACK);
		m_style.setForeground(Color.BLACK);
		m_view.setForeground(Color.BLACK);
		m_help.setForeground(Color.BLACK);
		
		//스타일 적용
		area.setBackground(Color.BLUE); //area 배경색 바꾸기
		area.setFont(new Font("Verdana",Font.BOLD|Font.ITALIC,20));
		area.setForeground(Color.YELLOW);
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	public static void main(String[] args) {
		new MemoApp();
	}
}
