package com.appsdeveloperblog.estore.ProductsService.command.rest;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products") // http://localhost:8080/products

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductsCommandController {

    Environment env;
    CommandGateway commandGateway;


    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString()).build();

        String returnValue;

        returnValue = commandGateway.sendAndWait(createProductCommand);

//		try {
//			returnValue = commandGateway.sendAndWait(createProductCommand);
//		} catch (Exception ex) {
//			returnValue = ex.getLocalizedMessage();
//		}

        return returnValue;
    }

//	@GetMapping
//	public String getProduct() {
//		return "HTTP GET Handled " + env.getProperty("local.server.port");
//	}
//	
//	@PutMapping
//	public String updateProduct() {
//		return "HTTP PUT Handled";
//	}
//	
//	@DeleteMapping
//	public String deleteProduct() {
//		return "HTTP DELETE handled";
//	}

}
