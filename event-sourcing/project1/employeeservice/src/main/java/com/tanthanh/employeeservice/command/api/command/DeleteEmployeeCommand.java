package com.tanthanh.employeeservice.command.api.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class DeleteEmployeeCommand {
	@TargetAggregateIdentifier
	private String employeeId;

    public DeleteEmployeeCommand(String employeeId) {
		super();
		this.employeeId = employeeId;
	}
	
	
}
