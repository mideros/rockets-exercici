package com.mideros.rockets;

import java.util.concurrent.TimeUnit;

public class Thruster {

	private String nameThruster;
	private int maxPower;
	private int currentPower;

	public Thruster() {
	}

	public Thruster(String nameThruster, int maxPower, int currentPower) {
		super();
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
					System.out.println(" " + this.getThrusterName() + " | " + currentPower);
					try {
						TimeUnit.MILLISECONDS.sleep(50);
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
					System.out.println(" " + this.getThrusterName() + " | " + currentPower);
				}
			}
		}
		return this;
	}

}