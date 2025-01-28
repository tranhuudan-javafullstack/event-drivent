package com.tanthanh.borrowingservice.command.api.events;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BorrowCreatedEvent {
	private String id;
	private String bookId;
	private String employeeId;
	private Date borrowingDate;


}
