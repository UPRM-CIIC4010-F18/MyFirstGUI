import javax.swing.JFrame;
import javax.swing.JOptionPane;

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


		int n=0; 
		while (n==0) {
			
			int[] theWinners = myCarStage.getWinners();
			
			while(theWinners == null) {

				mainFrame.repaint();

				Thread.sleep(1000/30);

				theWinners = myCarStage.getWinners();
			}

			n = JOptionPane.showConfirmDialog(
					mainFrame,
					"Race Again??",
					"End of Race",
					JOptionPane.YES_NO_OPTION);
			
			myCarStage.resetRace();
			//n=0;
		}
		
	}

}
