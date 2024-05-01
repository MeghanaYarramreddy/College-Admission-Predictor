package com.caps.entity;

public class Branches {

	private String name;
	private double cutOff;
	public Branches() {
	}
	public Branches(String name, double cutOff) {
		super();
		this.name = name;
		this.cutOff = cutOff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCutOff() {
		return cutOff;
	}
	public void setCutOff(double cutOff) {
		this.cutOff = cutOff;
	}
	@Override
	public String toString() {
		return "Branches [name=" + name + ", cutOff=" + cutOff + "]";
	}
	
}
