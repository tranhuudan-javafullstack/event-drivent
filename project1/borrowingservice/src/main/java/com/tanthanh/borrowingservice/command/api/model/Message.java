package com.tanthanh.borrowingservice.command.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
	private String employeeId;
	private String message;
	public Message(String employeeId, String message) {
		super();
		this.employeeId = employeeId;
		this.message = message;
	}

    @Override
	public String toString() {
		return "Message [employeeId=" + employeeId + ", message=" + message + "]";
	}
	
	
}
