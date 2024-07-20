package com.nithi.accounts.controller;


import com.nithi.accounts.constants.AccountsConstants;
import com.nithi.accounts.dto.CustomerDto;
import com.nithi.accounts.dto.ResponseDto;
import com.nithi.accounts.service.impl.AccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {


    AccountsService accountsService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDto customerDto){

        accountsService.createAccounts(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
    }
}
