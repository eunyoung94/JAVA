package day1103.Game;
import java.awt.Graphics2D;
import java.awt.Image;

public class Enemy extends GameObject{

	public Enemy(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
	}
	public void tick() {
		this.x += this.velX;
		//변경된 좌표는 즉시 사각형에 반영되어야, 총알과 적군이 충동검사가 될 수 있따. 
		rect.x=x;
		rect.y=y;
	}
	public void render(Graphics2D g2) {
		g2.drawRect(rect.x, rect.y, rect.width, rect.height);
		g2.drawImage(img,x, y,null);
	}

}
