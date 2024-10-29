package com.naveen.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{


    @Override
    public void addAccount(Account myAccount,boolean vipFlag) {
        System.out.println(getClass()+" Adding Account by execution addAccont()");
    }
}
