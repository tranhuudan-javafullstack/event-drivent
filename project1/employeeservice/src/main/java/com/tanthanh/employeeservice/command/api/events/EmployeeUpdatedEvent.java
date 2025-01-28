package com.tanthanh.employeeservice.command.api.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeUpdatedEvent {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String kin;
	private Boolean isDisciplined;

}
