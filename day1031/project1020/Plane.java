//��ü���� ����̱�  ������ , ��� �ڵ�!~~�� Ŭ�����ȿ� �ۼ��ؾ� �Ѵ�..
//int count=0; //���?  �����?

class Plane{
	String name="����747";
	static int price=9000;
	String color="white";
	
	public void setPrice(){
		price=10;
	}
	public static void main(String[] args){
		Plane p1 = new Plane();
		Plane p2 = new Plane();
		Plane p3 = new Plane();
		

		p1.price=3000;
		System.out.println(p2.price);
		System.out.println(p1.price);
		price=5000;
		System.out.println(p1.price);
		System.out.println(p2.price);
		System.out.println(p3.price);
		p3.price=1600;
		System.out.println(p1.price);
		System.out.println(p2.price);
		System.out.println(p3.price);
		
	}
}