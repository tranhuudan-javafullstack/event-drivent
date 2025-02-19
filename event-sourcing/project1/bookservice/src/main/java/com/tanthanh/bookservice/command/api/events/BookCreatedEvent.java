package com.tanthanh.bookservice.command.api.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookCreatedEvent {

	private String bookId;
	private String name;
	private String author;
	private Boolean isReady;

}
