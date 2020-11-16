/*Car패키지에 넣기 */
//이 클래스는 모든 자동차류의 최상위 클래스로서 가장 보편적인 기능과 속성들만을 보유하면됩니다.
package car;
public class Car{
	String brand;

	/*public Car(){
		System.out.println("자식의 super()호출에 의해 난 호출됩니다.");
	}*/
	// 개발자가 매개변수 있는 생성자만 정의함, 개발자가 생성자를 정의하면 컴파일러에 의한 디폴트 생성자 자동삽입은 없음. 
	//따라서 Car클래스는 생성자가 오직 딱 1개만 있게된다..
	public Car(String brand){//매개변수가 있는 생성자라서, new Car("벤츠")등 방법으로 호출해야한다.
		this.brand=brand;
	}
	public Car(){
	//매개변수 없는 생성자도 추가한다. 생성자가 2개 이상 추가되면 마치 중복정의처럼 보이지만, 자세히 보면 매개변수의 갯수가 틀리므로 오버로딩으로 인정받는다. 
	//이렇게 하면
	}
	public void move(){//필수적인요건
	System.out.println("차가 슈우우웅우웅우웅 출발!!!");
	}
}
