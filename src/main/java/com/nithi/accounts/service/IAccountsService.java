package com.nithi.accounts.service;

import com.nithi.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * @param customerDto
     */
    void createAccounts(CustomerDto customerDto);
}
