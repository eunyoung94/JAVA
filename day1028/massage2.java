package day1028;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//ctrl + shift + o 한꺼번에 임폴트
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class massage2 extends JFrame implements KeyListener,ActionListener{
//                              	is a                       is a
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	JButton bt_open;
	massage ms;
	public massage2() {
		//나보다 부모가 먼저 태어나야함..super(), JFrame("부모창")
		super("난 부모창");//=JFrame("부모창") 과 동일..
		//생성
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(10);
		bt=new JButton("send");
		bt_open=new JButton("open");
	
		//패털조립
		p_south.add(t_input);
		p_south.add(bt);
		p_south.add(bt_open);
		
		add(scroll);//센터에 스크롤 부착
		add(p_south,BorderLayout.SOUTH); //남쪽에 패널부착
		
		//스타일적용
		area.setBackground(Color.GREEN);
		t_input.setBackground(Color.BLUE);
		t_input.setForeground(Color.WHITE);
		bt.setBackground(Color.black);
		bt.setForeground(Color.white);
		t_input.setPreferredSize(new Dimension(265,30));
		
		//보여주기 전에 미리 연결해놓자(컴포넌트와 리스너 연결)
		bt.addActionListener(new myactionListener(t_input,area));
		t_input.addKeyListener(this);//프레임이 곧 리스너다
		
		//send버튼에 리스너 연결
		bt.addActionListener(this);
		//open버튼에 리스너연결 
		bt_open.addActionListener(this);
		
		setBounds(200, 150, 300, 400);//원하는 위치에 띄울수 있음

		//setSize(300,400);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton btn = (JButton)obj;//하위 자료형으로 변환 down casting 
		if(btn==bt){//누른버튼과 send버튼의 주소값이 같다면
		System.out.println("send버튼 눌렀어?");
		open();
		}else if(btn.equals(bt_open)){
		System.out.println("open버튼 눌렀어?");
		}
	}
	
	//메세지창에 대화내용 누적하기
	public void send() {
		String msg=t_input.getText();
		area.append(msg+"\n");
		t_input.setText("");//빈텍스트 초기화 
		
		//너에대한 채팅처리..
		ms.area.append(msg+"\n");
		ms.t_input.setText("");//빈텍스트 초기화 
		
	}
	//대화할 상대방 윈도우 띄우기
	public void open() {
		//ChatClient를 화면에 띄우기
		ms = new massage(this);
	}
	public static void main(String[] args) {
		new massage2();
	}
}
