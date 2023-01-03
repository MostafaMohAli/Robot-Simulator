
/**
 * Written Mostafa Mohamed Ali
 * This class represents Left and Right Robots that runs and updates on a separate threads.
 */
import java.lang.Thread;
import java.awt.*;

public class LeftandRightRobot extends SimpleRobot // Extends (inheritance) the functionality of Thread in order to
													// update the
// Robot's position
{
	private int speed;

	private int x, y;// Location of the Robot
	private Color rColor = Color.BLUE;// Default Color
	public static final int ROBOT_SIZE = 15;// Robot's are 15 pixel circles
	public static final int TIME_DELAY = 30;// Update is called every 30 milliseconds.

	// REMOVED aC Not needed
	public LeftandRightRobot(int aX, int aY, Color aC, int speed) {
		super(aX, aY, aC);
		this.speed = speed;
	}

	public int getX() {
		return super.getX();
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	@Override
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

		// for frame boundaries
		if ((this.speed > 0 && currX >= RobotThreadSimulator.FRAME_DIM) || (this.speed < 0 && currX <= 0)) {
			this.speed = -this.speed;
		}

		currX += speed; // update currX with speed
		x += speed; // update x with speed
		super.setX(currX); // set the new currX
	}
}