
/**
 * Written by Mostafa Mohamed Ali
 * This class represents Diagonal Robots that runs and updates on a separate threads.
 */
import java.lang.Thread;
import java.awt.*;

public class DiagonalRobot extends SimpleRobot {
	private int speedX; // declare speed
	private int speedY; // declare speed

	private Color rColor = Color.ORANGE;// Default Color
	public static final int ROBOT_SIZE = 15;// Robot's are 15 pixel circles
	public static final int TIME_DELAY = 30;// Update is called every 30 milliseconds.

	public DiagonalRobot(int aX, int aY, Color aC, int speed) {
		super(aX, aY, aC);
		this.speedX = speed;
		this.speedY = speed;
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
		currX += speedX; // update current X

		// to put boundaries for X for movement inside the frame
		if ((this.speedX > 0 && currX >= RobotThreadSimulator.FRAME_DIM) || (this.speedX < 0 && currX <= 0)) {
			this.speedX = -this.speedX;
		}
		super.setX(currX);

		// to put boundaries for Y for movement inside the frame
		int currY = super.getY();
		currY += speedY;
		if ((this.speedY > 0 && currY >= RobotThreadSimulator.FRAME_DIM) || (this.speedY < 0 && currY <= 0)) {
			this.speedY = -this.speedY;
		}
		super.setY(currY);
	}
}