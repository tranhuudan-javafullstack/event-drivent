package com.tanthanh.borrowingservice.command.api.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class DeleteBorrowCommand {
	@TargetAggregateIdentifier
	private String id;

	
	
	public DeleteBorrowCommand(String id) {
		super();
		this.id = id;
	}


}
