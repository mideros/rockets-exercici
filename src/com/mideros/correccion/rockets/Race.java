package com.mideros.correccion.rockets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class contains the method to request the acceleration and braking powers
 * of each one of the rockets; validating each of the entered data. The two
 * rockets are also created and initialized. In the main, a race instance is
 * created and the ExecutorService execution is started.
 * 
 * @author Yohanna Mideros Giraldo
 *
 */

public class Race {

	ExecutorService exec = Executors.newCachedThreadPool();
	DataValidation validObj = new DataValidation();
	Rocket1 rocket1 = new Rocket1(this);
	Rocket2 rocket2 = new Rocket2(this);
	List<Thruster> thrustersR1 = new ArrayList<Thruster>();
	List<Thruster> thrustersR2 = new ArrayList<Thruster>();
	int[] powers = { 0, 0, 0, 0 };

	Scanner lector = new Scanner(System.in);

	public Race() {

		rocket1.createRocket1();
		rocket2.createRocket2();
		thrustersR1 = rocket1.getThrusters();
		thrustersR2 = rocket2.getThrusters();
		powers = askPowers();

		exec.execute(rocket1);
		exec.execute(rocket2);

	}

	public static void main(String[] args) {

		new Race();

	}

	public int[] askPowers() {
		int[] powers = { 0, 0, 0, 0 };
		String pwr = "";
		int pA1 = 0, pA2 = 0, pB1 = 0, pB2 = 0;

		System.out.println("Please write the acceleration power of Rocket1:");
		pwr = addPower();
		boolean validatePower = validObj.validateSpeedR1(pwr, rocket1);
		while (!validatePower) {
			System.out.println("Please write a valid acceleration power of Rocket1:");
			pwr = addPower();
			validatePower = validObj.validateSpeedR1(pwr, rocket1);
		}
		pA1 = Integer.parseInt(pwr);
		powers[0] = pA1;

		System.out.println("Please write the acceleration power of Rocket2:");
		pwr = addPower();
		boolean validatePower2 = validObj.validateSpeedR2(pwr, rocket2);
		while (!validatePower2) {
			System.out.println("Please write a valid acceleration power of Rocket2:");
			pwr = addPower();
			validatePower2 = validObj.validateSpeedR2(pwr, rocket2);
		}
		pA2 = Integer.parseInt(pwr);
		powers[1] = pA2;

		System.out.println("Please write a braking power of Rocket1:");
		pwr = addPower();
		boolean validatePower3 = validObj.validateBrakePwrR1(pwr, rocket1, pA1);
		while (!validatePower3) {
			System.out.println("Please write a valid braking power of Rocket1:");
			pwr = addPower();
			validatePower3 = validObj.validateBrakePwrR1(pwr, rocket1, pA1);
		}
		pB1 = Integer.parseInt(pwr);
		powers[2] = pB1;

		System.out.println("Please write a braking power of Rocket2:");
		pwr = addPower();
		boolean validatePower4 = validObj.validateBrakePwrR2(pwr, rocket2, pA2);
		while (!validatePower4) {
			System.out.println("Please write a valid braking power of Rocket2:");
			pwr = addPower();
			validatePower4 = validObj.validateBrakePwrR2(pwr, rocket2, pA2);
		}
		pB2 = Integer.parseInt(pwr);
		powers[3] = pB2;

		return powers;
	}

	public String addPower() {
		String pwr = "";
		pwr = lector.nextLine();
		return pwr;
	}
}
