class Car{
	String name="Benz";
	String color="red";
	int price=500;
	Wheel wheel;
	//Ŭ���� �ȿ��� �ڷ����� �� �� �ִµ�, �ڹ��� �ڷ����� �� 4���̴�. 
	//���� �� Ŭ���� �ȿ��� ����, ����, ���� �̿ܿ��� ��ü���� �� �� �ִ�. 
	//��ü �ڷ����� �ڷ����̴ϱ�.
	
	//Ŭ������� ������ �̸��� �޼��带 ������ �����ڶ�� �ϰ�, �����ڴ� �̸������� �� �� �ֵ���, ��ü�� ����Ÿ�ӿ� ���� �ʱ�ȭ �۾��� ������, �۾��� �����ϴ� �뵵�� �޼����̴�. 
	public Car(){
		this.wheel=new Wheel();
	}
	public static void main(String[] args){
		//�ڵ����� �����ϰ�, �ڵ����� �̸��� ����ϰ�
		//�ڵ��������� �귣��,����,������ ���
		Car c=new Car();
		System.out.println("�ڵ����� �̸�"+c.name);
		System.out.println("�ڵ����� ����"+c.price);
		System.out.println("�ڵ����� ��"+c.color);

		//c.wheel=new() Wheel; //�ڵ��� ���� ���Ŀ� ���� ������ ���������ϴ´���
		System.out.println("������ �귣��"+c.wheel.brand);
		System.out.println("������ Į��"+c.wheel.color);
		//System.out.println("������ ��"+wheel.color);
		//System.out.println("������ ����"+wheel.price);
	}
}
