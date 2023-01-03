
/**
 * Written by JJ Shepherd
 * This class creates a new JPanel that will specifically draw the robot's.
 */
import java.awt.*;
import javax.swing.*;

public class RobotPanel extends JPanel // Extends (inheritance) the functionality of the JPanel Component in order to
										// draw Robots.
{
	public static final int DEF_R_SIZE = 8; // Default number of Robots
	private SimpleRobot[] robots = new SimpleRobot[DEF_R_SIZE]; // Creates the array of robots to be updated and drawn

	/**
	 * Initializes elements of the JPanel. This method is to be called before added
	 * to a JFrame.
	 */
	public void init() {
		// Set's the JPanel's Preferred Size to be the same as the Frame.
		super.setPreferredSize(new Dimension(RobotThreadSimulator.FRAME_DIM, RobotThreadSimulator.FRAME_DIM));

		// add each robot to the array
		// 2 Simple Robots
		robots[0] = new SimpleRobot(100, 200, Color.GRAY);
		robots[1] = new SimpleRobot(200, 300, Color.darkGray);
		// 2 Left Right Robots
		robots[2] = new LeftandRightRobot(0, 150, Color.BLUE, 5);
		robots[3] = new LeftandRightRobot(100, 350, Color.BLUE, 20);
		// 2 Diagonal Robots
		robots[4] = new DiagonalRobot(0, 10, Color.ORANGE, 5);
		robots[5] = new DiagonalRobot(400, 200, Color.ORANGE, 20);
		// 2 Wavy Robots
		robots[6] = new WavyRobot(0, 50, Color.PINK, 5, 25, 25);
		robots[7] = new WavyRobot(50, 30, Color.PINK, 20, 50, 50);

		// to run all robots
		for (int i = 0; i < robots.length; i++) {
			if (robots[i] != null) {
				robots[i].start();
			}
		}
	}

	/**
	 * Overrides JPanel's paintComponent method in order to draw each robot.
	 */
	public void paintComponent(Graphics g) {
		// Calling super class' paintComponents first
		super.paintComponent(g);
		// For each robot in the array of robots
		for (SimpleRobot r : robots) {
			if (r == null)
				continue;
			// Sets the drawing color
			g.setColor(r.getrColor());
			// Draws the oval to the JPanel
			g.fillOval(r.getX(), r.getY(), SimpleRobot.ROBOT_SIZE, SimpleRobot.ROBOT_SIZE);
		}
	}
}