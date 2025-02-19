package com.tanthanh.borrowingservice.query.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BorrowingResponseModel {
	private String id;
	private String bookId;
	private String employeeId;
	private Date borrowingDate;
	private Date returnDate;
	private String nameBook;
	private String nameEmployee;


}
