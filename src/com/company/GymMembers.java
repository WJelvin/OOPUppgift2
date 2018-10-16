package com.company;

import java.util.ArrayList;

public class GymMembers {

    protected ArrayList<Customer> members = new ArrayList<>();

    protected void populateMembers(ArrayList<Customer> members) {
        for (Customer c : members) {
            this.members.add(c);
        }
    }

    protected Customer getMemberByNameOrId(String nameId) {

        for (Customer c : this.members) {
            if (nameId.toLowerCase().equals(c.getName().toLowerCase()) || nameId.equals(c.getIdNumber()))
                return c;
        }
        return null;
    }

}
