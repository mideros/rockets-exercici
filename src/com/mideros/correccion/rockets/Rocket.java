package com.mideros.correccion.rockets;

/**
 * This class creates the rocket model. It contains two main methods , one to calculate currentRocketPower  
 * and the other to maxRocketPower.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String code;
	private List<Thruster> thrusters = new ArrayList<Thruster>();

	public Rocket() {
	}

	public Rocket(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Thruster> getThrusters() {
		return thrusters;
	}

	public void setThrusters(List<Thruster> thrusters) {
		this.thrusters = thrusters;
	}

	public int currentRocketPower(List<Thruster> thrusters) {

		int maxC = 0;

		for (int i = 0; i < thrusters.size(); i++) {
			maxC += thrusters.get(i).getCurrentPower();
		}
		return maxC;
	}

	public int maxRocketPower(List<Thruster> thrusters) {

		int maxR = 0;

		for (int i = 0; i < thrusters.size(); i++) {
			maxR += thrusters.get(i).getMaxPower();
		}
		return maxR;
	}

}