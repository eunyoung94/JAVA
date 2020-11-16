package animal; //프롬프트창이 띄어지면.. 다음과같이 쓴다. 

import animal.Dog;//사용하고자 하는 클래스의 위치 명시 , Dog이라는 클래스의 package를 선언부 그대로 적으면 된다..
class UseDog{
	public static void main(String[] args){
	/*
	D:\workspace\java_workspace\project1022\bin --> 환경변수로 등록
	세미콜론 ; 그리고의 뜻 ex) 경로;경로2;경로3;
	현재 클래스와는 다른 경로에 있는 클래스를 사용해야하는데,
	컴파일러가 어떻게 Dog.class를 찾을 수있는지 알아야한다..
	경로가 일반 파일일 경우는 path환경변수이지만, 경로가 클래스 파일일 경우는 classpath환경변수를 이용하면된다. 
	이때, classpath환경변수에 어느 경로를 등록할지 고민해 봐야한다..
	*/
	Dog d=new Dog();//컴파일해서 시도해보세요..
	d.run();
	}
}
