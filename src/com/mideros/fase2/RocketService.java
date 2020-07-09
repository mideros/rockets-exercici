package com.mideros.fase2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RocketService {

	public RocketService() {
		// TODO Auto-generated constructor stub
	}
	public Rocket createRocket1() {
		Rocket rocket1 = new Rocket();
		String code = "32WESSDS";
		List<Thruster> thrustersR1 = new ArrayList<Thruster>();

		Thruster thruster1A = new Thruster("R1_thruster1", 10, 0);
		Thruster thruster1B = new Thruster("R1_thruster2", 30, 0);
		Thruster thruster1C = new Thruster("R1_thruster3", 80, 0);

		if (validateThruster(thruster1A)) {
			thrustersR1.add(thruster1A);
		}
		if (validateThruster(thruster1B)) {
			thrustersR1.add(thruster1B);
		}
		if (validateThruster(thruster1C)) {
			thrustersR1.add(thruster1C);
		}

		if (validateCode(code)) {
			rocket1.setCode(code);
		}

		rocket1.setThrusters(thrustersR1);
		return rocket1;

	}

	public Rocket createRocket2() {
		Rocket rocket2 = new Rocket();
		String code = "LDSFJA32";
		List<Thruster> thrustersR2 = new ArrayList<Thruster>();

		Thruster thruster2A = new Thruster("R2_thruster1", 30, 0);
		Thruster thruster2B = new Thruster("R2_thruster2", 40, 0);
		Thruster thruster2C = new Thruster("R2_thruster3", 50, 0);
		Thruster thruster2D = new Thruster("R2_thruster4", 50, 0);
		Thruster thruster2E = new Thruster("R2_thruster5", 30, 0);
		Thruster thruster2F = new Thruster("R2_thruster6", 10, 0);

		if (validateThruster(thruster2A)) {
			thrustersR2.add(thruster2A);
		}
		if (validateThruster(thruster2B)) {
			thrustersR2.add(thruster2B);
		}
		if (validateThruster(thruster2C)) {
			thrustersR2.add(thruster2C);
		}
		if (validateThruster(thruster2D)) {
			thrustersR2.add(thruster2D);
		}
		if (validateThruster(thruster2E)) {
			thrustersR2.add(thruster2E);
		}
		if (validateThruster(thruster2F)) {
			thrustersR2.add(thruster2F);
		}

		if (validateCode(code)) {
			rocket2.setCode(code);
		}
		rocket2.setThrusters(thrustersR2);
		return rocket2;
	}

	public void updateView(Rocket rocket) {

		List<Thruster> thrusters = rocket.getThrusters();

		try {
			System.out.println("");
			System.out.println("----- ROCKET " + rocket.getCode().toUpperCase() + " -----");
			System.out.println("");
		} catch (NullPointerException npe) {
			System.out.println("Please, verify that the rocket data are correct");
		}

		if (!thrusters.isEmpty()) {
			System.out.println("This rocket has " + thrusters.size() + " thusters.");
			System.out.println("");
			Iterator<Thruster> it = thrusters.iterator();
			while (it.hasNext()) {
				Thruster t = it.next();
				System.out.println(
						t.getThrusterName().toUpperCase() + " ==> " + "Maximum thruster power: " + t.getMaxPower());
			}
		} else {
			System.out.println("The rocket " + rocket.getCode() + " has no thrusters!");
			System.out.println("");
		}
	}

	public boolean validateThruster(Thruster thruster) {

		boolean validThruster = false;
		int lengthNameT = thruster.getThrusterName().length();

		if (thruster.getThrusterName().equals("")) {
			validThruster = false;
			System.out.println("You must enter a valid name, minimum of 3 characters and maximum of 15");
		} else {
			if ((lengthNameT < 3) || (lengthNameT > 15)) {
				validThruster = false;
				System.out.println("You must enter a valid name, minimum of 3 characters and maximum of 15");
			} else {
				if (thruster.getMaxPower() <= 0) {
					validThruster = false;
					System.out.println("You must enter a valid maximun power for the thruster");
				} else {
					if (thruster.getCurrentPower() > thruster.getMaxPower()) {
						validThruster = false;
						System.out.println("You must enter a valid current power for the thruster, starts in 0 ");
					} else {
						validThruster = true;
					}
				}
			}
		}
		return validThruster;
	}

	public boolean validateCode(String code) {
		boolean validCode = true;

		try {
			if (code.length() < 8 || code.length() > 8) {
				System.out.println("Please, write a valid code for the rocket, 8 characters long");
				validCode = false;
			} else {
				validCode = true;
			}

		} catch (NullPointerException npe) {
			validCode = false;
			System.out.println("Please, write a valid code for the rocket, 8 characters long");
		}
		return validCode;
	}
}
