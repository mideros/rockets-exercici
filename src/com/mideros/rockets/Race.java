package com.mideros.rockets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {

	Thruster thruster = new Thruster("Thruster1", 30, 0);
	ExecutorService exec = Executors.newCachedThreadPool();
	SpeedUp speedUp = new SpeedUp(this);
	Brake brake = new Brake(this);

	public Race() {
		exec.execute(speedUp);
		exec.execute(brake);
	}

	public static void main(String[] args) {
		new Race();
	}
}