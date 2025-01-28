package com.tanthanh.bookservice.command.api.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Book {
	@Id
	private String bookId;
	private String name;
	private String author;
	private Boolean isReady;


}
