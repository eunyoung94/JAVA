
/*강아지를 정의한다.*/
class Dog{
	/*
	결국 클래스 안에 올 수 있는 문법 구성요소는?
	1.변수 =property
	2.함수 =method
	
	색상 , 상태(변수)
	이름, 상태(변수)
	나이 , 상태(변수)
	짖는다 , 동작(함수)
	뛴다 동작(함수)
	*/


	//반환형이 없는 함수는 void를 명시 
	String color="white";
	String name="뽀미";
	int age=9; 
	public void bark(){
		System.out.println("빼액");
	}
	//뛴다 = 동작(함수)
	public void run(){
		System.out.println("강아지가뛰어요");
	}

}
