/*
awt/swing/fx -->�ȵ���̵�
*/
package gui;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout; 
import java.awt.Panel;

class GridTest{
	public static void main(String[] args){
		Frame frame = new Frame("�׸��巹�̾ƿ�");

		//���̾ƿ� �޴��� ���� �� ��� 
		GridLayout layout = new GridLayout(1,3);//2��3��
		// �÷ο��ġ������, ������Ʈ�� �ڽ��� ����ũ�⸦ ���� �� �ִ�. 
		// FlowLayout layout=new FlowLayout();-->������..GridLayout�̶� ����x
		
		//�׸��带 �����ϸ鼭, ������Ʈ ũ�⸦ �����ϴ¹��..Panel ->��ġ�ɷ��� �ִ� ���۷�Ʈ.(��ġ html���� div�� ������ �����°Ͱ�����)
		//�� �κ������� �ٸ� ��ġ �����ڸ� ������ �� ���� ���ȴ�.
		//
		
		frame.setLayout(layout);//�����ӿ� ���̾ƿ� ����!
		Panel p = new Panel();//���� ����������..div�� ���� �����
		Button b1= new Button("��ư1");
		Button b2= new Button("��ư2");
		Button b3= new Button("��ư3");
	
		//�����ӿ� �гγֱ� 
		frame.add(p);
		
		//�гο� ��ư�ֱ� 
		p.add(b1);
	
		frame.add(b2);//�����ӿ� ��ư�ֱ�
		frame.add(b3);//�����ӿ� ��ư�ֱ�
		//for(int i=0;i<9;i++){
		//	frame.add(new Button("��ư"+i));
		//}

		frame.setSize(300,200);
		frame.setVisible(true);

	}

}
