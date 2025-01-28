package com.tanthanh.borrowingservice.command.api.command;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class UpdateBookReturnCommand {
	@TargetAggregateIdentifier
	private String id;
	private String bookId;
	private String employee;
	private Date returnDate;

    public UpdateBookReturnCommand(String id, String bookId, String employee, Date returnDate) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.employee = employee;
		this.returnDate = returnDate;
	}
	
	
	
	
	
	
}
