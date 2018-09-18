import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {
	
	public static int counter = 0;
	
	private Car theCar = new Car(0,0,10);

	public void paintComponent(Graphics g) {
		
//		Car theCar2 = new Car(100,100);
//		int xLowerRight = this.getWidth()-theCar2.getWidth();
//		int yLowerRight = this.getHeight()-theCar2.getHeight();
//		theCar2.setxPosition(xLowerRight);
//		theCar2.setyPosition(yLowerRight);
		
//		Random genRand = new Random();
//		
//		Car theCar3 = new Car(0,0);
//		int randomX = genRand.nextInt(this.getWidth()-theCar.getWidth());
//		int randomY = genRand.nextInt(this.getHeight()-theCar.getHeight());
//		theCar3.setxPosition(randomX);
//		theCar3.setyPosition(randomY);
		
		theCar.draw(g);
		theCar.setxPosition(theCar.getxPosition()+theCar.getSpeed());
		
//		theCar2.draw(g);
//		theCar3.draw(g);
		
		counter++;
		System.out.println("Counter = " + counter);

		//g2.drawString("HelloWorld", 10, 10);

	}

}
