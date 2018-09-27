import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		JFrame mainFrame = new JFrame("My First GUI");

		mainFrame.setSize(800, 600);

		CarStage myCarStage = new CarStage();

		int yPos=0;
		for (int i=0; i<5; i++) {
			myCarStage.addCar(new Car(0, yPos, 10));
			yPos += 80;
		}

		mainFrame.add(myCarStage);

		mainFrame.setVisible(true);

		while(true) {

			mainFrame.repaint();

			Thread.sleep(1000/30);
		}


	}

}
