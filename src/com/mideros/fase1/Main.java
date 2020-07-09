package com.mideros.fase1;

/*FASE 1:
 * Volem fer un software de carreres de coets.
 * Un coet està identificat per un codi de 8 caràcters i un número de propulsors.
 * Realitza els següents passos:
 * 1. Creem dos coets amb els codis “x” I “LDSFJA32”. El primer coet tindrà tres propulsors i el segon sis propulsors.
 * 2. Mostrar a pantalla el codi dels coets i el número de propulsors que té.*/

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RocketService service = new RocketService();

		Rocket rocket1 = service.createRocket1();
		Rocket rocket2 = service.createRocket2();

		service.updateView(rocket1);
		service.updateView(rocket2);
	}
}