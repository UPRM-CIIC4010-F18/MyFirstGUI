import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class MyComponent extends JComponent {

	public void paintComponent(Graphics g) {

		Car theCar = new Car(0,0);
		
		Car theCar2 = new Car(100,100);
		
		theCar.draw(g);
		theCar2.draw(g);


		//g2.drawString("HelloWorld", 10, 10);

	}

}
