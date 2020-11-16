package gui;
/*
import java.awt.Frame;//����Ϸ��� Ŭ���� ��ġ���
import java.awt.Button;
import java.awt.TextField;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
*/
import java.awt.*; 
class LoginForm extends Frame{
	/*has a ����� ��������� ��ü���϶��� �ǹ��Ѵ�.*/
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;//���Ϳ� �׸��带 ������ �г�
	Panel p_south;//���ʿ� ���� �г�(���⼭ ��ư2�����Ͽ���)

	public LoginForm(){

			//��ǰ����� ������ �������� ��� �ʱ�ȭ��Ű��
			//Ư�� ��ǰ�� , �� ��ü�� �¾�� ���� �Բ� �¾���ϹǷ�, �������� Ÿ�̹��� ��ġ��������
			la_id=new Label("ID");
			la_pass=new Label("Password");
			t_id=new TextField(15);
			t_pass=new TextField(15);
			bt_login=new Button("Login");
			bt_regist=new Button("����");
			p_center=new Panel();
			p_south = new Panel();

			//������ �� �����̰�, ���� �����̳� ��Ÿ���� �ο���������..
			//Frame�� �����ڰ� ���̾ƿ��� �������� ������ ����Ʈ�� BorderLayout�̴�. 
			//this.setLayout(new BorderLayout()); �ʿ����! �� ? ����Ʈ�� �̹� �������̾ƿ��̹Ƿ�..
			 //ó������ ��ü�� ���� ������, 2.�޸𸮿� �ø��¹�(�ϻ�,�߻�,�������̽�)
			 p_center.setBackground(new Color (153,255,0));
			 //�����г��� �������� BorderLayout���Ϳ� ����..
			 this.add(p_center,BorderLayout.CENTER);//BorderLayout.CENTER ��������..
			 //p_south.setBackground(new Color(255,255,0));
			 //����� �������� �ο��� �������̴�. final�� ���̻� ���� ������ �� ������, static���� �ν��Ͻ��� ������ �����ϸ�, 
			 //public ���� �����Ͽ�, ��� ��ü�� ������ �� �ֵ��� ���������� Ǯ����� ������..
			 p_south.setBackground(Color.YELLOW);//���͵���
			 this.add(p_south,BorderLayout.SOUTH);

			 //p_center�� ����
			 p_center.setLayout(new GridLayout(2,2));//2�� 2��¥�� �׸��� ����
			 p_center.add(la_id);//�󺧺��� 1��1��
			 p_center.add(t_id);//id�ؽ�Ʈ�ڽ����� 1��2��
			 p_center.add(la_pass);//�󺧺��� 2��1��
			 p_center.add(t_pass);//id�ؽ�Ʈ�ڽ����� 2��2��
			 //Panel�� �ƹ��� ��ġ�����ڸ� �������� ������ ����Ʈ�� Flowlayout�̴�. 
			 p_south.add(bt_login);
			 p_south.add(bt_regist);

			/*this�� ��Ȯ�� �ǹ�: ���۷��������̴�. �� �ڽ��� �ν��Ͻ��� �ּҰ��� ����..
			�ش��ν��Ͻ��� �ڱ��ڽ��� ����ų��
			*/
			this.setSize(400,150);
			this.setVisible(true);
	}
	public static void main (String[] args){
		new LoginForm();
	}

}

