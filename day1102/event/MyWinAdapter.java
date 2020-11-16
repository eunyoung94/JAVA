/*
 리스터는 인터페이스이기때문에 리스너를 구현하는자는 반드시 
 추상메서드를 재정의해야한다. 하지만, 리스너가 보유한 추상메서드의 수가 너무 많은경우에 
 사용하지 않고도 비어있는 메서드를 우리가 정의한 클래스내에 두는 것이 효율적이지 못하다. 
 따라서 sun에서는 리스너의 메서드가 3개이상일 경우, 각각의 리스너를 구현한 어댑터라는 객체를 지원해준다. 
 
 ex) WindowListener를 구현한 클래스 WindowAdaper
 		MouseListener를 구현한 클래스 MouseAdapter
 		KeyListener를 구현한 클래스 KeyAdapter
 */
package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWinAdapter extends WindowAdapter{

	public void windowClosing(WindowEvent e ) {
		System.out.println("Window closing");
		System.exit(0); //프로세스종료 
	}
}
