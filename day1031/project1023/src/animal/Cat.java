package animal;
public class Cat{
	String name;
	int age;

	public Cat(String name, int age){
		this.name=name;
		this.age=age;
	}

	public void cry(){
		System.out.println("고양이가울어요");
	}
	
}
//컴파일 결과물은 실행용이고, 기계어이기때문에 어떤 메세드나, 속성을 가지고 있는지 도저히 알 수 없다. 따라서 클래스를 정의한 사람은 기계어뿐만아니라, 기계어와 함꼐 설명서를 제공해야한다...