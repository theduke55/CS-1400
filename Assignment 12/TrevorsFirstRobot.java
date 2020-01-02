package cs;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * TrevorsFirstRobot - a robot by (your name here)
 */
public class TrevorsFirstRobot extends Robot
{
	/**
	 * run: TrevorsFirstRobot's default behavior
	 */
			int turnDirection = 1;
			
	public void run() {
		// Initialization of the robot should be put here
		
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setBodyColor(Color.black);
		setGunColor(Color.red);
		setRadarColor(Color.white);
		setBulletColor(Color.red);
		
		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnRight(10 * turnDirection);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// turning robot towards enemy bots
		if(e.getBearing() >= 0 )
		{
			turnDirection = 1;
		}
		else
		{
			turnDirection = -1;
		}
		
		turnRight(e.getBearing());
		
		// gauging distance, firing, and moving
		if(e.getDistance() < 200)
		{
			fire(3);
		}
		else if(e.getDistance() < 300)
		{
			fire(2);
		}
		else
		{
			fire(1);
		}
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(25);
		back(50);
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		turnLeft(10);
		ahead(100);
	}	
}
