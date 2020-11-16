package string;
class StringTest{
	public static void main(String[] args){
	//아래 코드의 수행결과 예측해보기 
	/*String은 클래스다! 
	하지만 우리 인간은 스트링을 너무 압도적으로 많이 사용하기때문에, 
	new 연산자에 의해 스트링을 생성하는것은 너무 불편하다..
	따라서 String의 생성방법을 암시적, 묵시적(implicit) 생성법
	묵시적 생성법에 의한 String은 상수풀에 의해 관리되어짐
	*/
	String s1="apple"; //레퍼런스변수...주소값을 받음
	String s2="apple";
	System.out.println(s1==s2); //TRUE출력
	
	//아래와 같이 new 연산자에 의한 스트링 생성법을 명시적(explicit) 생성법이며, 명시적 생성법은 상수풀에 생성되지 않으므로, new할때마다 중복여부를 따지지 않고 
	//무조건 생성된다.
	String s3=new String("korea");
	String s4=new String("korea");
	System.out.println(s3==s4); //False가 나옴 , 주소값이 다르니..

	//주소비교가 아닌, 객체 동일성 비교하는법
	String k1="orange";
	String k2="orange";
	System.out.println(k1==k2);//주소비교
	System.out.println(k1.equals(k2));//내용비교
	}
}
