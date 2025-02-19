package com.tanthanh.borrowingservice.command.api.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "borrowing")

public class Borrowing {
	@Id
	private String id;
	
	private String bookId;

	private String employeeId;
	private Date borrowingDate;
	private Date returnDate;


}
