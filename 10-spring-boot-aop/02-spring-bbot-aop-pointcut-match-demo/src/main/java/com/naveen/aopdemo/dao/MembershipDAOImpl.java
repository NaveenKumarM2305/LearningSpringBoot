package com.naveen.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements  MembershipDAO{


    @Override
    public boolean addFunnyMember() {
        System.out.println(getClass()+" Adding Fun Membership Account by execution of addFunnyMember()");
        return true;
    }
}
