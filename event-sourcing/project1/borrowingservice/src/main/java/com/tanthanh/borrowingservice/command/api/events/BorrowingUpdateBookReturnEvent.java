package com.tanthanh.borrowingservice.command.api.events;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BorrowingUpdateBookReturnEvent {

	private String id;
	private String bookId;
	private String employee;
	private Date returnDate;

}
