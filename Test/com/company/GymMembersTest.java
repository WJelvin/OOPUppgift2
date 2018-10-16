package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GymMembersTest {

    @Test
    public void getMemberByNameOrId() {
        GymMembers gym = new GymMembers();
        Customer c1 = new Customer("0123456789","Bobo bob", 20131511);
        Customer c2 = new Customer("0000000000","Foo Bar", 20161016);
        Customer c3 = new Customer("1111111111","William Jelvin", 20171103);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        gym.populateMembers(customers);
        Customer case1 = gym.getMemberByNameOrId("0000000000");
        Customer case2 = gym.getMemberByNameOrId("William Jelvin");

        assertEquals(c2, case1);
        assertEquals(c3, case2);

    }
}