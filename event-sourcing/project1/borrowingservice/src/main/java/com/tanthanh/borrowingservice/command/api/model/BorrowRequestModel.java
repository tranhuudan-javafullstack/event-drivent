package com.tanthanh.borrowingservice.command.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BorrowRequestModel {
	private String id;
	private String bookId;
	private String employeeId;
	private Date borrowingDate;
	private Date returnDate;


}
