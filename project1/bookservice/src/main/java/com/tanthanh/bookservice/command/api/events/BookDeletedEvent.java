package com.tanthanh.bookservice.command.api.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDeletedEvent {
	private String bookId;

}
