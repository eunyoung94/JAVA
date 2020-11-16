/*초를 출력할 쓰레드*/
package day1103.thread;

import java.util.Calendar;

public class TimeThread extends Thread {
	public void run() {
		// thread는 닫히면 죽어버리니 while문으로 안죽게 하기..

		while (true) {
			// 현재시간을 구해서 1초마다 갱신해서 출력
			Calendar cal = Calendar.getInstance();// 추상클래스이므로 자체 메서드로 인스턴스 얻자
			// 년,월,일,초
			System.out.println(cal.get(Calendar.YEAR) + "년" + (cal.get(Calendar.MONTH) + 1) + "월" + cal.get(Calendar.DATE)
							+ cal.get(Calendar.HOUR) + "시" + cal.get(Calendar.MINUTE) + "분" + cal.get(Calendar.SECOND));

			try {
				Thread.sleep(1000); // 1/1000초까지 표현가능
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 1초동안 non-runnable로 상태로 있다가 복귀하라는 명령
		}
	
	}
//
}
