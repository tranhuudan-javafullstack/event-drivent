package com.huudan.customer.query;

import lombok.Value;

/**
 * VERB+NOUN+Query
 */
@Value
public class FindCustomerQuery {

    private final String mobileNumber;

}
