package com.mideros.fase3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains various methods necessary to validate text fields,
 * numbers, voids, valid power.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * @throws NumberFormatException Thrown to indicate that the application has
 *                               attempted to convert a string to one of the
 *                               numeric types, but that the string does not
 *                               have the appropriate format.
 */

public class DataValidation {

	public DataValidation() {
		super();

	}

	public boolean emptyData(String option) {
		boolean replyEmpty = false;
		if (option.equals("")) {
			replyEmpty = true;
		}
		return replyEmpty;
	}

	public boolean tryNumber(String option) {
		boolean replyValid = true;
		try {
			Integer.parseInt(option);
			replyValid = true;
		} catch (NumberFormatException e) {
			replyValid = false;
		}
		return replyValid;
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

	public boolean validateSpeedR1(String speed, Rocket rocket1) {
		boolean validSpeed = false;
		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = rocket1.getThrusters();
		int count = 0;
		int speedR1 = 0;
		try {
			speedR1 = Integer.parseInt(speed);
			if (speedR1 < 0) {
				validSpeed = false;
				System.out.println("Please, write a valid speed greater than 0");
			} else {
				for (Thruster t : thrusters) {
					if (speedR1 <= t.getMaxPower()) {
						count += 1;						
					}
				}
				if (!(count >= 1 && count <= 3)) {
					validSpeed = false;
					System.out.println("Please, write a valid speed 10,30,80");					
				} else {
					validSpeed = true;
				}
			}
		} catch (NumberFormatException e) {
			validSpeed = false;
		}
		return validSpeed;
	}

	public boolean validateSpeedR2(String speed, Rocket rocket2) {
		boolean validSpeed = false;
		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = rocket2.getThrusters();
		int count = 0;
		int speedR2 = 0;
		try {
			speedR2 = Integer.parseInt(speed);
			if (speedR2 < 0) {
				validSpeed = false;
				System.out.println("Please, write a valid speed greater than 0");
			} else {
				for (Thruster t : thrusters) {
					if (speedR2 <= t.getMaxPower()) {
						count += 1;						
					}
				}
				if (!(count >= 1 && count <= 6)) {
					validSpeed = false;
					System.out.println("Please, write a valid speed 10,30,40,50");					
				} else {
					validSpeed = true;
				}
			}
		} catch (NumberFormatException e) {
			validSpeed = false;
		}
		return validSpeed;
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

	
	public boolean validateMaxPowerThruster(Rocket rocket,  int objPowerRocket) {
		boolean validPower = false;
		
		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = rocket.getThrusters();		
		int count=0;
		
		for(int i=0; i<thrusters.size();i++) {
			
			if(objPowerRocket <= thrusters.get(i).getMaxPower())
			{
				count+=1;
			}		
		}	
		if ( count >=1)  {
			validPower = true;
		}else {			
			validPower = false;
			System.out.println("Please, verify a valid power");
		}	
		return validPower;
	}	
}
