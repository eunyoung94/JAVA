package animal;
public class Duck extends Bird{
	/*Duck is a Bird
		Duck 형은 Bird형이다.
		오리는 새다..

		손실을 감안하고, 강행함 (강제형변환)

		객체자료형도 자료형이다...
		demotion
		큰 자료형에서 작은 자료형으로 올라감 down casting
		작은 자료형에서 큰 자료형으로 올라감 up casting
		결론: 객체자료형도 자료형이므로, 기본 자료형의 원칙이 상당부분 그대로 적용되고있다..
	*/
	String name = "덕덕";
	public void quack(){
		System.out.println("꽊꽊꽊");
	}
	public static void main(String() args){
		Duck d1= new Duck();
		Duck d2= new Duck();
		Bird b = new Bird();
		//
		손실을 감안하고, 강행함 (강제형변환)

	}
}
