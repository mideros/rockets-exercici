package com.mideros.rockets;

public class Brake implements Runnable {

	private Race race;
	private Thruster brakeThruster = new Thruster();
	private int objBrake = 5;
	private int objPower = 0;

	public Brake(Race race) {
		// TODO Auto-generated constructor stub
		this.race = race;
	}

	public void run() {
		try {
			objPower = race.speedUp.getObjPower();
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (race.thruster.getCurrentPower() < objPower)
						wait();
				}
				System.out.println("----Brake thruster----");
				setBrakeThruster(race.thruster.brakeThruster(objBrake));

				synchronized (race.speedUp) {
					race.thruster = null;
					race.speedUp.notifyAll();
					race.exec.shutdownNow();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Brake interrupted");
		}
	}

	public Thruster getBrakeThruster() {
		return brakeThruster;
	}

	public void setBrakeThruster(Thruster brakeThruster) {
		this.brakeThruster = brakeThruster;
	}
}