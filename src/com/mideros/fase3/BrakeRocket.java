package com.mideros.fase3;

/**
 * This this class implements Runnable to generate threads one to brake the
 * thrusters.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * 
 */

public class BrakeRocket implements Runnable {

	int brakePower;
	Thruster thruster;

	public BrakeRocket(Thruster thruster, int brakePower) {
		this.thruster = thruster;
		this.brakePower = brakePower;
	}

	@Override
	public void run() {
		
		thruster.brakeThruster(brakePower);
		System.out.println("The thruster decreased to the indicated power");

	}
}