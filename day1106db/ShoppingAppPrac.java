package day1106db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import common.image.ImageUtil;

public class ShoppingAppPrac extends JFrame {
//패널 설정 먼저하자
	JPanel p_west;// 전체중 서쪽
	JPanel p_center;// 전체중 가운데
	JPanel c_north;// 가운데 중 북쪽
	JPanel c_center;// 가운데 중 센터
	JPanel p_east;// 전체중 동쪽

	// 서쪽 등록폼 관련
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_brand;
	JTextField t_price; // 이름 브랜드 가격을 입력하고 , bt_find를 누르면 원하는 이미지가 bt_find에 입력될 수 있도록
	JButton bt_find; // 이미지 찾아보기
	JPanel can; // 이미지 미리보기 그려질 곳
	JButton bt_regist; // 등록버튼

	// 센터영역 - 검색관련 Choice -->select와 같은 느낌..
	Choice ch_category;// 검색카테고리
	JTextField t_keyword;// 검색어
	JButton bt_search; // 검색버튼
	JTable table;
	JScrollPane scroll;

	// 동쪽영역
	Choice ch_top2;
	Choice ch_sub2;
	JTextField t_name2;
	JTextField t_brand2;
	JTextField t_price2; // 이름 브랜드 가격을 입력하고 , bt_find를 누르면 원하는 이미지가 bt_find에 입력될 수 있도록
	JButton bt_find2; // 이미지 찾아보기
	JPanel can2; // 이미지 미리보기 그려질 곳
	JButton bt_edit; // 등록버튼
	JButton bt_del; // 등록버튼

	String url = "jdbc:oracle:thin:@lacalhost:1521:XE";
	String user = "user1104";
	String password = "user1104";

	Connection con; // 접속이 성공이 되면, 그 정보를 가진 인터페이스
	HashMap<String, Integer> map = new HashMap<String, Integer>();// 컬렉션 프레임웍 중에, key와 value의 쌍으로 객체를 관리해줌..
	HashMap<String, Integer> map2 = new HashMap<String, Integer>();

	JFileChooser chooser = new JFileChooser("C:/Users/최은영/eclipse-workspace/seproject/res/travel");
	Toolkit kit = Toolkit.getDefaultToolkit();// 플랫폼 종속적인 경로로 가져올때는 툴킷을 쓰자
	Image img;
	File file;
	ProductController productController;

