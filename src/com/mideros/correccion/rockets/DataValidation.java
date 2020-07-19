package com.mideros.correccion.rockets;

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


	public boolean validateSpeedR1(String speed, Rocket rocket1) {
		boolean validSpeed = false;
		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = rocket1.getThrusters();
		int count = 0;
		int speedR1 = 0;
		try {
			speedR1 = Integer.parseInt(speed);
			if (speedR1 < 1) {
				System.out.println("Please, write a valid speed greater than 0");
				validSpeed = false;				
			} else {
				for (Thruster t : thrusters) {
					if (speedR1 <= t.getMaxPower()) {
						count += 1;						
					}
				}
				if (!(count >= 1 && count <= 3)) {
					System.out.println("Please, write a valid speed 10,30,80");	
					validSpeed = false;									
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
			if (speedR2 < 1) {
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
	
	public boolean validateBrakePwrR1(String speed, Rocket rocket1, int pA1) {
		boolean validSpeed = false;
		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = rocket1.getThrusters();
		int count = 0;
		int speedR1 = 0;
		try {
			speedR1 = Integer.parseInt(speed);
			if (speedR1 < 0) {
				System.out.println("Please, write a positive value.");
				validSpeed = false;				
			} else {
				if(speedR1>=pA1) {
					validSpeed = false;
					System.out.println("Please,  write a valid power less than "+ pA1);					
				}else {
					for (Thruster t : thrusters) {
						if (speedR1 <= t.getMaxPower()) {
							count += 1;						
						}
					}
					if (!(count >= 1 && count <= 3)) {
						System.out.println("Please, write a valid speed 10,30,80");	
						validSpeed = false;									
					} else {
						validSpeed = true;
					}
				}
			}
		} catch (NumberFormatException e) {
			validSpeed = false;
		}
		return validSpeed;
	}
	
	public boolean validateBrakePwrR2(String speed, Rocket rocket2, int pA2) {
		boolean validSpeed = false;
		List<Thruster> thrusters = new ArrayList<Thruster>();
		thrusters = rocket2.getThrusters();
		int count = 0;
		int speedR2 = 0;
		try {
			speedR2 = Integer.parseInt(speed);
			if (speedR2 < 0) {
				validSpeed = false;
				System.out.println("Please, write a positive value.");
			} else {
				if(speedR2 >= pA2) {
					validSpeed = false;
					System.out.println("Please,  write a valid power less than "+ pA2);
				}	else {
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
			} 		
		} catch (NumberFormatException e) {
			validSpeed = false;
		}
		return validSpeed;
	}
}