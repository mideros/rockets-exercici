package com.mideros.fase1;

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
}