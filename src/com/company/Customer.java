package com.company;

public class Customer {

    private String IdNumber;
    private String name;
    private int lastPayment;
    private boolean CurrentMember = isCurrentMember();

    public Customer(String idNumber, String name, int lastPayment) {
        this.IdNumber = idNumber;
        this.name = name;
        this.lastPayment = lastPayment;
    }

    public boolean isCurrentMember() {
        return (IOUtil.getDate() - lastPayment) <= 10000;
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
