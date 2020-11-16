package day1103.galllery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.image.ImageUtil;

public class AutoGallery extends JFrame {
	JPanel can;
	JButton bt_prev, bt_pause, bt_auto, bt_next;
	// os에 종속된 경로로 가져올때는 Toolkit을이용하자
	Toolkit kit;
	int index = 0; // 사진 배열의 인덱스
	Image[] img = new Image[10];
	Thread thread; // 자동사진 넘기기용 스레드
	boolean flag = false;

	public AutoGallery() {
		kit = Toolkit.getDefaultToolkit();
		img[0] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/1.jpg"),680, 550);
		img[1] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/2.jpg"),680, 550);
		img[2] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/3.jpg"),680, 550);
		img[3] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/4.jpg"),680, 550);
		img[4] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/5.jpg"),680, 550);
		img[5] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/6.jpg"),680, 550);
		img[6] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/7.jpg"),680, 550);
		img[7] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/8.jpg"),680, 550);
		img[8] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/9.jpg"),680, 550);
		img[9] = ImageUtil.getCustomSize(kit.getImage("D:/workspace/js_workspace/images/10.jpg"),680, 550);

		can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img[index], 0, 0, this);
			}
		};
		/*
		 * imageObserver 인터페이스의 역할 시스템 내부에는 image를 로딩하는 스레드가 있다. 이 스레드는 새로운 이미지가 데이터에
		 * 로딩될때마다 imageObserver 인터페이스로 로딩시점을 알려준다. 그러면 이러한 로딩시점을 알기 위해서는
		 * imageObserver인터페이스를 구현하고, 해당 콜백 메소드를 재정의하면 우리도 이미지 로딩 시점을 알 수 있따. JComponent
		 * 클래스는 우리가 도화지로 사용하는 JPanel의 부모 클래스이다. 즉, JPanel자체가 ImageObserver를 이미 구현되어 있다는
		 * 의미이다. 결과적으로 JPanel은 이미지가 다 로딩되면 ImageObserver로 부터 로딩되는 순간을 포착하여 이미지를 도화지에
		 * 그리도록 명령하게된다. 그래서 일반적으로 drawImage 메소드의 네번째 매개변수로 this를 사용하는게 일반적인 프로그래밍이다.
		 */
		thread = new Thread() {
			public void run() {
				while (true) {
					if (flag) {
						next();
					};
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		
		bt_prev = new JButton(ImageUtil.getIcon(this.getClass(), "res/food/3.png", 70, 35));
		bt_pause = new JButton(ImageUtil.getIcon(this.getClass(), "res/food/3.png", 70, 35));
		bt_auto = new JButton(ImageUtil.getIcon(this.getClass(), "res/food/3.png", 70, 35));
		bt_next = new JButton(ImageUtil.getIcon(this.getClass(), "res/food/3.png", 70, 35));

		// 스타일적용
		can.setPreferredSize(new Dimension(680, 550)); // can jpanel
		can.setBackground(Color.YELLOW);
		bt_prev.setPreferredSize(new Dimension(100, 35));
		bt_pause.setPreferredSize(new Dimension(100, 35));
		bt_auto.setPreferredSize(new Dimension(100, 35));
		bt_next.setPreferredSize(new Dimension(100, 35));

		setLayout(new FlowLayout());
		add(can);
		add(bt_prev);
		add(bt_pause);
		add(bt_auto);
		add(bt_next);

		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 일시정지를 누를때
				flag = false;
			}
		});
		bt_auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 자동을 누를때
				flag = true;
			}
		});
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});

		setSize(700, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 다음사진나오게
	public void next() {
		index++;
		can.repaint();
	}

	public static void main(String[] args) {
		new AutoGallery();
	}
}