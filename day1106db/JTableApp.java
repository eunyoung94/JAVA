package day1106db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 jtable은 mvc(model view controler)를 이용한 컴포넌트이다. 
 table은 (view)디자인, jtable안에 들어갈 데이터는 model --- >controler 가 data와 model을 결합시켜주는역할,
 
 */
public class JTableApp extends JFrame{
	//TableModel(인터페이스)->AbstractTableModel(클래스)
	JTable table;
	JScrollPane scroll;
	MyModel model;
public JTableApp() {
	table=new JTable(model=new MyModel());//jtable과 컨트롤러인 mymodel연결 
	scroll = new JScrollPane(table);
	add(scroll);
	setSize(400,200);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public static void main(String[] args) {
	new JTableApp();
}

}
