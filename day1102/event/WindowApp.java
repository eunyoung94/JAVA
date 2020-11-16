package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowApp extends JFrame{
	String str;
	public WindowApp() {
		this.addWindowListener(new WindowAdapter() {// 이름 없는 클래스 / 내부 익명 클래스
					public void windowClosing(WindowEvent e ) {
					System.out.println("Window closing");
					System.exit(0); //프로세스종료 
				}
		});
		setSize(300,400);
		setVisible(true);
	}
	//오라클 접속 
	public void connect() {
		//드라이버로드! 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args) {
		new WindowApp();
	}

}
