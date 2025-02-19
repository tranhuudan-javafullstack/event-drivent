package com.tanthanh.borrowingservice.query.api.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanthanh.borrowingservice.query.api.model.BorrowingResponseModel;
import com.tanthanh.borrowingservice.query.api.queries.GetAllBorrowing;
import com.tanthanh.borrowingservice.query.api.queries.GetListBorrowingByEmployeeQuery;

@RestController
@RequestMapping("/api/v1/borrowing")
public class BorrowingQueryController {

	private final QueryGateway queryGateway;

    public BorrowingQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{employeeId}")
	public List<BorrowingResponseModel> getBorrowingByEmployee(@PathVariable String employeeId){
		GetListBorrowingByEmployeeQuery getBorrowingQuery = new GetListBorrowingByEmployeeQuery();
		getBorrowingQuery.setEmployeeId(employeeId);

        return queryGateway.query(getBorrowingQuery, ResponseTypes.multipleInstancesOf(BorrowingResponseModel.class))
        .join();
	}
	@GetMapping
	public List<BorrowingResponseModel> getAllBorrowing(){
        return queryGateway.query(new GetAllBorrowing(), ResponseTypes.multipleInstancesOf(BorrowingResponseModel.class))
                .join();
	}
}
