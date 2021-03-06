/*
 인터넷으로 제품 이미지 가져오기 
 호출당할거니까 메인이 필요없다. 
 */
package day1106db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fileCommon.FIleManager;

public class CollectorFrame extends JFrame{
	JTextField t_url;
	JButton bt;
	JButton bt_apply; //이미지 그리기, 반영하기! 
	BufferedImage buffr; //url로 가져온 이미지 정보를 담을 객체 
	ShoppingApp shoppingApp; //null 
	File file; //인터넷으로 수집된 파일 
	public CollectorFrame(ShoppingApp shoppingApp) { //ShoppingApp shoppingApp쇼핑앱을 매개변수로 넘겨받기 
		this.shoppingApp=shoppingApp;
		setLayout(new FlowLayout());
		
		t_url=new JTextField(); //북쪽에 붙이자..
		bt=new JButton("수집실행");
		bt_apply = new JButton("반영하기");
		
		
		t_url.setPreferredSize(new Dimension(580,40));
		add(t_url);
		add(bt);
		add(bt_apply);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				collect();
			}
		});
		bt_apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shoppingApp.getTargetImage(file.getAbsolutePath()); //디ㅔㄺ토리포함한 파일의 풀경로
				//ShoppingApp 클래스의 img변수의 값을 인터넷상 이미지로 교체하고 ShoppingApp클래스의 preview()메서드 호출 
				//ShoppingApp클래스의 preview()메서드 호출 
				shoppingApp.preview();
			}
		});
		setLocationRelativeTo(shoppingApp);
		setVisible(true);
		setSize(600,250);
	}
	public void collect() {
		try {
			URL url = new URL(t_url.getText());
			buffr = ImageIO.read(url);
			//현재까지는 메모리에 존재하므로, 실제 파일로 저장해놓자 
			//저장할 파일명은 우리가 지정하자! 규칙이 있어야한다. , 시 , 분 , 초 밀리초
			long time = System.currentTimeMillis(); //현재 시간을 반환해주는 메서드 
			System.out.println(time);
			String filename = FIleManager.getFilename(t_url.getText());
			String extend = FIleManager.getExtend(filename);
			 file = new File("C:/Users/최은영/eclipse-workspace/seproject/res/travel/"+time+"."+extend);
			//빈파일에다가, 이미지 데이터를 쓰자!출력! 
			ImageIO.write(buffr, extend, file);
			JOptionPane.showMessageDialog(this, "가져오기완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
