package event;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
/*������â�� ������� �߻��� �� �ִ� �̺�Ʈ�� �����ϴ� ������ �����ϱ�*/
public class MyWindowListener implements WindowListener{
		
		public void windowActivated(WindowEvent e){
			System.out.println("�����찡 MyWindowListener����˴ϴ�");//����â�� Ȱ��ȭ��ų�� (Ŀ���� ����â�� �ö������)
	}
		public void windowClosed(WindowEvent e){//â�� ������
			System.out.println("�����찡 windowClosed ����˴ϴ�");
	}
		public void windowClosing(WindowEvent e){//x(�ݱ��ư)��������, â�� �������� ���� 
			System.out.println("�����찡 windowClosing ����˴ϴ�");
	}
		public void windowDeactivated(WindowEvent e){//������ȭ�� �ݴ�
			System.out.println("�����찡 windowDeactivated����˴ϴ�");
	}
		public void windowDeiconified(WindowEvent e){//�ٽ�Ŀ���°� �ִ�ȭ
			System.out.println("�����찡 windowDeiconified����˴ϴ�");
	}
		public void windowIconified(WindowEvent e){//�ּ�ȭ��ư�� ���� ������ȭ��ų��
			System.out.println("�����찡 windowIconified����˴ϴ�");
	}
		public void windowOpened(WindowEvent e){//â�̶㶧
			System.out.println("�����찡 windowOpened����˴ϴ�");
	}


}
