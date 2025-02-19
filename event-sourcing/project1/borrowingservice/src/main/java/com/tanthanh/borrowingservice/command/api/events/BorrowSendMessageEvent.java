package com.tanthanh.borrowingservice.command.api.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BorrowSendMessageEvent {
private String id;
	
	private String employeeId;
	private String message;
	public BorrowSendMessageEvent(String id, String employeeId, String message) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.message = message;
	}
	public BorrowSendMessageEvent() {
		super();
	}

}
