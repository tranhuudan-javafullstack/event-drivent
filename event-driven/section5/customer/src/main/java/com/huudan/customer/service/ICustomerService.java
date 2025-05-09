package com.huudan.customer.service;

import com.huudan.common.dto.MobileNumberUpdateDto;
import com.huudan.customer.dto.CustomerDto;

public interface ICustomerService {

    /**
     * @param customerDto - CustomerDto Object
     */
    void createCustomer(CustomerDto customerDto);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchCustomer(String mobileNumber);

    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateCustomer(CustomerDto customerDto);

    /**
     * @param customerId - Input Customer ID
     * @return boolean indicating if the delete of Customer details is successful or not
     */
    boolean deleteCustomer(String customerId);

    /**
     * @param mobileNumberUpdateDto - MobileNumberUpdateDto object
     * @return boolean indicating if the update of mobile number is successful or not
     */
    boolean updateMobileNumber(MobileNumberUpdateDto mobileNumberUpdateDto);

    /**
     * @param mobileNumberUpdateDto - MobileNumberUpdateDto object
     * @return boolean indicating if the update of mobile number is successful or not
     */
    boolean rollbackMobileNumber(MobileNumberUpdateDto mobileNumberUpdateDto);
}
