import java.awt.Color;
import java.awt.Graphics;

public interface Raceable extends Comparable<Raceable> {
	
	public int getxPosition();
	public int getyPosition();
	public int getSpeed();
	public int getDirection();
	public Color getColor();
	public void setxPosition(int xPosition);
	public void setyPosition(int yPosition);
	public void setSpeed(int speed);
	public void setDirection(int direction);
	public void setColor(Color color);
	public int getWidth();
	public int getHeight();
	public void draw(Graphics g);
	
}
