package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "extraCost")
public class ExtraCost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "value")
	private Long value;

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

	public Long getValue () {
		return value;
	}

	public void setValue (Long value) {
		this.value = value;
	}
}
