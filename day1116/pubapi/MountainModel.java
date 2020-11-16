package day1116.pubapi;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MountainModel extends AbstractTableModel{

	//이제 이차원 배열이 아니라 , Vector를 선언해서, 데이터와 컬럼명을 처리해보자 
	//백터는 컬렉션 프레임웍이니, 배열처럼 생성시 크기를 명시하지 않아도된다. 그만큼 유연하다. 
	Vector<Mountain> data=new Vector<Mountain>(); //제너릭 타입이 아니라 뭔가 허접하다.. 제너릭타입으로 알맞는 자료형은 과연 뭘까..? 
	
	//컬럽 제목 정보를 담는 백터 
	Vector<String>columnName=new Vector<String>();

	//컬럼 제목을 구성할 벡터 요소는 생성자에서 채우자! 
	public MountainModel() {
		//컬럼구성 
		columnName.add("ID");//산아이디 
		columnName.add("산이름");//산이름
		columnName.add("산소재지");//산소재지 
		columnName.add("산높이");//산높이
		
		//데이터 거짓말로 구성해보기(테스트를위해)
		Mountain mt = new Mountain();
		mt.setMntnid(1);
		mt.setMntnnm("설악산");
		mt.setMntninfopoflc("강원도");
		mt.setMntninfohght(1000);
		data.add(mt);//산 1개를 벡터에 넣기! 
	}
	
//컬럼의 수는 백터의 길이에서 가져오기 
	public int getColumnCount() {
		return columnName.size();
	}

	//이제 레코드의 수 (행의수)는 백터의 길이에서 가져오면됨 
	public int getRowCount() {
		return data.size();
	}

	//컬럼 제목을 출력하기 위한, 메서드 오버라이드
	public String getColumnName(int col) {
		return columnName.get(col);
	}
//2차원 배열이나 벡터는 모두 배열구조이므로 지금까지는[row][col]형태로 데이터를 추출하였다. 
//	하지만, 이제는 벡터에 들어잇는 데이터는 VO이므로[row]에 대한 접근은 가능하지만 [col]에 대한 접근은 불가하다..
	public Object getValueAt(int row, int col) {
		//해결책 ! 조건문을 써야한다. 즉, col이 0일때는 산의 아이디, 1일때는 이름, 2일때는 뭐..등등으로 조건을 달아야한다. 
		System.out.println("row="+row+"col값 ="+col);//호출시 컬럼값 확인하기! 실행해보세요 
		//현재는 data의 사이즈가 0이니깐 이 메서드를 호출하지 않고 있으니, 거짓말로 데이터를 넣어보기 ! 
		Mountain mt=data.get(row);//row번째에서 산을 하나 끄집어낸다.
		String obj=null;//각 조건에 따라 반환될 데이터 
	
		if(col==0) {//이때는 우리가 산의 아이디를 반환할것
			obj=Integer.toString(mt.getMntnid());//int
		}else if(col==1) {//산의이름 
			obj=mt.getMntnnm();
		}else if(col==2) {//산의위치
			obj=mt.getMntninfopoflc();
		}else if(col==3) {//산의높이
			obj=Integer.toString(mt.getMntninfohght());
		}
		// 이 메서드의 반환형이 오브젝트 형이므로, 우리는 객체형(String,Integer)등으로 반환해야한다. 
		return obj;
	}

}
