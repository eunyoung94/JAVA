package use;
//개념상만 가능하다. 아래처럼 명시하면, d:경로때문에 문제가 발생한다. 경로를 특정 OS에 의존적인 경로로 명시하면 안된다. 
//os환경변수 : path 실행하고픈 파일의 경로위치
               // classpath 실행하고픈 클래스 파일의 경로의 위치

import fashion.down.Pants; //사용하고픈 클래스의 위치를 등록..bin등록
class UsePants{
	public static void main(String[] args){
	//현재 클래스와는 물리적으로 떨어져있는, 즉 다른 패키지에 들어있는 클래스 사용해보기
	Pants p= new Pants(); //Pants를 찾지못하고있음..
	System.out.println(p);
	}
}
