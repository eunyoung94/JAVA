package string;
class StringTest{
	public static void main(String[] args){
	//�Ʒ� �ڵ��� ������ �����غ��� 
	/*String�� Ŭ������! 
	������ �츮 �ΰ��� ��Ʈ���� �ʹ� �е������� ���� ����ϱ⶧����, 
	new �����ڿ� ���� ��Ʈ���� �����ϴ°��� �ʹ� �����ϴ�..
	���� String�� ��������� �Ͻ���, ������(implicit) ������
	������ �������� ���� String�� ���Ǯ�� ���� �����Ǿ���
	*/
	String s1="apple"; //���۷�������...�ּҰ��� ����
	String s2="apple";
	System.out.println(s1==s2); //TRUE���
	
	//�Ʒ��� ���� new �����ڿ� ���� ��Ʈ�� �������� �����(explicit) �������̸�, ����� �������� ���Ǯ�� �������� �����Ƿ�, new�Ҷ����� �ߺ����θ� ������ �ʰ� 
	//������ �����ȴ�.
	String s3=new String("korea");
	String s4=new String("korea");
	System.out.println(s3==s4); //False�� ���� , �ּҰ��� �ٸ���..

	//�ּҺ񱳰� �ƴ�, ��ü ���ϼ� ���ϴ¹�
	String k1="orange";
	String k2="orange";
	System.out.println(k1==k2);//�ּҺ�
	System.out.println(k1.equals(k2));//�����
	}
}
