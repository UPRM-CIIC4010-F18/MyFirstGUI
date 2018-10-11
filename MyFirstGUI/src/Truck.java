import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Truck extends Vehicle {

	private static final int DEFAULT_PIXELS_PER_TICK = 10;
	private static final int DEFAULT_DIRECTION = 1;

	public Truck(int xPosition, int yPosition) {
		this(xPosition, yPosition, DEFAULT_PIXELS_PER_TICK,DEFAULT_DIRECTION);
	}

	public Truck(int xPosition, int yPosition, int speed) {
		this(xPosition, yPosition, speed, DEFAULT_DIRECTION);
	}

	public Truck(int xPosition, int yPosition, int speed, int direction) {
		super(xPosition, yPosition, speed, direction);
	}

	@Override
	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;


		Rectangle body = new Rectangle(this.getxPosition()+0, this.getyPosition()+20, 120, 30);
		Rectangle cargo = new Rectangle(this.getxPosition()+0, this.getyPosition()+0,60, 30);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(this.getxPosition()+20, this.getyPosition()+50, 20, 20);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(this.getxPosition()+70, this.getyPosition()+50, 20, 20);

		Line2D.Double rearWindow;
		Line2D.Double frontWindow;
		Line2D.Double roof;

		if (this.getDirection() >0) {
			rearWindow = new Line2D.Double(this.getxPosition()+20, this.getyPosition()+20, 
					this.getxPosition()+40, this.getyPosition()+0);
			frontWindow = new Line2D.Double(this.getxPosition()+60, this.getyPosition()+0, 
					this.getxPosition()+80, this.getyPosition()+20);
			roof = new Line2D.Double(this.getxPosition()+40, this.getyPosition()+0, 
					this.getxPosition()+60, this.getyPosition()+0);
		}
		else {
			rearWindow = new Line2D.Double(20+this.getxPosition()+20, this.getyPosition()+20, 
					20+this.getxPosition()+40, this.getyPosition()+0);
			frontWindow = new Line2D.Double(20+this.getxPosition()+60, this.getyPosition()+0, 
					20+this.getxPosition()+80, this.getyPosition()+20);
			roof = new Line2D.Double(20+this.getxPosition()+40, this.getyPosition()+0, 
					20+this.getxPosition()+60, this.getyPosition()+0);
		}
		g2.setColor(this.getColor());
		g2.fill(body);
		g2.fill(cargo);
		g2.draw(rearWindow);
		g2.draw(frontWindow);
		g2.draw(roof);
		g2.setColor(Color.BLACK);
		g2.fill(rearTire);
		g2.fill(frontTire);
	}

}
