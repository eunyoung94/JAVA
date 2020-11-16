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
	Choice ch;//html������ select�ڽ��� ����


	public MyWin(){
		bt = new Button("click me");
		t= new TextField(15);
		ch=new Choice();

			//ch�� ������ä��� 
		ch.add("Java1 Programming/");
		ch.add("Java2 Programming/");
		ch.add("Java3 Programming/");
		ch.add("Java4 Programming/");
		ch.add("Java5 Programming/");
		
		this.setLayout(new FlowLayout());
		this.add(bt);
		this.add(t);
		this.add(ch);

		//��ư�� ������ ����! ��ü. 
		bt.addActionListener(new MyListener());//��ư�� ������ ���� 
		t.addKeyListener(new MyKey());// �ý�Ʈ�ڽ��� ������ ����
		this.addMouseListener(new MyMouse()); //�����Ӱ� ������ ����
		ch.addItemListener(new MyItem());//���̽��� �����ʿ��� 
		this.addWindowListener(new MyWindowListener());
		

		this.setSize(300,400);
		this.setVisible(true);
	}

	public static void main (String[] args){
		new MyWin();
	}
}
