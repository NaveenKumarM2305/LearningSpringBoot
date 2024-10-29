package com.naveen.aopdemo.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    public List<Account> findAccouts() {
        List<Account> accounts = new ArrayList<>();
        Account acc1 = new Account("abc",23423);
        Account acc2 = new Account("def",98783);
        Account acc3 = new Account("slkj",23432);
        Account acc4 = new Account("xyz",32131);
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc4);


        return accounts;
    }

    @Override
    public void addAccount(Account myAccount,boolean vipFlag) {
        System.out.println(getClass()+" Adding Account by execution addAccont()");
    }


}
