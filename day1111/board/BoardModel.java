package day1111.board;

import javax.swing.table.AbstractTableModel;

public class BoardModel extends AbstractTableModel{
	String[]colum= {"board_id","title","writer","regdate","hit"};
	String[][]data = {};//비어있는 2차원 배열 선언.. 비어있는 이유는 db연동이 안됐으니..

	public int getRowCount() {//컬럼수 
		return data.length;//0 .. 데이터의 길이
	}
	public int getColumnCount() {//레코드수 
		return colum.length;//5
	}
	//컬럼 제목을 출력하기 위해선, 이미 지원하는 메서드 오버라이드..
	@Override
	public String getColumnName(int col) {
		return colum[col];
	}
	//해당좌표의데이터
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
