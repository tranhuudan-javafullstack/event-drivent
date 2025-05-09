package com.huudan.customer.service;

import com.huudan.customer.command.event.CustomerUpdatedEvent;
import com.huudan.customer.dto.CustomerDto;
import com.huudan.customer.entity.Customer;

public interface ICustomerService {

    /**
     * @param customerEntity - Customer Object
     */
    void createCustomer(Customer customerEntity);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchCustomer(String mobileNumber);

    /**
     * @param customerUpdatedEvent - CustomerUpdatedEvent Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateCustomer(CustomerUpdatedEvent customerUpdatedEvent);

    /**
     * @param customerId - Input Customer ID
     * @return boolean indicating if the delete of Customer details is successful or not
     */
    boolean deleteCustomer(String customerId);

    /**
     * @param oldMobileNumber - Old mobile number of Customer
     *  @param newMobileNumber - New mobile number of Customer
     * @return boolean indicating if the update of mobile number is successful or not
     */
    boolean updateMobileNumber(String oldMobileNumber, String newMobileNumber);
}
