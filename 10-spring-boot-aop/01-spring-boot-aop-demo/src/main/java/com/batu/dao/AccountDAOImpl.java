package com.batu.dao;

import com.batu.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {


    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() +" Doing db work, adding account");

    }
}
