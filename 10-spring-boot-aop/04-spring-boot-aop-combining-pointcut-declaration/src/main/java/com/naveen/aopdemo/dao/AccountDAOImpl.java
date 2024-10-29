package com.naveen.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    String name;
    int age;
    @Override
    public String getName() {
        System.out.println(getClass()+" in getName");
        return name;
    }
    @Override
    public void setName(String name) {
        System.out.println(getClass()+" in setName");
        this.name = name;
    }
    @Override
    public int getAge() {
        System.out.println(getClass()+" in getAge");
            return age;
    }
    @Override
    public void setAge(int age) {
        System.out.println(getClass()+" in setAge");
        this.age = age;
    }

    @Override
    public void addAccount(Account myAccount,boolean vipFlag) {
        System.out.println(getClass()+" Adding Account by execution addAccont()");
    }


}
