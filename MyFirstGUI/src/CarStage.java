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

		theCar.draw(g);
		if (theCar.getDirection()>=0) {
			//Car is going left to to right
			if (theCar.getxPosition()+theCar.getWidth() < this.getWidth()) {
				// Car has not reached border
				theCar.setxPosition(theCar.getxPosition()+theCar.getSpeed());	
			}
			else  {
				theCar.setDirection(-1);
			}
		}
		else {
			// TODO Check for left wall collision
			if (theCar.getxPosition() > 0) {
				theCar.setxPosition(theCar.getxPosition()-theCar.getSpeed());	
			}
			else {
				theCar.setDirection(1);
			}
		}

		counter++;
		System.out.println("Counter = " + counter);

	}

}
