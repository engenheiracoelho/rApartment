package com.example.demo.dto;

import com.example.demo.model.CommonArea;
import com.example.demo.model.User;

import java.util.Date;

public class BookingDTO {

	private Date date;
	private String status;
	private User user;
	private CommonArea commonArea;

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
