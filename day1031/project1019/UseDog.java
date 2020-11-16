/*
이 클래스는, 현실의 사물을 표현할 용도로 정의한 것이 아니라, 단지 실행하기 위한 목적이다. 즉, 엔트리 포인트
*/

class UseDog{
	//main 메서드를 보유한 클래스만이 실행되어질 수 있다. 
	//하나의 프로젝트 내에 실행부는 단 1개만 있으면 된다. 
	public static void main(String[] args){
		//Dog은 개발자가 정의한, 기존에 없었던 새로운 자료형이다. 
		//이러한 자료형을 가리켜 사용자 정의 자료형이라하고, 모든 클래스는 사용자 정의 자료형이다. 
		Dog d = new Dog();
		System.out.println("강아지 탄생성공");
		System.out.println("강아지이름"+d.name);
		System.out.println("강아지색상"+d.color);
		System.out.println("강아지나이"+d.age);
	}
}
