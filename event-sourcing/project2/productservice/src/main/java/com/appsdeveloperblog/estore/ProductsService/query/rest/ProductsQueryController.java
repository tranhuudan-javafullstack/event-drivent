package com.appsdeveloperblog.estore.ProductsService.query.rest;

import java.util.List;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.estore.ProductsService.query.FindProductsQuery;

@RestController
@RequestMapping("/products")

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductsQueryController {
	
	QueryGateway queryGateway;
	
	@GetMapping
	public List<ProductRestModel> getProducts() {
		
		FindProductsQuery findProductsQuery = new FindProductsQuery();
		return  queryGateway.query(findProductsQuery,
				ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
		
	}

}
