package com.example.demo.dto;

import com.example.demo.model.ExtraCost;

import javax.persistence.*;

public class CommonAreaDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@OneToOne
	@JoinColumn(name = "extraCostId", referencedColumnName = "id")
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
