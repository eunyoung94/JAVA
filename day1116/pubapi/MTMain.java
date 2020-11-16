package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MTMain extends JFrame{
	//서쪽영역
	JPanel p_west;
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	//센터영영 
	Vector data = new Vector();
	//Vector<Mountain> data=new Vector<Mountain>(); //제너릭 타입이 아니라 뭔가 허접하다.. 제너릭타입으로 알맞는 자료형은 과연 뭘까..? 
	
	//컬럽 제목 정보를 담는 백터 
	Vector<String>columnName=new Vector<String>();

	JTable table;
	MountainModel model;
	JScrollPane scroll;
	//JTable에서 데이터 연동시 지금까지는 이차원 배열만 써왔는데, 사실 이차원 배열은 생성시 크기를 정해야 하기 때문에 불편한 점이 많다.
	// 불편했던 예 rx.last()후 rs.getRow()로 데이터 총 수 구하고, 다시 커서를 원상복귀시킴, 
	//따라서 컬렉션 프레임웍중 Vector를 지원하는 생성자를 이용해보자! 
	public MTMain() {
		init();
		p_west=new JPanel();
		t_name=new JTextField();
		t_op1=new JTextField();
		t_op2=new JTextField();
		t_op3=new JTextField();
		bt=new JButton("검색");
		table = new JTable(data,columnName); //매개변수로 백터를 넣어주기 
		scroll=new JScrollPane(table);
		
	//스타일적용
		p_west.setPreferredSize(new Dimension(200,600));
		p_west.setBackground(Color.WHITE);
		t_name.setPreferredSize(new Dimension(190,30));
		t_op1.setPreferredSize(new Dimension(190,30));
		t_op2.setPreferredSize(new Dimension(190,30));
		t_op3.setPreferredSize(new Dimension(190,30));
	
		//부착
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west,BorderLayout.WEST);
		add(scroll);
		
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
		//벡터값을 초기화하자, 이 메서드를 생성자에서 호출하자!
		public void init(){
			//데이터 1건 넣어보기 
			//코드를 아래와 같이 바꾸셔야한다.  JTable에 백터를 매개변수로 넣는 방식은 객체 지향적인 개발방식에 맞지 않음. 
			//이유) 백터안에 백터를 넣어야하므로, 이차원 배열 방식과 다를바가 없다. 따라서, 아래와 같이 백터안에 또하나의 백터를 추가해야한다. 
			Vector v= new Vector();
			v.add("1");
			v.add("설악산");
			v.add("강원도");
			v.add("3000");
			
			data.add(v); //백터안에 백터! 결국 이차원 배열 모습 그대로 유지 ! 백터를 넣는것을 강제한다.(옛날방식)
 			//컬럼정보 채우기 
			columnName.add("ID");
			columnName.add("산이름");
			columnName.add("소재지");
			columnName.add("높이");
		}
	
		public static void main(String[] args) {
		new MTMain();
	}
}
