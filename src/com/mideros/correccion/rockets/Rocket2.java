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

public class Rocket2 extends Rocket implements Runnable {

	private Race race;
	private int objPower2 = 0;
	private Thruster speedThruster2 = new Thruster();
	private Thruster thruster2 = new Thruster();
	private Thruster brakeThruster2 = new Thruster();
	private int objBrake2 = 0;
	private String name2 = "";
	private int position2 = 0;

	public Rocket2(Race race) {
		this.race = race;
	}

	@Override
	public void run() {

		objPower2 = race.powers[1];
		objBrake2 = race.powers[3];

		thruster2 = generateThuster2(objPower2);
		name2 = thruster2.getThrusterName();

		for (int i = 0; i < this.getThrusters().size(); i++) {

			if (name2.equals(this.getThrusters().get(i).getThrusterName())) {
				position2 = i;
				break;
			}
		}
		
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (thruster2 == null)
						wait();
				}

				System.out.println(" ");
				System.out.println("----SpeedUp, objetive power " + race.rocket2.getCode() + "----");
				speedThruster2 = thruster2.speedUpThruster(objPower2);

				thruster2 = new Thruster(speedThruster2.getThrusterName(), speedThruster2.getMaxPower(),
						speedThruster2.getCurrentPower());
				race.thrustersR2.set(position2, thruster2);
				TimeUnit.MILLISECONDS.sleep(2000);

				synchronized (this) {

					thruster2 = race.thrustersR2.get(position2);

					while (thruster2.getCurrentPower() < objPower2) {
						wait();
					}

					System.out.println("");
					System.out.println(
							"----Brake " + race.rocket2.getCode() + "with " + thruster2.getThrusterName() + " ----");
					System.out.println("");
					brakeThruster2=thruster2.brakeThruster(objBrake2);
					notifyAll();
				}

				if (brakeThruster2.getCurrentPower() == objBrake2) {
					race.exec.shutdownNow();
				}
			}

		} catch (InterruptedException e) {
			System.out.println("SpeedUp interrupted");
		}
	}

	public Rocket createRocket2() {

		List<Thruster> thrustersR2 = new ArrayList<Thruster>();

		Thruster thruster2A = new Thruster("R2_thruster1", 30, 0);
		Thruster thruster2B = new Thruster("R2_thruster2", 40, 0);
		Thruster thruster2C = new Thruster("R2_thruster3", 50, 0);
		Thruster thruster2D = new Thruster("R2_thruster4", 50, 0);
		Thruster thruster2E = new Thruster("R2_thruster5", 30, 0);
		Thruster thruster2F = new Thruster("R2_thruster6", 10, 0);

		thrustersR2.add(thruster2A);
		thrustersR2.add(thruster2B);
		thrustersR2.add(thruster2C);
		thrustersR2.add(thruster2D);
		thrustersR2.add(thruster2E);
		thrustersR2.add(thruster2F);
		this.setCode("LDSFJA32");
		this.setThrusters(thrustersR2);

		return this;
	}
	
	public Thruster generateThuster2(int objPower2) {

		List<Thruster> thrusters2 = new ArrayList<Thruster>();
		thrusters2 = this.getThrusters();
		Thruster thruster2 = new Thruster();
	
		if (objPower2 <= 10) {
			thruster2 = thrusters2.get(5);
		} else {
			if (objPower2 > 10 && objPower2 <= 30) {
				thruster2 = thrusters2.get(0); // o thrusters2.get(4);
			} else {
				if (objPower2 > 30 && objPower2 <= 40) {
					thruster2 = thrusters2.get(1);
				} else {
					if (objPower2 > 40 && objPower2 <= 50) {
						thruster2 = thrusters2.get(2); // o thrusters2.get(3);
					}
				}
			}
		}
		return thruster2;
	}
}