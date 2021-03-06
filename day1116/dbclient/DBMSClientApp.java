package day1116.dbclient;
/*
 DBeaver수준은 아니어도, 딕셔너리를 학습하기 위해 데이터베이스 접속 클라이언트를 자바로 만들어본다. 
 실무에서는 SQLPlus를 잘 이용하지 않는다. 왜냐,,업무의 효율성이 떨어지기 때문이다. 그럼 언제 쓰일까?
 실무현장에서는 개발자의pc에는 각종 개발 툴들이 있지만, 실제적인 운영 서버에는 보안상 아무것도 설치해서는 안된다. 따라서 서버에는 툴들이 없기때문에 만일 오라클을 
 유지보수하러 파견을 나간 경우, 콘솔창 기반으로 쿼리를 다뤄야할 경우가 종종있다. 이때 SQLPlus를 써야한다. 
 개발자들이 개발할때 데이터 베이스를 다루는 툴을 '데이터베이스 접속 클라이언트'라고 부른다. 
 이러한 툴들중 꽤 유명한 제품은 Toad,등이 있다. Toad는 DBeaver에 비해 기능이 막강하지만 유료다..
 */

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DBMSClientApp extends JFrame {
	JPanel p_west;// 서쪽 영역패널
	Choice ch_users; // 유저명이 출력될 초이스 컴포넌트
	JPasswordField t_pass;// 비밀번호 텍스트 필드
	JButton bt_login;// 접속버튼

	JPanel p_center;// 그리드가 정용될 센터패널
	JTable t_tables;// 유저의 테이블 정보를 출력할 테이블
	JTable t_seq;// 유저의 시퀀스 정보를 출력할 테이블
	JScrollPane s1, s2; // 스크롤 2개 준비하기

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String password = "1234";
	java.sql.Connection con;

	// 테이블을 출력할 백터및 컬럼
	Vector tableList = new Vector();// 이 벡터안에는 추후 또다른 벡터가 들어갈 예정이다. 이차원배열과 동일하다. 단, 이차원 배열보다는 크기가 자유로워서 유연함!
	Vector<String> columnList = new Vector<String>();// 컬럼명은 당연히 String이므로..

	public DBMSClientApp() {
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");

		p_center = new JPanel();
		p_center.setLayout(new GridLayout(2, 1)); // 2층에 1호수
		t_tables = new JTable(tableList,columnList); //여기서 초기백터값을 넣어주기!, 이 시점엔 아직 db연동을 안한 상태이므로 사이즈가 0이지만, 추후 메서드 호출시 벡터의 크기가 변경될 것이고
																		//JTable을 새로고침하면 된다!
		t_seq = new JTable();
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);

		// 스타일
		p_west.setPreferredSize(new Dimension(150, 30));
		ch_users.setPreferredSize(new Dimension(145, 30));
		t_pass.setPreferredSize(new Dimension(145, 30));
		bt_login.setPreferredSize(new Dimension(145, 30));

		// 조립
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);
		p_center.add(s1);
		p_center.add(s2);

		add(p_west, BorderLayout.WEST);
		add(p_center);

		setSize(700, 350);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE); 프로세스만 종료시켜버리므로, 오라클, 스트림닫는 처리를 할 기회를 잃어버리게된다. 
		// 따라서 윈도우 어댑터 구현하여 닫을게 있다면 닫는처리하자!
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				disConnect();// 시스템 종료전에 닫을 자원이 있을때 먼저 닫으려고 호출함!
				System.exit(0);
			}
		});
		bt_login.addActionListener((e) -> {
			login(); // 선택한 유저로 로그인 시도하기!
		});
		setLocationRelativeTo(null);
		connect();// 호출
		getUserList();// 유저목록 구해오기

		// 컬럼정보 초기화 하기
		columnList.add("table_name");
		columnList.add("tablespace_name");
	}

	// 오라클에 접속하기
	public void connect() {

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				JOptionPane.showMessageDialog(this, user + "계정의 접속에 실패하였습니다.");
			} else {
				this.setTitle(user + "계정으로 접속중....");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 유저목록 가져오기
	public void getUserList() {
		// pstmt와 result는 소모품이기때문에 매 쿼리문마다 1개씩 대응해야한다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select username from dba_users order by username asc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 반환형을 먼저 적으면 이클립스가 알맞는 메서드를 찾아준다.
			// 이제 rs에 들어있는 유저정보를 Choice에 출력하자!
			while (rs.next()) {
				ch_users.add(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 현재 접속 유저의 테이블 목록 가져오기
	public void getTableList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select table_name, tablespace_name from user_tables";
		try {
			pstmt = con.prepareStatement(sql);// 쿼리준비
			rs = pstmt.executeQuery();// 쿼리 실행 및 결과 집합 받기
			// 평소같았으면, 이차원 배열 선언한 후 last() , getRow(), 스크롤 옵션 등등 아주 성가셨는데 백터를 이용하면 그런게 필요없음
			while (rs.next()) {
				Vector vec = new Vector();// tableList백터에 담겨질 백터
				vec.add(rs.getString("table_name"));
				vec.add(rs.getString("tablespace_name"));

				tableList.add(vec); // 멤버변수 백터에 백터를 담았으니, 이제 멤버변수 백터는 이차원백터가 된다.
			}
//					 완성된 이차원 백터를 JTable에 반영해야한다. 생성자의 인수로 넣어야한다
			// 컬럼정보는 어떻게 가져올까? 2개 밖에 없으니, 고정된다.
			t_tables.updateUI();// updateUI()하기! 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 로그인
	public void login() {
		// 현재 유지되고 있는 접속객체인 Connection을 끊고, 다른 유저로 접속을 시도한다!
		disConnect(); // 접속 끊기
		user = ch_users.getSelectedItem();// 현재 초이스 컴포넌트에 선택된 아이템값!
		password = new String(t_pass.getPassword());// 비밀번호 설정
		connect(); // 접속하기 (하지만 멤버변수가 현재 .system으로 되어있으므로 멤버변수를 초이스 값으로 교체해야한다. )
		getTableList();//바로 이 시점에서 로그인 하자마자, 이 계정의 테이블 정보를 보여주자! 
		System.out.println("보유한테이블 "+tableList.size()); //user1104
	}

	// 오라클에 접속 끊기
	public void disConnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DBMSClientApp();
	}
}
