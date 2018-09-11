import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class MyComponent extends JComponent {
	
	public static int counter = 0;

	public void paintComponent(Graphics g) {

		Car theCar = new Car(0,0);
		
		Car theCar2 = new Car(100,100);
		int xLowerRight = this.getWidth()-theCar2.getWidth();
		int yLowerRight = this.getHeight()-theCar2.getHeight();
		theCar2.setxPosition(xLowerRight);
		theCar2.setyPosition(yLowerRight);
		
		theCar.draw(g);
		theCar2.draw(g);
		
		counter++;
		System.out.println("Counter = " + counter);

		//g2.drawString("HelloWorld", 10, 10);

	}

}
