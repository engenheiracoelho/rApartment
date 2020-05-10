package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "commonArea")
public class CommonArea {

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

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

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
