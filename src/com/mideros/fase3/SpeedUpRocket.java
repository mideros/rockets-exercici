package com.mideros.fase3;

//import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This this class implements Runnable to generate threads one to speed up the
 * thrusters.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * 
 */

public class SpeedUpRocket extends Thread{//implements Runnable {

	private int objPower;
	private Thruster thruster;
	private BrakeRocket bp=new BrakeRocket();
//	private Rocket rocket;
//	private Scanner lectorUp = new Scanner(System.in);
//	private DataValidation validObj = new DataValidation();
//	private String objBrake = "";
	int objBrakeRocket = 5;
	boolean go = false;
	

/*	public SpeedUpRocket(Rocket rocket,Thruster thruster, int objPower) {
		this.objPower = objPower;
		this.thruster = thruster;	
		this.rocket=rocket;
	}*/
	
	public SpeedUpRocket(Thruster thruster, int objPower) {
		this.objPower = objPower;
		this.thruster = thruster;	
	}

	@Override
	public void run() {

		try {		
			thruster.speedUpThruster(objPower);
			TimeUnit.MILLISECONDS.sleep(50);
			System.out.println("Ending Speed up");
			System.out.println("");
			System.out.println("Starts braking the propeller ");
			
			/*while (!go) {
				System.out.println("Please, write the brake power: ");
				objBrake = lectorUp.nextLine();
				if (!validObj.emptyData(objBrake)) {
					if ((validObj.validateSpeedR1(objBrake, rocket))) {
						objBrakeRocket = Integer.parseInt(objBrake);	*/												
						 bp=new BrakeRocket(thruster,objBrakeRocket);						 
					/*	go = true;
					} else {
						System.out.println("Please try again, wrong starting speed");
						go = false;
					}
				} else {
					System.out.println("Please try again, wrong brake power");
					go = false;
				}
			}*/
			System.out.println("The " + thruster.getThrusterName() + " brake race");
			bp.start();
		
		} catch (InterruptedException e) {
			System.out.println("SpeedUp interrupt");
		}
		//lectorUp.close();
	}
}