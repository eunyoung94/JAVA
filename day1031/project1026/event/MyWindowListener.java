package event;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
/*윈도우창을 대상으로 발생할 수 있는 이벤트를 감지하는 리스너 구현하기*/
public class MyWindowListener implements WindowListener{
		
		public void windowActivated(WindowEvent e){
			System.out.println("윈도우가 MyWindowListener실행됩니다");//현재창을 활성화시킬때 (커서가 현재창에 올라왔을때)
	}
		public void windowClosed(WindowEvent e){//창이 닫히면
			System.out.println("윈도우가 windowClosed 실행됩니다");
	}
		public void windowClosing(WindowEvent e){//x(닫기버튼)눌렀을때, 창이 닫히지는 않음 
			System.out.println("윈도우가 windowClosing 실행됩니다");
	}
		public void windowDeactivated(WindowEvent e){//아이콘화의 반대
			System.out.println("윈도우가 windowDeactivated실행됩니다");
	}
		public void windowDeiconified(WindowEvent e){//다시커지는것 최대화
			System.out.println("윈도우가 windowDeiconified실행됩니다");
	}
		public void windowIconified(WindowEvent e){//최소화버튼을 눌러 아이콘화시킬때
			System.out.println("윈도우가 windowIconified실행됩니다");
	}
		public void windowOpened(WindowEvent e){//창이뜰때
			System.out.println("윈도우가 windowOpened실행됩니다");
	}


}
