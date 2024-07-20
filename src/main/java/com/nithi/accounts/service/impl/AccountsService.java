package com.nithi.accounts.service.impl;

import com.nithi.accounts.constants.AccountsConstants;
import com.nithi.accounts.dto.CustomerDto;
import com.nithi.accounts.entity.Accounts;
import com.nithi.accounts.entity.Customer;
import com.nithi.accounts.exception.CustomerAlreadyExistException;
import com.nithi.accounts.mapper.CustomerMapper;
import com.nithi.accounts.repository.AccountsRepository;
import com.nithi.accounts.repository.CustomerRepository;
import com.nithi.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service

@AllArgsConstructor
public class AccountsService implements IAccountsService {

    AccountsRepository accountsRepository;
    CustomerRepository customerRepository;

    @Override
    public void createAccounts(CustomerDto customerDto) {

        Customer newCustomer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> byMobileNumber = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if (byMobileNumber.isPresent()){
            throw new CustomerAlreadyExistException("Customer has mobilenumber " + customerDto.getMobileNumber());

        }
        Customer saveCustomer = customerRepository.save(newCustomer);
        accountsRepository.save(createAccount(saveCustomer));


    }

    private Accounts createAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }


}
