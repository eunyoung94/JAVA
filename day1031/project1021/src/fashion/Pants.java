/*
클래스를 정의하면서, 디렉토리 구분을 두는 이유
1) 중복방지
2) 관련성 잇는 파일끼리 묶을 수 있음, 관리가 용이해진다. 

.java와 같은 원본소스를 만들때는, 개발자가 일일이 디렉토리를 직접 생성해야하지만, 컴파일처럼 자동으로 기계어로 만들어질땐, 
이 디렉토리가 자동으로 만들어져야 편할것이다. 
자바는 write once run anywhere!
한번 작성된 자바 코드는 어느 시스템에서건 돌아가야한다. 
클래스를 보관하기 위한 용도의 디렉토리를 가리켜 패키지라고 한다. 
*/
package fashion.down; //-d 옵션으로 컴파일 할 경우 패키지를 자동생성
public class pants{
	String name="바지";
}
