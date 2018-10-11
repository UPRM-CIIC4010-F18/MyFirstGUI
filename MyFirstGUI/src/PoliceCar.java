import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class PoliceCar extends Car {

	boolean biomboRed = true;

	private static final int DEFAULT_PIXELS_PER_TICK = 10;
	private static final int DEFAULT_DIRECTION = 1;

	public PoliceCar(int xPosition, int yPosition) {
		this(xPosition, yPosition, DEFAULT_PIXELS_PER_TICK,DEFAULT_DIRECTION);
	}

	public PoliceCar(int xPosition, int yPosition, int speed) {
		this(xPosition, yPosition, speed, DEFAULT_DIRECTION);
	}

	public PoliceCar(int xPosition, int yPosition, int speed, int direction) {
		super(xPosition, yPosition, speed, direction);
	}

	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		super.draw(g2);

		Ellipse2D.Double biombo = new Ellipse2D.Double(this.getxPosition()+50, this.getyPosition()-12, 12, 12);

		if (biomboRed) {
			g2.setColor(Color.BLUE);
			biomboRed = false;
		}
		else {
			g2.setColor(Color.RED);
			biomboRed = true;
		}
		g2.fill(biombo);
	}

}
