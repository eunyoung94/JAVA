class Shoes{
	String color;//String 은 객체이므로 컴파일러에 의해 null
	int price; //정수는 컴파일러에 의해 최소한의관여 수인 0으로 초기화

//	public void SetColor(String color){//색상을 변경하는 메서드
//		this.color=color;
//	}
//	public void setPrice(){//가격을 변경하는 메서드
//		this.price=price;
//	}

	public 
	public static void main(String[] args){
		Shoes s = new Shoes("red",2000);
//		s.setColor("red");
//		s.setPrice(20000);

		System.out.println("신발의 색상은"+s.color+",가격은"+s.price);
	}
}
