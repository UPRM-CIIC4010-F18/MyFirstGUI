import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Frog implements Raceable {
	private int xPosition;
	private int yPosition;
	private int speed; // Vehicle speed in pixels per second
	private int direction;
	
	private Color color;

	private static final int DEFAULT_PIXELS_PER_TICK = 10;
	private static final int DEFAULT_DIRECTION = 1;
	
	Image frogImage;

	public Frog(int xPosition, int yPosition) {
		this(xPosition, yPosition, DEFAULT_PIXELS_PER_TICK,DEFAULT_DIRECTION);
	}

	public Frog(int xPosition, int yPosition, int speed) {
		this(xPosition, yPosition, speed, DEFAULT_DIRECTION);
	}

	public Frog(int xPosition, int yPosition, int speed, int direction) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.speed = 20;
		this.direction = direction;
		this.color = Color.BLUE;
		
		try {
			frogImage = ImageIO.read(new File("image/froggerScaled.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public int getSpeed() {
		return speed;
	}

	public int getDirection() {
		return direction;
	}

	public Color getColor() {
		return color;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public void setSpeed(int speed) {
		//this.speed = speed;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() { return 50; }

	public int getHeight() { return 50; }

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(frogImage, this.getxPosition(), this.getyPosition(), null);
	}
}
