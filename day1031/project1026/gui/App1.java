/*�����쿡 �� �� �մ� ���� ������Ʈ �˾ƺ��� 
ex) .��ư, �ؽ�Ʈ�ʵ�, �����ڽ�,üũ�ڽ�, ���̽�, �̹���,textarea.... */

package gui;
import java.awt.Frame;//����Ϸ��� Ŭ������ ��ġ���
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;
class App1{
	public static void main(String [] args){
	/*���������*/
	/*���� ó������ Ŭ������ �������� ��ó�� 
		����,��ó�ڼ�0) "����Ϸ��� Ŭ������ ��������� �����Ǵ°����� �뵵�� ���� �ľ�!"
		����,��ó�ڼ�1) �ڹ��� ��� ��ü�� �ᱹ 3���� �����ۿ� ����. 
		����,��ó�ڼ�1) "Ŭ������ ����� ������̴�..���� �޸𸮿� �ø��� ���� �˸�ȴ�!"
		1)�Ϲ�Ŭ���� : new�ϸ�ȴ�. new���� ���������� (api����������)
		2)�߻�Ŭ���� : new�Ұ��ϹǷ�, �ڽ��� �����ؼ�new�ϰų� �̹� �����ϴ� �ν��Ͻ��� �̿��ϸ�ȴ�. (api����������)
		3)�������̽� : new�Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ�ȴ�. (api����������)
	 */
	 //ó��������, �Ϲ��̱� ������ new ������ ���� �����ڸ� �����ؼ� ����ϸ�ȴ�. 
	Frame frame=new Frame(); //�ڹ� ������ ���α׷��ֿ����� ������! 
	//�������� ����Ʈ�� ���� ������ �ʴ� ������, ���� ���̵��� �޼��� ȣ��!!
	frame.setVisible(true);//Window ��ü�κ��� ��ӹ��� �޼��� 
	//�Ű������δ� ������ ����� �� �ִ�..
	frame.setSize(300,400); //apiã��
	//�����찡 �����Ǿ����Ƿ�, ������ �ȿ� ��ġ�� ���� ������Ʈ�� �÷����� 
	Button bt = new Button("����ư");
	//��ư�� ������ �����̳ʿ� �������� 

	FlowLayout flow=new FlowLayout(); 
	frame.setLayout(flow);//�����쿡 �÷ο� ����� ��ġ����
	frame.add(bt);//add�ż���� �Ű������� Component���̹Ƿ�, 
	//button�� component�� �ڽ��̱� ������ ���� �ڷ����� �ش��Ͽ�, add()�� �μ��� �� �� �ִ�..

	//html���� 
	TextField t = new TextField("ȸ������",10);
	frame.add(t);
	
	//CheckBox
	Checkbox ch1 = new Checkbox("����");
	Checkbox ch2 = new Checkbox("���ǰ���");
	Checkbox ch3 = new Checkbox("����");
	frame.add(ch1);
	frame.add(ch2);
	frame.add(ch3);

	//TextArea
	TextArea area = new TextArea(5,20); //5�� 20��
	frame.add(area);

	//�׳� �ؽ�Ʈ 
	Label la = new Label("ȸ�����Ծ���Դϴ�");
	frame.add(la);
	//�̹����ֱ� , Image�� �߻�Ŭ�����̸�, �÷���(win,mac,linux)�� ������ ������� ���� �� �ִ�..
	//�÷����� �°� ����������, DefaultToolkitŬ�����κ��� �ڿ��� �����Ѵ�..
	
	Toolkit kit=Toolkit.getDefaultToolkit();//static �޼���!! ���� Ŭ���������� ������ �� �ִ�.
	//��Ŷ�� �̹����� ���û��� ��ηκ��� ���� �� �ִ�. 
	//��λ��� �������� : �������ô� ������OS������ ����ϴ� ǥ���̹Ƿ�, �ڹٴ� ��� �ڹ��ڵ尡 ��� OS���� ����Ƿ���, ��� �߸����� ��η� �����Ѵ�..
	Image img=kit.getImage("D:/workspace/js_workspace/images/8.png");
	System.out.println("�̹��� �ּҰ���"+img); //���� null�� ���´ٸ� �������°���..
	//ȭ�鿡 ����ϴ� ������ ���� �Ұ�..why? ���ݱ��� html������ �̹����� html������ ���ٿ��� ����������, �ڹٿ� ���� �Ϲ����� ������ ����� ���α׷��� ������ ������(�����׸����۾�)�� �ؾ��ϱ⶧���̴�.

	}
}
