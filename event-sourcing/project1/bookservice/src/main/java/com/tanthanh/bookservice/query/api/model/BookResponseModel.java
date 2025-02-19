package com.tanthanh.bookservice.query.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookResponseModel {
	private String bookId;
	private String name;
	private String author;
	private Boolean isReady;

}
