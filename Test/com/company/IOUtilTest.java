package com.company;

import org.junit.Test;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IOUtilTest {

    @Test
    public void getMembersFromFile() throws IOException {
        Path path = FileSystems.getDefault().getPath("src/com/company/customers.txt");
        ArrayList<Customer> testArrayList = new ArrayList<>();
        IOUtil.getMembersFromFile(path);
        assertThat(testArrayList.get(0), is(instanceOf(Customer.class)));
    }

    @Test
    public void writeMemberToFile() throws IOException {
        Customer member = new Customer("0000000000", "Foo bar", 20171212);
        IOUtil.writeMemberToFile(member);
        Scanner sc = new Scanner(IOUtil.pathToHasVisited);
        String memberInfo = sc.nextLine();
        assertTrue(memberInfo.contains(member.IdNumber) && memberInfo.contains(member.name));
    }
}