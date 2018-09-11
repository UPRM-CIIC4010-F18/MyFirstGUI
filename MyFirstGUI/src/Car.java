import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Car {
	
	private int xPosition;
	private int yPosition;
	
	public Car(int xPosition, int yPosition) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;

		Rectangle body = new Rectangle(this.getxPosition()+0, this.getyPosition()+20, 120, 30);

		Ellipse2D.Double rearTire = new Ellipse2D.Double(this.getxPosition()+20, this.getyPosition()+50, 20, 20);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(this.getxPosition()+70, this.getyPosition()+50, 20, 20);

		Line2D.Double rearWindow = new Line2D.Double(this.getxPosition()+20, this.getyPosition()+20, 
				this.getxPosition()+40, this.getyPosition()+0);
		Line2D.Double frontWindow = new Line2D.Double(this.getxPosition()+60, this.getyPosition()+0, 
				this.getxPosition()+80, this.getyPosition()+20);
		Line2D.Double roof = new Line2D.Double(this.getxPosition()+40, this.getyPosition()+0, 
				this.getxPosition()+60, this.getyPosition()+0);

		g2.setColor(Color.BLUE);
		g2.fill(body);
		g2.setColor(Color.BLACK);
		g2.fill(rearTire);
		g2.fill(frontTire);
		g2.setColor(Color.BLUE);
		g2.draw(rearWindow);
		g2.draw(frontWindow);
		g2.draw(roof);
	}

}
