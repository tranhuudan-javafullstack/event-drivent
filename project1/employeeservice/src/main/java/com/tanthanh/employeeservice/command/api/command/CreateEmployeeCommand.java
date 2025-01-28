package com.tanthanh.employeeservice.command.api.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class CreateEmployeeCommand {

	@TargetAggregateIdentifier
	private String employeeId;
	private String firstName;
	private String lastName;
	private String kin;
	private Boolean isDisciplined;
	
	
	
	public CreateEmployeeCommand(String employeeId, String firstName, String lastName, String kin,
			Boolean isDisciplined) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.kin = kin;
		this.isDisciplined = isDisciplined;
	}


}
