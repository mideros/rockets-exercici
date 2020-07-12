package com.mideros.fase3;

import java.util.Scanner;
/* FASE 3:
 * Per la fase 3 modificarem els propulsors afegint també una potencia actual. Un propulsor tindrà una potència màxima (no la pot superar) 
 * i una potencia actual (la potencia que té el propulsor en aquell moment). Tots els propulsors tindran una potència actual que començarà amb 0.
 * El coet tindrà dos mètodes, accelerar o frenar. Aquests mètodes indicaran la potència objectiu de cada propulsor, tingues en compte que 
 * cada propulsor ha de saber si ha d'augmentar o baixar d'un en un la seva potencia i de forma independent (threads!).
 * Com a resultat hauries de veure per pantalla cada propulsor amb el fil adequat pujant o baixant la potencia segons hagis indicat a l'ordre d'accelerar o frenar*/

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);
		RocketService service = new RocketService();
		DataValidation validObj = new DataValidation();
		Rocket rocket1 = new Rocket();
		Thruster thruster = new Thruster();
		Rocket rocket2 = new Rocket();		
		SpeedUpRocket sp;

		int choice = 0;
		String option = "";
		boolean selected = false;
		String objPower = "";
		int objPowerRocket = 0;		
	

		while (!selected) {
			System.out.println(" ");
			showOptions();
			option = lector.nextLine();
			if (!validObj.emptyData(option)) {
				if (validObj.tryNumber(option)) {
					choice = Integer.parseInt(option);
					if (choice >= 1 && choice <= 2) {
						switch (choice) {
						case 1:
							rocket1 = service.createRocket1();
							System.out.println(
									"Please, write what is the final power you want to reach between 10,30,80: ");
							objPower = lector.nextLine();
							if (!validObj.emptyData(objPower)) {
								if ((validObj.validateSpeedR1(objPower, rocket1))) {
									objPowerRocket = Integer.parseInt(objPower);
									thruster = service.generateThuster(rocket1, objPowerRocket);
									if (validObj.validateMaxPowerThruster(rocket1, objPowerRocket)) {	
										System.out.println("Speed up, the rocket 1");
									   // sp=new SpeedUpRocket(rocket1,thruster, objPowerRocket);
										sp=new SpeedUpRocket(thruster, objPowerRocket);
										sp.start();	
																	  
									} else {
										System.out.println("Please try again, wrong thruster for this power");
										selected = false;
									}
								} else {
									System.out.println("Please try again, wrong starting speed");
									selected = false;
								}
							} else {
								System.out.println("Please try again, wrong starting speed");
								selected = false;
							}
							break;
						case 2:							
							rocket2 = service.createRocket2();
							System.out.println(
									"Please, write what is the final power you want to reach between 10,30,40,50: ");
							objPower = lector.nextLine();
							if (!validObj.emptyData(objPower)) {
								if ((validObj.validateSpeedR2(objPower, rocket2))) {
									objPowerRocket = Integer.parseInt(objPower);
									thruster = service.generateThuster(rocket2, objPowerRocket);
									if (validObj.validateMaxPowerThruster(rocket2, objPowerRocket)) {
										//sp=new SpeedUpRocket(rocket2,thruster, objPowerRocket);
										sp=new SpeedUpRocket(thruster, objPowerRocket);
										System.out.println("Speed up, the rocket 2");
										sp.start();	
									} else {
										System.out.println("Please try again, wrong thruster for this power");
										selected = false;
									}
								} else {
									System.out.println("Please try again, wrong starting speed");
									selected = false;
								}
							} else {
								System.out.println("Please try again, wrong starting speed");
								selected = false;
							}

							break;				 

						default:
							System.out.println("Type a valid option 1 or 2. ");
						}
					} else {
						System.out.println("Write a valid option 1 or 2.");
						selected = false;
					}
				} else {
					System.out.println("Write a valid option 1 or 2.");
					selected = false;
				}
			} else {
				System.out.println("Write a valid option 1 or 2.");
				selected = false;
			}
		}
		lector.close();
	}

	public static void showOptions() {

		System.out.println("-----SpeedUp or SlowDown----");
		System.out.println("1.Rocket1 32WESSDS");
		System.out.println("2.Rocket2 LDSFJA32");
		System.out.println("Please write 1 or 2, select a rocket: ");

	}
}