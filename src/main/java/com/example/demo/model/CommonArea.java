package com.example.demo.model;

public class CommonArea {

	private String name;
	private String location;
	private ExtraCost extraCost;

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getLocation () {
		return location;
	}

	public void setLocation (String location) {
		this.location = location;
	}

	public ExtraCost getExtraCost () {
		return extraCost;
	}

	public void setExtraCost (ExtraCost extraCost) {
		this.extraCost = extraCost;
	}
}
