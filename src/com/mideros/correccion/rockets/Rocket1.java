package com.mideros.correccion.rockets;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class inherits from the rocket model and implements Runnable, it
 * contains three methods, create the rocket, select thruster and the main one
 * of run to execute the routine of accelerating and then braking the thread at
 * indicated powers. select thruster choose which is the appropriate thruster to
 * accelerate the input power.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * @throws InterruptedException Thrown when a thread is waiting, sleeping, or
 *                              otherwise occupied,and the thread is
 *                              interrupted, either before or during the
 *                              activity. * 
 */

public class Rocket1 extends Rocket implements Runnable {

	private Race race;
	private int objPower = 0;
	private Thruster speedThruster = new Thruster();
	private Thruster thruster = new Thruster();
	private Thruster brakeThruster = new Thruster();
	private int objBrake = 0;
	private String name = "";
	private int position = 0;

	public Rocket1(Race race) {
		this.race = race;
	}

	@Override
	public void run() {

		objPower = race.powers[0];
		objBrake = race.powers[2];

		thruster = generateThuster(objPower);
		name = thruster.getThrusterName();

		for (int i = 0; i < this.getThrusters().size(); i++) {

			if (name.equals(this.getThrusters().get(i).getThrusterName())) {
				position = i;
				break;
			}
		}

		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (thruster == null)
						wait();
				}

				System.out.println("----SpeedUp, objetive power " + race.rocket1.getCode() + "----");
				speedThruster = thruster.speedUpThruster(objPower);

				thruster = new Thruster(speedThruster.getThrusterName(), speedThruster.getMaxPower(),
						speedThruster.getCurrentPower());
				race.thrustersR1.set(position, thruster);
				TimeUnit.MILLISECONDS.sleep(1000);

				synchronized (this) {

					thruster = race.thrustersR1.get(position);

					while (thruster.getCurrentPower() < objPower) {
						wait();
					}
					System.out.println("");
					System.out.println(
							"----Brake " + race.rocket1.getCode() + "with " + thruster.getThrusterName() + " ----");
					System.out.println("");
					brakeThruster = thruster.brakeThruster(objBrake);
					notifyAll();
				}

				if (brakeThruster.getCurrentPower() == objBrake) {
					race.exec.shutdownNow();
				}
			}

		} catch (InterruptedException e) {
			System.out.println("SpeedUp interrupted");
		}

	}

	public Rocket createRocket1() {

		String code1 = "32WESSDS";
		List<Thruster> thrustersR1 = new ArrayList<Thruster>();

		Thruster thruster1A = new Thruster("R1_thruster1", 10, 0);
		Thruster thruster1B = new Thruster("R1_thruster2", 30, 0);
		Thruster thruster1C = new Thruster("R1_thruster3", 80, 0);

		thrustersR1.add(thruster1A);
		thrustersR1.add(thruster1B);
		thrustersR1.add(thruster1C);
		this.setCode(code1);
		this.setThrusters(thrustersR1);

		return this;
	}

	public Thruster generateThuster(int objPower) {

		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = this.getThrusters();
		Thruster thruster = new Thruster();

		if (objPower <= 10) {
			thruster = thrusters.get(0);
		} else {
			if (objPower > 10 && objPower <= 30) {
				thruster = thrusters.get(1);
			} else {
				if (objPower > 30 && objPower <= 80) {
					thruster = thrusters.get(2);
				}
			}
		}
		return thruster;
	}
}