package com.company;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class IOUtilTest {

    @Test
    public void getMembersFromFile() throws IOException {
        ArrayList<Customer> testArrayList;
        testArrayList = IOUtil.getMembersFromFile(IOUtil.pathToCustomers);
        assertThat(testArrayList.get(0), is(instanceOf(Customer.class)));
    }

    @Test
    public void writeMemberToFile() throws IOException {
        Customer member = new Customer("0000000000", "Foo bar", 20180712);
        IOUtil.writeMemberToFile(member);
        Scanner sc = new Scanner(IOUtil.pathToHasVisited);
        String memberInfo = sc.nextLine();
        assertTrue(memberInfo.contains(member.getIdNumber()) && memberInfo.contains(member.getName()));
    }
}