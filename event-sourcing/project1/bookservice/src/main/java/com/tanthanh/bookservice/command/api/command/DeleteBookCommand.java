package com.tanthanh.bookservice.command.api.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class DeleteBookCommand {
    @TargetAggregateIdentifier
    private String bookId;


    public DeleteBookCommand(String bookId) {
        super();
        this.bookId = bookId;
    }

}
