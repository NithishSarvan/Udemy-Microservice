package com.nithi.accounts.repository;

import com.nithi.accounts.entity.Accounts;
import com.nithi.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {



}
