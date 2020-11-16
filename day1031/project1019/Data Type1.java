class DataType1{
/* 1. 변수/자료형
	2. 연산자
	3.제어문(반복,조건)
	4.함수
	5.배열
	6.객체

프로그래밍 언어에서 사용되는 데이터의 종류3가지 
1)숫자
						정수:byte< short<int<long
	단위(byte)				1	<    2   < 4 <   8
	실수: 소수점을 포함한 수 
			float<double
				4	<	  8
2)문자	: char(문자열과틀림, 문자열은 1개이상의 문자들의 집합)
3)논리값 true/false
*/

		public static void main(String[] args){	
			byte x=-128; //bit가 모여진  8개의 박스를 말하는것, 1 byte 차지

			//1byte로 표현할 수 있는 데이터의 가지수는? 2의 8승가지, 즉 256 종류의 숫자데이터를 표현할 수있다. 
			//반을 나눠 -128 0 127
			short s=47; //2byte 차지 , 2byte로 표현할수 있는 데이터 가지수는 2 16승 가지의수
			int k=500; //4byte
			long a =3; //8byte
			System.out.println("x값은"+x);
			//실수 
			float b=3.689;

			boolean e =ture; //1byte 차지
}
}
