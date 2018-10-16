package com.company;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class IOUtil {

    public static final Path pathToHasVisited = FileSystems.getDefault().getPath("src/com/company/hasvisited.txt"); //TODO: Migrera till main



    public IOUtil() {

    }


    public static ArrayList getMembersFromFile(Path path) throws IOException {
        Scanner sc = new Scanner(path);
        ArrayList<Customer> members = new ArrayList<>();
        while (sc.hasNext()) {
            String customerInfo = sc.nextLine();
            String paymentInfo = sc.nextLine();
            String[] customerArray = customerInfo.split(", ");
            members.add(new Customer(customerArray[0], customerArray[1],Integer.parseInt(paymentInfo.trim().replaceAll("-", ""))));
        }

        return members;
    }

    public static void writeMemberToFile(Customer member) throws IOException {
        if (!Files.isReadable(pathToHasVisited)) {
            Files.createFile(pathToHasVisited);
        }
        String visitingMember = member.name + " " + member.IdNumber + " " + IOUtil.getDate() + "\n";
        byte[] bytes = visitingMember.getBytes();
        Files.write(pathToHasVisited, bytes, StandardOpenOption.APPEND);

    }

    protected static int getDate() {
        return Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

}
