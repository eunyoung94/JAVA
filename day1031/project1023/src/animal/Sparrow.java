/*������ �����Ѵ�. */
package animal;
public class Sparrow extends Bird{

	String name="����";

	public void jjack(){
		System.out.println("�S�S�քh�ֲ�����");
	}

	//�ڽ� Ŭ�������� �θ�� 100% ������ �޼��带 �����ϴ� ����� �������̵��̶�� �Ѵ�..(Overriding) 
	//�� �����ϴ°�..?
	public void fly(){//�θ��� �޼��带 ������ �������Ѱ���....over riding�� Ȯ�εǸ� �켱������ �ڽĿ�����(�ڽ��� ���׷��̵��Ѱ��� ��������)
		/*
		�����ε�vs�������̵�

		�����ε��� ���� Ŭ���������� ����� ����� �޼������ ���� ���θ���������,
		�Ű����� ������ �ڷ������� �����ϸ� �ߺ����Ǹ� �������ְڴ�. 

		�������̵��� ��Ӱ��迡�� �ڽ��� �θ��� �޼��带 ������ �ϴ� ���..
		*/
		System.out.println("������ ���ƿ�");
	}
	public static void main(String []args){
		Sparrow sp = new Sparrow();
		sp.fly(); //������ �޼��� ȣ�� 
		Bird bird = new Bird();
		bird.fly();//�θ��� ���� �ż��� ȣ�� 
		
		Bird bird2=new Sparrow();
		bird2.fly(); 
		sp.jjack();

	}
}
