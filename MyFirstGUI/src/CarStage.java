import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	public static int counter = 0;

	Car[] theCars=null;
	private int numCars=0;
	
	Car[] newArray;

	private static int INITIAL_NUM_CARS = 5;
	
	private Random generator;
	
	CarStage() {
		generator = new Random();
	}

	public void addCar(Car c) {
		if (theCars == null) {
			theCars = new Car[INITIAL_NUM_CARS];
			theCars[0] = c;
		}
		else if (numCars<theCars.length) {
			// There is room in the array
			theCars[numCars] = c;
		}
		else {
			Car[] newArray = new Car[theCars.length*2];
			for (int i=0; i<numCars; i++) {
				newArray[i] = theCars[i];
			}
			newArray[theCars.length]= c;
			theCars = newArray;
		}
		numCars++;
	}

	public void paintComponent(Graphics g) {

		for (int i =0; i<numCars; i++) {
			theCars[i].draw(g);
			if (carReachedEdge(theCars[i])) {
				theCars[i].setDirection(theCars[i].getDirection()*-1);
			}
			else {
				int displacement = generator.nextInt(theCars[i].getSpeed());
				theCars[i].setxPosition(theCars[i].getxPosition() + (displacement * theCars[i].getDirection()));
			}
		}

		counter++;
		System.out.println("Counter = " + counter);

	}

	public boolean carReachedEdge(Car c) {
		return (((c.getDirection()>=0) && (c.getxPosition()+c.getWidth() >= this.getWidth())) || 
				((c.getDirection()<0) && (c.getxPosition() <= 0)));
	}

}