	public ShoppingAppPrac() {
		// 서쪽영역생성
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_name = new JTextField();
		t_brand = new JTextField();
		t_price = new JTextField();
		bt_find = new JButton("이미지찾기");
		can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, can); // observer: 관찰자
			}
		};
		bt_regist = new JButton("등록");

		// 서쪽조립
		ch_top.add("choose category");
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_brand);
		p_west.add(t_price);
		p_west.add(bt_find);
		p_west.add(can);
		p_west.add(bt_regist);

		// 스타일적용
		ch_top.setPreferredSize(new Dimension(135, 30));
		ch_sub.setPreferredSize(new Dimension(135, 30));
		t_name.setPreferredSize(new Dimension(135, 30));
		t_brand.setPreferredSize(new Dimension(135, 30));
		t_price.setPreferredSize(new Dimension(135, 30));
		bt_find.setPreferredSize(new Dimension(135, 30));
		can.setPreferredSize(new Dimension(135, 115));

		p_west.setPreferredSize(new Dimension(150, 600));
		// 프레임에 서쪽영역 붙이기
		add(p_west, BorderLayout.WEST);

		// 가운데 영역 생성
		c_north = new JPanel();
		c_center = new JPanel();
		ch_category = new Choice();
		t_keyword = new JTextField();
		bt_search = new JButton("검색");
		table = new JTable(productController = new ProductController());
		scroll = new JScrollPane(table);

		// 스타일 적용
		c_north.setBackground(Color.PINK);
		ch_category.setPreferredSize(new Dimension(130, 30));
		t_keyword.setPreferredSize(new Dimension(500, 30));
		bt_search.setPreferredSize(new Dimension(120, 30));

		// 가운데 검색 영역 조립
		c_north.add(ch_category);
		c_north.add(t_keyword);
		c_north.add(bt_search);

		// 가운데 테이블영역 조립
		c_center.setLayout(new BorderLayout());
		c_center.add(scroll);

		// 가운데 영역의 전체 패널에 두 패널 부착
		p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(c_north, BorderLayout.NORTH);
		p_center.add(c_center);

		// 가운데 전체패널을 프레임에 부착
		add(p_center);

		// 동쪽영역생성
		p_east = new JPanel();
		ch_top2 = new Choice();
		ch_sub2 = new Choice();
		t_name2 = new JTextField();
		t_brand2 = new JTextField();
		t_price2 = new JTextField();
		bt_find2 = new JButton("이미지찾기");
		can2 = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, can); // observer: 관찰자
			}
		};
		bt_edit = new JButton("수정");
		bt_del = new JButton("삭제");

		// 동쪽조립
		ch_top2.add("choose category");
		p_east.add(ch_top2);
		p_east.add(ch_sub2);
		p_east.add(t_name2);
		p_east.add(t_brand2);
		p_east.add(t_price2);
		p_east.add(bt_find2);
		p_east.add(can2);
		p_east.add(bt_edit);
		p_east.add(bt_del);

		// 스타일적용
		ch_top2.setPreferredSize(new Dimension(135, 30));
		ch_sub2.setPreferredSize(new Dimension(135, 30));
		t_name2.setPreferredSize(new Dimension(135, 30));
		t_brand2.setPreferredSize(new Dimension(135, 30));
		t_price2.setPreferredSize(new Dimension(135, 30));
		bt_edit.setPreferredSize(new Dimension(135, 30));
		bt_del.setPreferredSize(new Dimension(135, 30));
		can2.setPreferredSize(new Dimension(135, 115));

		p_east.setPreferredSize(new Dimension(150, 600));
		// 프레임에 서쪽영역 붙이기
		add(p_east, BorderLayout.EAST);

		// 윈도우 창을 닫으면, 오라클과의 접속을 끊고 프로세스도 종료해야한다.
		this.addWindowListener(new WindowAdapter() { // WindowAdapter를 사용하여 필요한 메소드만 재정의 하여 사용할 수 있다.
			public void windowClosing(WindowEvent e) {
				disconnect();// 접속해제
				System.exit(0);// 프로세스종료
			}
		});
		// ch_top 에 아이템 리스너 연결하기
		ch_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// 바뀐 정보를 이용해서 하위 카테고리를 가져오자
				// 해시맵으로부터 key값을 이용하여 , value를 추출한다.
				// System.out.println("선택한 아이템의index는"+ch_top.getSelectedIndes());
				if (ch_top.getSelectedIndex() > 0) { // 제일 위의 아이템은 제외시켜야한다.
					int topcategory_id = map.get(ch_top.getSelectedItem());
					getSubList(topcategory_id); // 하위리스트 가져오기
				}
			}
		});
		// 파일찾기 버튼과 리스너 연결
		bt_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findImage();// 쇼핑몰에 사용할 상품 이미지선택
				preview();// 미리보기
			}
		});
		// 등록 버튼과 리스너 연결
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();// 등록하는 메서드 호출
			}
		});

		setSize(1000, 600);
		setLocationRelativeTo(null);// 윈도우를 매개변수 안의 컴포넌트에 따라 상대적인 위치를 지정할 수 있다. 컴포넌트 값으로는 null과 null이아닌 내용을 넣으면 된다.
//		setLocationRelativeTo(null) --->가장 기본적으로 윈도우창을 화면 가운데 띄우는 역할
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// JFrame으로 창을 띄웠다가 x를 눌러서 끄면, 화면은꺼지지만, jvm에는 메모리가 남아있기 때문에 관리자에서 프로세스를 보면 계속
		// 가동중으로 남아있다.이를 그냥 남겨두면 메모르가 견디지를 못하기때문에 , setDefaltCloseOperation메소드를 반드시
		// 붙여줘야한다.
	}

	// 오라클 접속하기
