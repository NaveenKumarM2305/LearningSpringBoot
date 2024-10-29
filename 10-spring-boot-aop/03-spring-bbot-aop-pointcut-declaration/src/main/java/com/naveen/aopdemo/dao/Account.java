package com.naveen.aopdemo.dao;

public class Account {
    private String name;
    private long accno;

   public Account(){

    }
    public Account(String name, long accno) {
        this.name = name;
        this.accno = accno;
    }

    public long getAccno() {
        return accno;
    }

    public void setAccno(long accno) {
        this.accno = accno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
