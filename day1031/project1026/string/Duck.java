package string;
//�ڹ��� ��� ��ü�� ���� ���� �� ���� �ֻ��� ��ü�� �ΰ��ִ�...
//Object ��ü�̴�. �����ڰ� ����� ������� �ʴ��� ����Ʈ�� �̹� ��ӵǾ��ִ�...
class Duck{
	String name="����";
	/*�Ʒ��� �޼���� objectŬ�����κ��� ��ӹ��� �޼����̸�, �� �޼���� ��ü�� ��Ʈ������ ��ȯ�ϰ��� �Ҷ� �����Ѵ�..
	��, �Ʒ��� �޼���� ��ü�� ����ϰ��� �Ҷ� � �ڵ����� �����Ѵ�.
	*/
	//�Ʒ��� �޼���� object�� �޼���������, �׽�Ʈ ���۽����� �˱� ���ؼ� ��� �������̵�..
	public String toString(){
		System.out.println("toString()�޼��� �����մϴ�.");
		return"";
	}
	public static void main(String[] args){
		Duck d = new Duck();

		//System.out.println(d);// ������ �ּҰ��� ����..
		System.out.println(new Duck()); //������ü�� ���
	}


}
