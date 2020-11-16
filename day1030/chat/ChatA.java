package day1030.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements KeyListener,ActionListener{ //인터페이스는 다중으로 이용가능하다 아주좋다!
	
	JTextArea area;
	JTextField t_input; 
	JScrollPane scroll;
	JButton bt,bt_open;
	JPanel p_south;
	private ChatB chatB; //private는 같은 클래스 안에서만 사용가능.. 지금 이 코드는 ChatB를 가져다 쓴다는것이고 ChatB를 chatB로 부른다는 소리임
	private ChatC chatC;
	
	public ChatA() {
	//나보다 부모가 먼저 태어나야함, 나(chatA)의 부모는 윈도우(JFrame)
		super("chatA창");
		
		area = new JTextArea();
		t_input = new JTextField(10);
		scroll = new JScrollPane(area);
		bt=new JButton("send");
		bt_open = new JButton("open");
		p_south = new JPanel();
	
		//패널 조립 (패널은 디폴트가 FlowLayout)
		p_south.add(t_input); //panel south..에 t_input(텍스트공간)을 넣어주기
		p_south.add(bt);//버튼도 넣어주고
		p_south.add(bt_open);
		
		add(scroll);
		add(p_south, BorderLayout.SOUTH);//남쪽패널에 부착 
		
		//스타일 적용 
		 area.setBackground(Color.YELLOW);
		 t_input.setBackground(Color.WHITE);
		 bt.setBackground(Color.PINK);
		 bt_open.setBackground(Color.PINK); 
		 t_input.setPreferredSize(new Dimension(250,30));
		 
		 //보여주기 전에 미리 연결해놓자(컴포넌트와 리스너 연결) keylistener은 타자를 쳤을때! 반응하는것, text input하는 곳에 내가 타자를 쳤을때 반응하게 만들어준다!
		 t_input.addKeyListener(this); //프레임이 곧 리스너이다..---->프레임에 귀달림
		 //send버튼에 리스너 연결 
		 bt.addActionListener(this);
		 //open버튼에 리스너 연결 
		 bt_open.addActionListener(this);
		 
		 setBounds(200,150,300,400); //300*400인 크기의 창이 뜨고 x축의위치는 200, y축의 위치는 150
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame에서는 뭐 거의 따라다니는 필수요소라고 보면되겠다..
	}

//액션퍼폼드는 1개가 뜨고, keytype는 3개가 오버라이드된다.
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트가 처음 시작된곳의 e에 담아온다... 그곳은 바로!
		Object obj = e.getSource();
		JButton btn =(JButton)obj; //부모가 자식이 되려고하는 현상...하위자료형으로 downcasting 
		
		//조건문 
		if(btn==bt) {//이벤트가 처음 시작된곳은 바로 bt 이면!
			System.out.println("버튼눌렀니?");
			send();//send(보내기)메서드 호출 .. 
		}else if(btn==bt_open) {
			System.out.println("open버튼눌렀니?");
			open();//open 메서드 호출..
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
//		문자를 눌렀을 때 호출, 문자키에만 반응합니다
	}


	@Override
	public void keyPressed(KeyEvent e) {
// 키를 눌렀다 땠을때 반응하는것, 반응속도가 느리다..
	}


	@Override
	public void keyReleased(KeyEvent e) {
//		키를 눌렀을때 바로반응하는것 , 주로 이곳에서 작업을 많이한다. 
		int key = e.getKeyCode(); //int(정수형)으로 키코드값을 받아준다. 
		if(key==10) { //이때 이벤트 키코드 10은 엔터를 뜻한다. 즉, key가 10이라는 소리는 '엔터를 쳤을때!'라고 보면된다. 
			System.out.println("엔터쳤어?");
			send();//send라는 보내는 메소드 만든것을 호출해준다. 
		}
	}
	
	//keylistener과 actionlistener에도 쓰이는 send메서드는 과연 뭘까?
	public void send() { //메소드의 return 값이 없을때 void를 사용한다. 
		String msg = t_input.getText();// msg는 문자열이며, t_input에서 . text값을 받아온다. --->이것을 msg에 넣어준다.
		area.append(msg+"\n");// textfield인 area에 msg를 더한다(append); 
		t_input.setText("");//t_input에 남겨진 값을 ""로 만들어준다. 빈텍스트로 초기화..
		
		//다른 채팅창에 대한 처리, ChatA(현재창) area에 있는 메세지가 다른 ChatB chatC area에도 동일하게 보여줘야됨.
		chatB.area.append(msg+"\n");
		chatC.area.append(msg+"\n");
	}
	
	//대화할 상대방을 윈도우에 띄우기
	public void open() {
		//ChatB와 ChatC를 화면에 띄우기
		
		chatB=new ChatB();
		chatC=new ChatC();
		
		//ChatB 한테 ChatA,ChatC를 넘겨주기 
		chatB.setChatA(this); //chatB에 있는. setChatA라는 메소드에 (this)값을 넣어주라는 뜻. setChatA이라는 키를 연결
		chatB.setChatC(chatC);//chatB에 있는 setChatC라는 메소드에 (chatC)를 넣어주라는거고..
		
		//ChatC 한테 ChatB,ChatA를 넘겨주기 
		chatC.setChatA(this);//chatC에 있는. setChatA라는 메소드에 (this)값을 넣어주라는 뜻.
		chatC.setChatB(chatB);//chatC에 있는. setChatB라는 메소드에 (chatC)값을 넣어주라는 뜻.
	}
	public static void main(String[] args) {
		new ChatA();
	}
}