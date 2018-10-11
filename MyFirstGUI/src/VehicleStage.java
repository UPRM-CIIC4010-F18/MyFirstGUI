import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class VehicleStage extends JComponent {

	public static int counter = 0;

	Vehicle[] theVehicles=null;
	private int numVehicles=0;

	Vehicle[] newArray;

	private static int INITIAL_NUM_CARS = 5;

	private Random generator;

	VehicleStage() {
		generator = new Random();
	}

	public void addVehicle(Vehicle c) {
		if (theVehicles == null) {
			theVehicles = new Vehicle[INITIAL_NUM_CARS];
			theVehicles[0] = c;
		}
		else if (numVehicles<theVehicles.length) {
			// There is room in the array
			theVehicles[numVehicles] = c;
		}
		else {
			Vehicle[] newArray = new Vehicle[theVehicles.length*2];
			for (int i=0; i<numVehicles; i++) {
				newArray[i] = theVehicles[i];
			}
			newArray[theVehicles.length]= c;
			theVehicles = newArray;
		}
		numVehicles++;
	}

	public void paintComponent(Graphics g) {

		for (int i =0; i<numVehicles; i++) {
			theVehicles[i].draw(g);
			if (carReachedEdge(theVehicles[i])) {
				theVehicles[i].setDirection(theVehicles[i].getDirection()*-1);
			}
			else {
				int displacement = generator.nextInt(theVehicles[i].getSpeed());
				theVehicles[i].setxPosition(theVehicles[i].getxPosition() + (displacement * theVehicles[i].getDirection()));
			}
		}

		int xMax = theVehicles[0].getxPosition();
		for(int i=1; i<numVehicles; i++) {
			if (theVehicles[i].getxPosition() > xMax) {
				xMax = theVehicles[i].getxPosition();
			}
		}

		for(int i=0; i<numVehicles; i++) {
			if (theVehicles[i].getxPosition() == xMax) {
				theVehicles[i].setColor(Color.ORANGE);
			}
			else {
				theVehicles[i].setColor(Color.BLUE);
			}
		}		

		counter++;
		System.out.println("Counter = " + counter);

	}

	public boolean carReachedEdge(Vehicle c) {
		return (((c.getDirection()>=0) && (c.getxPosition()+c.getWidth() >= this.getWidth())) || 
				((c.getDirection()<0) && (c.getxPosition() <= 0)));
	}

	public int[] getWinners() {
		int[] winners = new int[numVehicles];
		int winnerCount = 0;
		for (int i=0; i<numVehicles; i++ ) {
			if (carReachedEdge(theVehicles[i])) {
				winners[winnerCount] = i;
				winnerCount++;
			}
		}
		for (int i=winnerCount; i<numVehicles; i++) {
			winners[i] = -1;
		}
		
		if (winnerCount == 0) {
			return null;
		}
		else {
			return winners;
		}
	}
	
	public void resetRace() {
		for (int i=0; i<numVehicles; i++) {
			theVehicles[i].setxPosition(0);
		}	
	}

}
