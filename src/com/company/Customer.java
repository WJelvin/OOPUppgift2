package com.company;


public class Customer {

    protected String IdNumber;
    protected String name;
    protected int lastPayment;
    protected boolean CurrentMember = isCurrentMember();

    public Customer(String idNumber, String name, int lastPayment) {
        this.IdNumber = idNumber;
        this.name = name;
        this.lastPayment = lastPayment;
    }

    public int getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(int lastPayment) {
        this.lastPayment = lastPayment;
    }

    protected boolean isCurrentMember() {
        if ((IOUtil.getDate() - lastPayment) <= 10000) {
            return true;
        } else {
            return false;
        }
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.IdNumber + " " + this.lastPayment + ", Is member: " + isCurrentMember();
    }

}
