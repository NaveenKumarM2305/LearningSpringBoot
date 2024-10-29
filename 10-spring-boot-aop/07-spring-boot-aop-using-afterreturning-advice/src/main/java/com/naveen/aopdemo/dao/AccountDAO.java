package com.naveen.aopdemo.dao;

import java.util.List;

public interface AccountDAO {
public void addAccount(Account myAccount,boolean vipFlag);
    public String getName();

    public void setName(String name);

    public int getAge() ;


    public void setAge(int age);

    List<Account> findAccouts();
}
