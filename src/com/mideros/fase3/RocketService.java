package com.mideros.fase3;

/**
 * This this class contains the necessary methods to generate rockets, 
 * thrusters and the call and initialization of two threads one to accelerate 
 * and brake the thrusters.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class RocketService {

	
	private DataValidation v = new DataValidation();


	public RocketService() {
		// TODO Auto-generated constructor stub
	}

	// create the rocket1
	public Rocket createRocket1() {
		Rocket rocket1 = new Rocket();
		String code = "32WESSDS";
		List<Thruster> thrustersR1 = new ArrayList<Thruster>();

		Thruster thruster1A = new Thruster("R1_thruster1", 10, 0);
		Thruster thruster1B = new Thruster("R1_thruster2", 30, 0);
		Thruster thruster1C = new Thruster("R1_thruster3", 80, 0);

		if (v.validateThruster(thruster1A)) {
			thrustersR1.add(thruster1A);
		}
		if (v.validateThruster(thruster1B)) {
			thrustersR1.add(thruster1B);
		}
		if (v.validateThruster(thruster1C)) {
			thrustersR1.add(thruster1C);
		}

		if (v.validateCode(code)) {
			rocket1.setCode(code);
		}

		rocket1.setThrusters(thrustersR1);

		return rocket1;

	}

	// create the rocket2
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

		if (v.validateThruster(thruster2A)) {
			thrustersR2.add(thruster2A);
		}
		if (v.validateThruster(thruster2B)) {
			thrustersR2.add(thruster2B);
		}
		if (v.validateThruster(thruster2C)) {
			thrustersR2.add(thruster2C);
		}
		if (v.validateThruster(thruster2D)) {
			thrustersR2.add(thruster2D);
		}
		if (v.validateThruster(thruster2E)) {
			thrustersR2.add(thruster2E);
		}
		if (v.validateThruster(thruster2F)) {
			thrustersR2.add(thruster2F);
		}
		if (v.validateCode(code)) {
			rocket2.setCode(code);
		}
		rocket2.setThrusters(thrustersR2);
		return rocket2;
	}
	

	// select one thruster according to the selected power
	public Thruster generateThuster(Rocket rocket, int objPowerRocket) {

		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = rocket.getThrusters();
		Thruster thruster = new Thruster();

		for (int i = 0; i < thrusters.size(); i++) {

			if (objPowerRocket == thrusters.get(i).getMaxPower()) {
				thruster = thrusters.get(i);
				break;
			} else {
				if (objPowerRocket < thrusters.get(i).getMaxPower()) {
					thruster = thrusters.get(i);
					break;
				} else {
					if (!(thrusters.get(i).getMaxPower() < objPowerRocket)) {
						thruster = thrusters.get(i + 1);
					}
				}
			}
		}
		return thruster;
	}
}