package com.mideros.fase3;

import java.util.concurrent.TimeUnit;

/**
 * This this class implements Runnable to generate threads one to brake the
 * thrusters.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * 
 */

public class BrakeRocket extends Thread {

	private int brakePower;
	private Thruster thruster;

	public BrakeRocket() {

	}

	public BrakeRocket(Thruster thruster, int brakePower) {
		this.thruster = thruster;
		this.brakePower = brakePower;
	}

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			thruster.brakeThruster(brakePower);
			System.out.println("The thruster decreased to the indicated power");

		} catch (InterruptedException e) {
			System.out.println("BrakeRocket, interrupted");
		}
	}

}
