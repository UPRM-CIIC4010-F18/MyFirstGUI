import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle extends AbstractRaceable implements Raceable {

	private static final int DEFAULT_PIXELS_PER_TICK = 10;
	private static final int DEFAULT_DIRECTION = 1;

	public Vehicle(int xPosition, int yPosition) {
		this(xPosition, yPosition, DEFAULT_PIXELS_PER_TICK,DEFAULT_DIRECTION);
	}

	public Vehicle(int xPosition, int yPosition, int speed) {
		this(xPosition, yPosition, speed, DEFAULT_DIRECTION);
	}

	public Vehicle(int xPosition, int yPosition, int speed, int direction) {
		super(xPosition, yPosition, speed, direction);
//		this.xPosition = xPosition;
//		this.yPosition = yPosition;
//		this.speed = speed;
//		this.direction = direction;
//		this.color = Color.BLUE;
	}

	public int getWidth() { return 120; }

	public int getHeight() { return 80; }

	public abstract void draw(Graphics g);

}
