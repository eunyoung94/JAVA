/*
MVC 패턴이 적용된 JTable에서 사용되는 TableModel은 명칭으로는 마치 모델인 것처럼 보이지만 
그 역할로 본다면 컨트롤러이다. 
JTable(View)------------컨트롤러(TableModel)-----------------보여질 데이터 (Model) 
 MyModel이 보유한 메서드 호출자는 테이블이다. 
 */
package day1106db;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	
	//데이터준비 
	String[][] flower = {
			{"장미","50000","RED","Korea"},
			{"튤립","25000","yellow","italy"},
			{"안개꽃","50000","purple","france"}
	};
	String[][] car = {
			{"BMW","50000","RED"},
			{"KIA","500","red"},
			{"Audi","4000","white"}
	};

//행의 갯수를 반환하는 매서드 
	public int getRowCount() {
		return car.length;
	}

//열의 갯수를 반환하는 매서드 
	public int getColumnCount() {
		return car[0].length; // 몇층을 쓰던 상관 없다.
	}

//열의 갯수를 반환하는 매서드 , 지정한 좌표의 값을 반환한다. 
	public Object getValueAt(int row, int col) {
		System.out.println("row"+row+",col"+col);
		return car[row][col];
	}

}