//JDBC란 자반에서 제공하는 데이터베이스와 연결하여 데이터를 주고 받을 수 있도록 하는 인터페이스이다. 
//JDBC를 사용하는 방법은 어떤 데이터 베이스를 사용하던지 같다.. 
/*
 1.Class.forName()을 이용해서 드라이버로드 
 2.DriverManager.getConnection() 으로 연결 얻기 
 3.Connection인스턴스를 이용해서 statement객체생성 
 4.Statement객체의 결과를 ResultSet이나 int에 받기 
 
 Class 클래스는 클래스들의 정보(클래스의 필드, 메서드, 클래스의 종류(인터페이스 등))를 담는 메타 클래스이고
  JVM은 이 Class 클래스를 통해 클래스들에 대한 정보를 로드 합니다.
  Class 클래스는 JVM에서 동작할 클래스들의 정보를 묘사하는 일종의 메타 클래스(Meta-Class)입니다.
 */		
	public void connect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 로드! 
				con =DriverManager.getConnection(url,user,password);
				if(con==null) {
					JOptionPane.showMessageDialog(this,"접속하지 못했습니다.");
					System.exit(0);//프로그램종료
				}else {
					//윈도우창에 유저명으로 접속했다는 메세지 
					this.setTitle(user+"로 접속중");
				}
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(this,"드라이버를 찾을 수 없습니다");
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
		
		

	// 하위 카테고리 가져오기
	public void getSubList(int topcategory_id) {
		String sql = "select*from subcategory where topcategory_id=" + topcategory_id;
		System.out.println(sql);

		PreparedStatement pstmt = null; // PreparedStatement란 ? statement를 상속받는 인터페이스로 SQL구문을 실행시키는 기능을 갖는 객체
		ResultSet rs = null; // ResultSet : SELECT의 결과를 저장하는 객체

		try {
			pstmt = con.prepareStatement(sql);// 쿼리수행 객체생성, 쿼리문 준비
			rs = pstmt.executeQuery();
			// 채우기전에 모두 지우기 (초기화)
			ch_sub.removeAll();// 모두지우기

			// 서브 카테고리 채우기
			ch_sub.add("choose category");
			while (rs.next()) {
				ch_sub.add(rs.getNString("name"));
				map2.put(rs.getString("name"), rs.getInt("topcategory_id"));
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

	public void findImage() {
		// showOpenDialog->열기용 창을 만든다. / 이때 , JFileChooser.APPROVE_OPTION 값을 반환한단.
		// JFileChooser 사용자의 홈 디렉토리를 가리키는 창을 만들다. App
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			// 파일 정보를 구한다.
			// fileChooser는 사용자로 하여금 읽어들일 파일이나, 저장할 파일을 선택하도록 도와주는 선택창이다.
			// 창이 열리고 "열기"버튼이나 " 저장"버튼을 클릭하게 되면 , APPROVE_OPTION이 반환되고, 취소 버튼을 클릭하게 되면,
			// CANCEL_OPTION이 반환된다.
			// 선택한 파일에 대한 정보는 getSelectedFile()메소드를 사용하므로 알 수 있다.
			file = chooser.getSelectedFile(); // 추저에서 선택된 이미지를 넣을 저장공간,, ->file에 담기
			System.out.println("당신이 지금 선택한 파일의 정보 : " + file.getAbsolutePath());
			img = kit.getImage(file.getAbsolutePath());
			img = ImageUtil.getCustomSize(img, 135, 115);// 이미지 사이즈 바꾸기
		}

	}

	public void preview() {
		// paint로 그림처리
		can.repaint();
	}

	// 등록하기!
	public void regist() {
		// 물음표 값 결정짓기
		int subcategory_id = map2.get(ch_sub.getSelectedItem());
		String product_name = t_name.getText();
		String brand = t_brand.getText();
		int price = Integer.parseInt(t_price.getText());
		String filename = file.getName();// 풀경로말고 이미지명만

		System.out.println("subcategory_id" + subcategory_id);
		System.out.println("product_name" + product_name);
		System.out.println("brand" + brand);
		System.out.println("price" + price);
		System.out.println("filename" + filename);

		String sql = "insert into product(product_id,subcategory_id,product_name,vrand,price,filename)";
		sql += "values(seq_product.nextval,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			// 바인드 변수 지정후에 쿼리 수행해야한다.
			pstmt.setInt(1, subcategory_id); // 첫번째 물음표는 subcategory_id
			pstmt.setString(2, product_name);// 첫번째 물음표는 subcategory_id
			pstmt.setString(3, brand);
			pstmt.setInt(4, price);
			pstmt.setString(5, filename);

			// 아래의 매서드의 반환값? 쿼리문에 의해 영향받은 레코드 수를 반환, 따라서 insert경우 성공엔 언제나 1
			// update,delete 실패인 경우 0, 성공이면 1이상이다.
			int result = pstmt.executeUpdate();// DML(insert,update,delete 경우)
			if (result == 0) {
				JOptionPane.showMessageDialog(this, "등록실패");
			} else {
				JOptionPane.showMessageDialog(this, "등록성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void getProductList() {
		String sql="select*from product";
		PreparedStatement pstmt =null; //sql 기능을 전달역할,,
		ResultSet rs =null;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();//select문 수행수 결과표를 rs에 대입! 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//접속해제! 
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new ShoppingApp();
	}
}
/*
 * 특정 데이터베이스에 연결되면, 그 접속은 SQL문들을 전송하는데 사용된다. - Statement 객체는 아래의 코드처럼
 * Connection의 createStatement 메소드로 생성되어진다. ☞ Connection conn =
 * DriverManager.getConnection(URL, USER, PWD); URL:DB 접속 드라이버 url, USER:DB접속
 * ID, PWD:비밀번호 ☞ Statement stmt = conn.createStatement(); - 데이터베이스로 전송되어질 SQL문은
 * Statement 객체를 실행하기 위한 메소드들의 인자로서 공급되어진다. ☞ ResultSet rs =
 * stmt.executeQuery("SELECT * FROM table");
 * 
 * < Statement 객체 수행> - Statement 인터페이스는 SQL문들을 실행하기위한 3가지 다른 메소드(execute,
 * executeQuery, executeUpdate)들을 제공한다 - SQL문이 무엇을 만드는지에 따라 사용하는 메소드가 나뉜다. ①
 * executeQuery 메소드 : 하나의 ResultSet을 만드는 SQL문에서 사용(executeQyery 메소드는 ResultSet
 * 객체를 리턴한다.) : 주로 SELECT문을 이용하는 조회에서 사용됨. ② executeUpdate 메소드 : INSERT, UPDATE,
 * DELETE 등 (DML), CREATE, DROP 등(DDL)문들을 실행하는데 사용 └ DML을 사용할 경우 리턴값 : 작용한 열의
 * 개수(갱신 카운트로 간주되는)를 나타내는 정수 └ DDL을 사용할 경우 리턴값 : 0을 리턴(DML을 실행 후 아무런 영향을 주지 않은
 * 경우에도 '0'을 리턴한다.) ※ 실행문을 위한 모든 메소드들은 하나가 오픈되어있다면, 호출된 Statement 객체의 현재
 * ResultSet을 닫아야한다. 이것은 Statement 객체를 다시 실행기전에 현재 ResultSet 객체의 어떠한 처리도 완결해야 할
 * 필요가 있다는 것을 의미한다. ③ execute 메소드 : SQL문이 여러개의 ResultSet객체나 여러개의 갱신카운트 또는
 * ResultSet객체들과 갱신 카운트들의 결합을 리턴하는 것이 가능할때 사용한다.
 */
