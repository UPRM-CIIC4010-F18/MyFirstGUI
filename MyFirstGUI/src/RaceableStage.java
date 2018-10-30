import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JComponent;

public class RaceableStage extends JComponent {

	public static int counter = 0;

	Raceable[] theRaceables=null;
	private int numRaceables=0;

	Raceable[] newArray;

	private static int INITIAL_NUM_CARS = 5;

	private Random generator;

	RaceableStage() {
		generator = new Random();
	}

	public void addRaceable(Raceable c) {
		if (theRaceables == null) {
			theRaceables = new Raceable[INITIAL_NUM_CARS];
			theRaceables[0] = c;
		}
		else if (numRaceables<theRaceables.length) {
			// There is room in the array
			theRaceables[numRaceables] = c;
		}
		else {
			Raceable[] newArray = new Raceable[theRaceables.length*2];
			for (int i=0; i<numRaceables; i++) {
				newArray[i] = theRaceables[i];
			}
			newArray[theRaceables.length]= c;
			theRaceables = newArray;
		}
		numRaceables++;
	}

	public void paintComponent(Graphics g) {

		for (int i =0; i<numRaceables; i++) {
			theRaceables[i].draw(g);
			if (carReachedEdge(theRaceables[i])) {
				theRaceables[i].setDirection(theRaceables[i].getDirection()*-1);
			}
			else {
				int displacement = generator.nextInt(theRaceables[i].getSpeed());
				theRaceables[i].setxPosition(theRaceables[i].getxPosition() + (displacement * theRaceables[i].getDirection()));
			}
		}

		int xMax = theRaceables[0].getxPosition();
		for(int i=1; i<numRaceables; i++) {
			if (theRaceables[i].getxPosition() > xMax) {
				xMax = theRaceables[i].getxPosition();
			}
		}

		for(int i=0; i<numRaceables; i++) {
			if (theRaceables[i].getxPosition() == xMax) {
				theRaceables[i].setColor(Color.ORANGE);
			}
			else {
				theRaceables[i].setColor(Color.BLUE);
			}
		}
		
		theRaceables = Arrays.copyOf(theRaceables, numRaceables);

		Arrays.sort(theRaceables);
		
		Graphics2D g2 = (Graphics2D) g;
		for(int i=0; i<numRaceables; i++) {
			g2.drawString(i+"", theRaceables[i].getxPosition()+5, theRaceables[i].getyPosition()+5);
		}

		counter++;
		System.out.println("Counter = " + counter);

	}

	public boolean carReachedEdge(Raceable c) {
		return (((c.getDirection()>=0) && (c.getxPosition()+c.getWidth() >= this.getWidth())) || 
				((c.getDirection()<0) && (c.getxPosition() <= 0)));
	}

	public int[] getWinners() {
		int[] winners = new int[numRaceables];
		int winnerCount = 0;
		for (int i=0; i<numRaceables; i++ ) {
			if (carReachedEdge(theRaceables[i])) {
				winners[winnerCount] = i;
				winnerCount++;
			}
		}
		for (int i=winnerCount; i<numRaceables; i++) {
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
		for (int i=0; i<numRaceables; i++) {
			theRaceables[i].setxPosition(0);
		}	
	}

}
