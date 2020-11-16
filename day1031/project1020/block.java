/*초기화 블럭*/
//클래스에는 변수, 메서드만 정의할 수 있다..
	class InitialBlock{
	//	멤버영역안에 {지역화} 시켰을때 갖는의미는?
	int sum=0;
		{
			for(int i=1;i<10;i++){
			sum+=i;
			}
		}
	{
	//이 클래스의 인스턴스가 생성될때마다 이 영역을 호출하게됨
	//인스턴스 초기화 블럭이라한다. 
	System.out.println("인스턴스 초기화 블럭호출"+sum);
	}
	//static 초기화 블럭 
	//main() 메서드에 의해 실행 직전에 실행되는 초기화 블럭 
	static{
		System.out.println("실행하기전 초기화블럭 실행하겠습니다.");
		System.out.println("A");
	}
	public static void main(String[] args){
		//그냥 블럭화 시켜놓은 것임, 혹여나 이 안에 변수를 선언하면, 해당 블럭내에서만 유효하다.
		System.out.println("B");
		new InitialBlock();
		new InitialBlock();
		new InitialBlock();

		int a =3;
	}
}
