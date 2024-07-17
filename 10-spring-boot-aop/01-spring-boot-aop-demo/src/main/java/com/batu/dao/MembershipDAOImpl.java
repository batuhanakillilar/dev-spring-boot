package com.batu.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addMemberAccount() {

        System.out.println(getClass() +" Doing db work, adding a membership account");

    }
}
