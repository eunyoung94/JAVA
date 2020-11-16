class UseDuri{

	public static void main(String[]args){
		Duri duri = new Duri();
		System.out.println("그녀의 이름은 ? "+duri.name);
		System.out.println("그녀의 나이는 ? "+duri.age);
		System.out.println("그녀의 털색은 ? "+duri.color);

		System.out.println("그녀의 특기는 ? "); duri.ability();
		System.out.println("그녀의 짖는소리는?"); duri.cry();
	}
}
