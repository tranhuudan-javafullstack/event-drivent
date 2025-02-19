package com.tanthanh.employeeservice.command.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequestModel {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String kin;
	private Boolean isDisciplined;


}
