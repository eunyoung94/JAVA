package event;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.Choice;

class MyWin extends Frame{
	/*MyWin is a Frame*/
	Button bt; //MyWin has a bt
	TextField t;
	Choice ch;//html에서의 select박스와 동일


	public MyWin(){
		bt = new Button("click me");
		t= new TextField(15);
		ch=new Choice();

			//ch의 아이템채우기 
		ch.add("Java1 Programming/");
		ch.add("Java2 Programming/");
		ch.add("Java3 Programming/");
		ch.add("Java4 Programming/");
		ch.add("Java5 Programming/");
		
		this.setLayout(new FlowLayout());
		this.add(bt);
		this.add(t);
		this.add(ch);

		//버튼과 리스너 연결! 주체. 
		bt.addActionListener(new MyListener());//버튼과 리스너 연결 
		t.addKeyListener(new MyKey());// 택스트박스와 리스너 연결
		this.addMouseListener(new MyMouse()); //프레임과 리스너 연결
		ch.addItemListener(new MyItem());//초이스와 리스너연결 
		this.addWindowListener(new MyWindowListener());
		

		this.setSize(300,400);
		this.setVisible(true);
	}

	public static void main (String[] args){
		new MyWin();
	}
}
