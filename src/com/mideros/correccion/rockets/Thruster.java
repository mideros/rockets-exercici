package com.mideros.correccion.rockets;

import java.util.concurrent.TimeUnit;

/**
 * This class creates the thruster model. It contains two main methods , one to
 * speed Up Thruster and the other to brake the Thruster.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * @throws InterruptedException Thrown when a thread is waiting, sleeping, or
 *                              otherwise occupied,and the thread is
 *                              interrupted, either before or during the
 *                              activity.
 * 
 */

public class Thruster {

	private String nameThruster;
	private int maxPower;
	private int currentPower;

	public Thruster() {

	}

	public Thruster(String nameThruster, int maxPower, int currentPower) {
		this.nameThruster = nameThruster;
		this.maxPower = maxPower;
		this.currentPower = currentPower;

	}

	public String getThrusterName() {
		return nameThruster;
	}

	public void setThrusterName(String name) {
		this.nameThruster = name;
	}

	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}

	public Thruster speedUpThruster(int objPower) {

		int currentPower = this.getCurrentPower();

		while (this.getCurrentPower() < objPower) {

			for (int i = 1; i <= objPower; i++) {

				if (i <= objPower) {
					currentPower += 1;
					this.setCurrentPower(currentPower);
					System.out.println("SpeedingUp " + this.getThrusterName() + " | " + currentPower);
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return this;
	}

	public Thruster brakeThruster(int brakePower) {

		int currentPower = this.getCurrentPower();

		while (currentPower > 0) {

			for (int j = currentPower; j >= brakePower + 1; j--) {
				if (j >= brakePower) {
					currentPower -= 1;
					this.setCurrentPower(currentPower);
					System.out.println("Braking    " + this.getThrusterName() + " | " + currentPower);
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}
				}
			}
		}
		return this;
	}
}