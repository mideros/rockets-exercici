package com.mideros.fase2;

/*FASE 2:
 * Volem millorar el software perquè el propulsor tingui una potència màxima.
 * Modifiquem en el main anterior:
 * 1. Creem dos coets amb els codis “32WESSDS” I “ ”. El primer coet tindrà tres propulsors (potència: 10,30,80) i el 
 * segon sis propulsors (potència: 30,40,50,50,30,10).
 * 2. Mostrar a pantalla el codi dels coets, el número de propulsors que té i la potència màxima de cada propulsor.
 * Output:
 * 32WESSDS: 10,30,80
 * LDSFJA32: 30,40,50,50,30,10*/

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		RocketService service = new RocketService();

		Rocket rocket1 = service.createRocket1();
		Rocket rocket2 = service.createRocket2();

		service.updateView(rocket1);
		service.updateView(rocket2);

	}
}
