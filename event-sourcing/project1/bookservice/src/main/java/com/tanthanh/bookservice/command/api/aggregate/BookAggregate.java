package com.tanthanh.bookservice.command.api.aggregate;

import com.tanthanh.bookservice.command.api.command.CreateBookCommand;
import com.tanthanh.bookservice.command.api.command.DeleteBookCommand;
import com.tanthanh.bookservice.command.api.command.UpdateBookCommand;
import com.tanthanh.bookservice.command.api.events.BookCreatedEvent;
import com.tanthanh.bookservice.command.api.events.BookDeletedEvent;
import com.tanthanh.bookservice.command.api.events.BookUpdatedEvent;
import com.tanthanh.commonservice.command.RollBackStatusBookCommand;
import com.tanthanh.commonservice.command.UpdateStatusBookCommand;
import com.tanthanh.commonservice.events.BookRollBackStatusEvent;
import com.tanthanh.commonservice.events.BookUpdateStatusEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class BookAggregate {

    @AggregateIdentifier
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;

    public BookAggregate() {
    }

    @CommandHandler
    public BookAggregate(CreateBookCommand createBookCommand) {

        BookCreatedEvent bookCreatedEvent
                = new BookCreatedEvent();
        BeanUtils.copyProperties(createBookCommand,
                bookCreatedEvent);
        AggregateLifecycle.apply(bookCreatedEvent);
    }

    @CommandHandler
    public void handle(UpdateBookCommand updateBookCommand) {
        BookUpdatedEvent event
                = new BookUpdatedEvent();
        BeanUtils.copyProperties(updateBookCommand,
                event);

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteBookCommand deleteBookCommand) {
        BookDeletedEvent event
                = new BookDeletedEvent();
        BeanUtils.copyProperties(deleteBookCommand,
                event);

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateStatusBookCommand command) {
        BookUpdateStatusEvent event = new BookUpdateStatusEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(RollBackStatusBookCommand command) {
        BookRollBackStatusEvent event = new BookRollBackStatusEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BookUpdateStatusEvent event) {
        this.bookId = event.getBookId();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void on(BookRollBackStatusEvent event) {
        this.bookId = event.getBookId();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void on(BookCreatedEvent event) {
        this.bookId = event.getBookId();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
        this.name = event.getName();
    }

    @EventSourcingHandler
    public void on(BookUpdatedEvent event) {
        this.bookId = event.getBookId();
        this.author = event.getAuthor();
        this.name = event.getName();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void on(BookDeletedEvent event) {
        this.bookId = event.getBookId();
    }

}
