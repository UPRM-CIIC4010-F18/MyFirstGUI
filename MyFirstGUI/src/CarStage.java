import java.awt.Graphics;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	public static int counter = 0;

	private Car theCar = new Car(0,0,10);

	public void paintComponent(Graphics g) {

		theCar.draw(g);

		if (carReachedEdge(theCar)) {
			theCar.setDirection(theCar.getDirection()*-1);
		}
		else {
			theCar.setxPosition(theCar.getxPosition() + (theCar.getSpeed() * theCar.getDirection()));
		}

		counter++;
		System.out.println("Counter = " + counter);

	}

	public boolean carReachedEdge(Car c) {
		return (((theCar.getDirection()>=0) && (theCar.getxPosition()+theCar.getWidth() >= this.getWidth())) || 
				((theCar.getDirection()<0) && (theCar.getxPosition() <= 0)));
	}

}
