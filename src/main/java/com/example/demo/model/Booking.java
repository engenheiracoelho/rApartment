package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "status")
	private String status;

	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

	@OneToOne
	@JoinColumn(name = "commonAreaId", referencedColumnName = "id")
	private CommonArea commonArea;

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public Date getDate () {
		return date;
	}

	public void setDate (Date date) {
		this.date = date;
	}

	public String getStatus () {
		return status;
	}

	public void setStatus (String status) {
		this.status = status;
	}

	public User getUser () {
		return user;
	}

	public void setUser (User user) {
		this.user = user;
	}

	public CommonArea getCommonArea () {
		return commonArea;
	}

	public void setCommonArea (CommonArea commonArea) {
		this.commonArea = commonArea;
	}
}
