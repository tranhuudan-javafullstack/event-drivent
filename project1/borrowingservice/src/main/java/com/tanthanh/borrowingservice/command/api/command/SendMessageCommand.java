package com.tanthanh.borrowingservice.command.api.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class SendMessageCommand {
	@TargetAggregateIdentifier
	private String id;
	
	private String employeeId;
	private String message;
	public SendMessageCommand(String id, String employeeId, String message) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.message = message;
	}


}
