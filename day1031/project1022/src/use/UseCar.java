package use;
import car.Truck;//사용하고자 하는 트럭 임포트
import car.Bus;//사용하고자 하는 버스 임포트
import car.Taxi;//사용하고자 하는 택시 임포트

//만일 위처럼 일일이 명시하는게 귀찮을 경우는 한꺼번에 명시가능하다. 
//import car.*; //*의 대상이 될 수 있는건 패키지명이 아니라 클래스명이다. 참고로 현업에서는 * 는 잘 다루지 않는다..
// 저렇게 해버리면 import에서 다루고자하는 기술이 무엇인지 빨리 해석이 안된다..따라서 따로 해주는게 좋다..


class UseCar{
	public static void main(String[] args){
	//자식을 new하면 js와 같이 부모는 자동으로 인스턴스가 생성된다..
	Taxi t= new Taxi();//택시 인스턴스 생성, 얼핏보기에 택시만 생성될 것 같지만, 택시보다 앞선 부모인 Car 가 존재해야 택시도 존재할 수 있기 때문에 js시절 원리그대로인,..Car 인스턴스도 생성된다..
	t.pass();//택시 메서드 호출된다...
	t.move(); //move()매서드는 택시에 없는데 이것이 출력된다면 택시가 부모껄 맘대로 접근한것이다. 
	}
}
