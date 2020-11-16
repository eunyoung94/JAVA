package day1028.grahpic.line;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener{
		XCanvas can;
		//캔버스에 주소값을 넘겨받을 메서드가 필요하다..생성자이용하자 / 주소를 넘겨받는다고 하면 무조건 메서드..
		public MyListener(XCanvas can) {
			this.can =can;
		}
		public void actionPerformed(ActionEvent e) {
			//캔버스에 선을 그리되, LineMaker 클래스의 JTextField 의값을 이용하여..
//			paint() 메서드는 개발자가 직접 호출할 수 없고, 호출해서도 안된다. 
//			paint() 메서드는 그림이 그려질 준비가 되었을때 시스템, 즉 .jvm에 의해 호출된다.
//			따라서 개발자가 원하는 타임에 그림을 갱신하게 하려면 , paint()메서드를 직접 호출해서는 안되고
//			갱신할 것을 시스템에 요청해야됨...repaint() -->다시그려달라-->update()화면 지우기 -->paint()
			can.repaint();
//			xcanvas의 paint();불가능
			
		}
}
