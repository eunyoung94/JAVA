/*�ʱ�ȭ ��*/
//Ŭ�������� ����, �޼��常 ������ �� �ִ�..
	class InitialBlock{
	//	��������ȿ� {����ȭ} �������� �����ǹ̴�?
	int sum=0;
		{
			for(int i=1;i<10;i++){
			sum+=i;
			}
		}
	{
	//�� Ŭ������ �ν��Ͻ��� �����ɶ����� �� ������ ȣ���ϰԵ�
	//�ν��Ͻ� �ʱ�ȭ ���̶��Ѵ�. 
	System.out.println("�ν��Ͻ� �ʱ�ȭ ��ȣ��"+sum);
	}
	//static �ʱ�ȭ �� 
	//main() �޼��忡 ���� ���� ������ ����Ǵ� �ʱ�ȭ �� 
	static{
		System.out.println("�����ϱ��� �ʱ�ȭ�� �����ϰڽ��ϴ�.");
		System.out.println("A");
	}
	public static void main(String[] args){
		//�׳� ��ȭ ���ѳ��� ����, Ȥ���� �� �ȿ� ������ �����ϸ�, �ش� ���������� ��ȿ�ϴ�.
		System.out.println("B");
		new InitialBlock();
		new InitialBlock();
		new InitialBlock();

		int a =3;
	}
}
