package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void isCurrentMember() {

        Customer c1 = new Customer("0000000000","Foo Bar", 20171014); //TODO: Ändra till dynamiskt lastPayment
        Customer c2 = new Customer("0000000000","Foo Bar", 20171016);
        Customer c3 = new Customer("0000000000","Foo Bar", 20161016);
        Customer c4 = new Customer("0000000000","Foo Bar", 20171103);
        assertFalse(c1.isCurrentMember());
        assertTrue(c2.isCurrentMember());
        assertFalse(c3.isCurrentMember());
        assertTrue(c4.isCurrentMember());
    }

    //TODO: WrongDateException?
//    @Test(expected = WrongDateException.class)
//    public void isCurrentMemberExceptionTest() throws WrongDateException {
//
//        Customer c4 = new Customer(0000000000,"Foo Bar", 191016);
//        c4.isCurrentMember();
//    }

}