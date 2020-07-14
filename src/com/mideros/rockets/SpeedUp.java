package com.mideros.rockets;

import java.util.concurrent.TimeUnit;

public class SpeedUp implements Runnable {

	private Race race;
	private int objPower = 15;
	private Thruster speedThruster = new Thruster();

	public SpeedUp(Race race) {
		this.race = race;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (race.thruster == null)
						wait();
				}
				System.out.println("----SpeedUp, objetive power----");
				speedThruster = race.thruster.speedUpThruster(objPower);

				synchronized (race.brake) {
					race.thruster = new Thruster(speedThruster.getThrusterName(), speedThruster.getMaxPower(),
							speedThruster.getCurrentPower());
					race.brake.notifyAll();

					TimeUnit.MILLISECONDS.sleep(1000);
				}
				if (race.thruster.getCurrentPower() == objPower) {
					race.exec.shutdownNow();
				}

			}
		} catch (InterruptedException e) {
			System.out.println("SpeedUp interrupted");
		}
	}

	public int getObjPower() {
		return objPower;
	}

}