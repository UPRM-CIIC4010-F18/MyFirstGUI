import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Frog extends AbstractRaceable implements Raceable {
	
	private static final int DEFAULT_PIXELS_PER_TICK = 10;
	private static final int DEFAULT_DIRECTION = 1;
	
	Image frogImage;

	public Frog(int xPosition, int yPosition) {
		this(xPosition, yPosition, DEFAULT_PIXELS_PER_TICK,DEFAULT_DIRECTION);
	}

	public Frog(int xPosition, int yPosition, int speed) {
		this(xPosition, yPosition, speed, DEFAULT_DIRECTION);
	}

	public Frog(int xPosition, int yPosition, int speed, int direction) {
		super(xPosition, yPosition, speed, direction);
		
		try {
			frogImage = ImageIO.read(new File("image/froggerScaled.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	@Override
	public int getWidth() { return 50; }

	@Override
	public int getHeight() { return 50; }

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(frogImage, this.getxPosition(), this.getyPosition(), null);
	}
}
