package com.eazybytes.accounts.controller.implementation;

import com.eazybytes.accounts.constants.BusinessConstants;
import com.eazybytes.accounts.controller.interfaces.IAccountsController;
import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.mappers.interfaces.IAccountsMapper;
import com.eazybytes.accounts.mappers.interfaces.ICustomerMapper;
import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Response;
import com.eazybytes.accounts.service.interfaces.IAccountsApplicationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@AllArgsConstructor
public class AccountsController implements IAccountsController
{
    ICustomerMapper customerMapper;

    IAccountsMapper accountsMapper;

    IAccountsApplicationService accountsApplicationService;

    @Override
    public ResponseEntity<Response> createAccount(Customer customer)
    {
        CustomerInfo customerInfo = customerMapper.mapToCustomerInfo(customer);
        AccountsInfo accountsInfo = accountsMapper.mapToAccountsInfo(customer);
        accountsApplicationService.createAccount(customerInfo, accountsInfo);
        Response response = getResponse(BusinessConstants.CREATED_STATUS_CODE,
                BusinessConstants.CREATED_STATUS_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Customer> getAccount(String mobileNumber)
    {
        CustomerInfo customerInfo = accountsApplicationService.getCustomer(mobileNumber);
        AccountsInfo accountsInfo = accountsApplicationService.getAccount(customerInfo.getCustomerId(), mobileNumber);
        Customer customer = customerMapper.mapToCustomer(customerInfo, accountsInfo);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateAccount(Customer customer)
    {
        CustomerInfo customerInfo = customerMapper.mapToCustomerInfo(customer);
        AccountsInfo accountsInfo = accountsMapper.mapToAccountsInfo(customer);
        accountsApplicationService.updateAccount(customerInfo, accountsInfo);
        Response response = getResponse(BusinessConstants.OK_STATUS_CODE, BusinessConstants.OK_STATUS_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> deleteAccount(String mobileNumber)
    {
        accountsApplicationService.deleteAccount(mobileNumber);
        Response response = getResponse(BusinessConstants.OK_STATUS_CODE, BusinessConstants.OK_STATUS_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private static Response getResponse(String statusCode, String statusMessage)
    {
        Response response = new Response();
        response.setStatusCode(statusCode);
        response.setStatusMessage(statusMessage);
        return response;
    }
}
