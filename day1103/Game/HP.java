package day1103.Game;

import java.awt.Graphics2D;
import java.awt.Image;

public class HP extends GameObject{

	public HP(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(img, x, y, null);
	}
	

}
