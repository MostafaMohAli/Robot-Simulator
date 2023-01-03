
/**
 * Written by Mostafa Mohamed Ali
 * This class represents Wavy Robots that runs and updates on a separate threads.
 */
import java.lang.Thread;
import java.time.Period;

import javax.swing.SpinnerModel;

import java.awt.*;

public class WavyRobot extends SimpleRobot // Extends (inheritance) the functionality of Thread in order to update the
											// Robot's position
{
	private int speedX; // declare speed for X
	private int speedY; // declare speed for Y
	private int AMPLITUDE; // declare amplitude for the wave
	private int PERIOD; // declare period for the wave

	private int x, y;// Location of the Robot
	private Color rColor = Color.PINK;// Default Color
	public static final int ROBOT_SIZE = 15;// Robot's are 15 pixel circles
	public static final int TIME_DELAY = 30;// Update is called every 30 milliseconds.

	public WavyRobot(int aX, int aY, Color aC, int speed, int AMPLITUDE, int PERIOD) {
		super(aX, aY, aC);
		this.speedX = speed;
		this.speedY = speed;
		this.AMPLITUDE = AMPLITUDE;
		this.PERIOD = PERIOD;
	}

	public int getX() {
		return super.getX();
	}

	public void setX(int x) {
		this.x = x;
	}

	public Color getrColor() {
		return rColor;
	}

	public void setrColor(Color rColor) {
		this.rColor = rColor;
	}

	/**
	 * Overrides the method run in Thread. This calls the method update and sleeps
	 * the thread for 30 milliseconds before calling update again.
	 */
	public void run() {
		while (true) {
			// Calls update on each robot
			this.update();
			// Sleeps this thread for 30 milliseconds before updating again
			try {
				Thread.sleep(TIME_DELAY);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This updates the position of the robot based on the robot's type. This is
	 * meant to be overridden for other extended robot types.
	 */
	@Override
	public void update() {
		int currX = super.getX();
		int currY = super.getY();

		currX += speedX; // update current X
		// to put boundaries for X for movement inside the frame
		if ((this.speedX > 0 && currX >= RobotThreadSimulator.FRAME_DIM) || (this.speedX < 0 && currX <= 0)) {
			this.speedX = -this.speedX;
			this.PERIOD = -this.PERIOD;
		}
		super.setX(currX);

		currY = (int) (currY + Math.sin(currX * PERIOD) * AMPLITUDE);
		// to put boundaries for Y for movement inside the frame
		if ((this.speedY > 0 && currY >= AMPLITUDE)) {
			this.speedY = -this.speedY;
			this.AMPLITUDE = -this.AMPLITUDE;
		}
		super.setY(currY);
	}
}