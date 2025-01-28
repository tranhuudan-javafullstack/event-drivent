package com.tanthanh.employeeservice.query.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeReponseModel {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String kin;
	private Boolean isDisciplined;

}
