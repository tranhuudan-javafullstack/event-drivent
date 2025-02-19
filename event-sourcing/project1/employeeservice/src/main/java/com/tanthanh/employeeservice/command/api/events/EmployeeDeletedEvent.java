package com.tanthanh.employeeservice.command.api.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDeletedEvent {
	private String employeeId;


}
