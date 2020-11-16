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

public class ChatC extends JFrame implements KeyListener,ActionListener{ //인터페이스는 다중으로 이용가능하다 아주좋다!
	
	JTextArea area;
	JTextField t_input; 
	JScrollPane scroll;
	JButton bt;
	JPanel p_south;
	private ChatA chatA; //private는 같은 클래스 안에서만 사용가능.. 지금 이 코드는 ChatB를 가져다 쓴다는것이고 ChatB를 chatB로 부른다는 소리임
	private ChatB chatB;
	
	public ChatC() {
	//나보다 부모가 먼저 태어나야함, 나(chatA)의 부모는 윈도우(JFrame)
		super("chatC창");
		
		area = new JTextArea();
		t_input = new JTextField(10);
		scroll = new JScrollPane(area);
		bt=new JButton("send");
		p_south = new JPanel();
	
		//패널 조립 (패널은 디폴트가 FlowLayout)
		p_south.add(t_input); //panel south..에 t_input(텍스트공간)을 넣어주기
		p_south.add(bt);//버튼도 넣어주고
	
		add(scroll);
		add(p_south, BorderLayout.SOUTH);//남쪽패널에 부착 
		
		//스타일 적용 
		 area.setBackground(Color.ORANGE);
		 t_input.setBackground(Color.WHITE);
		 bt.setBackground(Color.PINK);
		 t_input.setPreferredSize(new Dimension(250,30));
		 
		 //보여주기 전에 미리 연결해놓자(컴포넌트와 리스너 연결) keylistener은 타자를 쳤을때! 반응하는것, text input하는 곳에 내가 타자를 쳤을때 반응하게 만들어준다!
		 t_input.addKeyListener(this); //프레임이 곧 리스너이다..---->프레임에 귀달림
		 //send버튼에 리스너 연결 
		 bt.addActionListener(this);
		 //open버튼에 리스너 연결 
	
		 
		 setBounds(800,150,300,400); //300*400인 크기의 창이 뜨고 x축의위치는 200, y축의 위치는 150
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
		
		//지금 현재창 ChatC에서 입력을 해서 .. area에 값이 올라가면 chatA와 chatB area에도 동일하게 msg가 올라가야됨..
		chatA.area.append(msg+"\n");
		chatB.area.append(msg+"\n");
	}
	
	 	public void setChatA(ChatA chatA) {
		this.chatA=chatA;
		// ChatB가 갖고있는 chatA = (ChatA에서 넘겨받은 chatA)
		//덮어씌어져서 현재 갖고있는게 chatA에서 넘겨받은 값이 되는것!
	 	}
	 	
	 	public void setChatB(ChatB chatB) {
		this.chatB=chatB;
		}
	//main메서드 호출이 필요없다! 왜나하면 ChatA에서 open버튼을 누르면 거기서 호출이 되기때문
}
