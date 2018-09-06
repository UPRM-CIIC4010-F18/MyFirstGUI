import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame("My First GUI");
		
		mainFrame.setSize(500, 600);
		
		MyComponent myComponent = new MyComponent();
		
		mainFrame.add(myComponent);
		
		mainFrame.setVisible(true);
		
		
	}
	
}
