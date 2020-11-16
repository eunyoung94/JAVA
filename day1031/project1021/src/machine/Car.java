class Car{
	String name="Benz";
	String color="red";
	int price=500;
	Wheel wheel;
	//클래스 안에는 자료형을 둘 수 있는데, 자바의 자료형은 총 4개이다. 
	//따라서 이 클래스 안에는 문자, 숫자, 논리값 이외에도 객체형도 올 수 있다. 
	//객체 자료형도 자료형이니깐.
	
	//클래스명과 동일한 이름의 메서드를 가리켜 생성자라고 하고, 생성자는 이름에서도 알 수 있듯이, 객체의 생성타임에 무언가 초기화 작업이 있을때, 작업을 수행하는 용도의 메서드이다. 
	public Car(){
		this.wheel=new Wheel();
	}
	public static void main(String[] args){
		//자동차를 생성하고, 자동차의 이름을 출력하고
		//자동차바퀴의 브랜드,색상,가격을 출력
		Car c=new Car();
		System.out.println("자동차의 이름"+c.name);
		System.out.println("자동차의 가격"+c.price);
		System.out.println("자동차의 색"+c.color);

		//c.wheel=new() Wheel; //자동차 생산 이후에 한참 지나서 바퀴생성하는느낌
		System.out.println("바퀴의 브랜드"+c.wheel.brand);
		System.out.println("바퀴의 칼라"+c.wheel.color);
		//System.out.println("바퀴의 색"+wheel.color);
		//System.out.println("바퀴의 가격"+wheel.price);
	}
}
