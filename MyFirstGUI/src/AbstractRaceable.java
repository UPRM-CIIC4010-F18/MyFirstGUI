import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractRaceable implements Raceable {
	
	private int xPosition;
	private int yPosition;
	private int speed; // Vehicle speed in pixels per second
	private int direction;
	
	public AbstractRaceable(int xPosition, int yPosition, int speed, int direction) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.speed = speed;
		this.direction = direction;
		this.color = Color.BLUE;
	}

	private Color color;

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

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract void draw(Graphics g);
	
	// Comparable<Raceable> interface methods
	public int compareTo(Raceable r) {
		return -((this.getxPosition()+this.getWidth()) - 
				(r.getxPosition() + r.getWidth()));
	}
}
