package com.cirbal.portfel.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="messageResponse")
public class MessageResponse {

	private String message;

	public MessageResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
