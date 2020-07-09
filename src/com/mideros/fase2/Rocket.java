package com.mideros.fase2;

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
}