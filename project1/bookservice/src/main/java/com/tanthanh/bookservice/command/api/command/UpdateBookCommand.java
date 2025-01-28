package com.tanthanh.bookservice.command.api.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
public class UpdateBookCommand {
    @TargetAggregateIdentifier
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;


    public UpdateBookCommand(String bookId, String name, String author, Boolean isReady) {
        super();
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.isReady = isReady;
    }

}
