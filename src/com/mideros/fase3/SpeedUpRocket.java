package com.mideros.fase3;

/**
 * This this class implements Runnable to generate threads one to speed up the
 * thrusters.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * 
 */

public class SpeedUpRocket implements Runnable {

	private int objPower;
	Thruster thruster;
	RocketService service = new RocketService();

	public SpeedUpRocket(Thruster thruster, int objPower) {
		this.objPower = objPower;
		this.thruster = thruster;
	}

	@Override
	public void run() {

		thruster.speedUpThruster(objPower);
		System.out.println("The thruster has reached the indicated initial power");

	}
}
