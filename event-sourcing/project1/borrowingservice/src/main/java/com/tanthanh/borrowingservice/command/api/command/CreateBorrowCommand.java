package com.tanthanh.borrowingservice.command.api.command;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class CreateBorrowCommand {

	
	@TargetAggregateIdentifier
	private String id;
	
	private String bookId;
	private String employeeId;
	private Date borrowingDate;
	
	

	public CreateBorrowCommand(String bookId, String employeeId, Date borrowingDate,String id) {
		super();
		this.bookId = bookId;
		this.employeeId = employeeId;
		this.borrowingDate = borrowingDate;
		this.id = id;
	}


}
