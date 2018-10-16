package com.company;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        final Path pathToCustomers = FileSystems.getDefault().getPath("src/com/company/customers.txt");
        final Path pathToHasVisited = FileSystems.getDefault().getPath("src/com/company/hasvisited.txt");

        GymMembers gym = new GymMembers();

        gym.populateMembers(IOUtil.getMembersFromFile(pathToCustomers));
        String nameId = "";
        while (nameId != null) {
            nameId = GymGUI.getInput();
            if (nameId == null) {
                System.exit(0);
            }
            try {
                GymGUI.processMember(gym.getMemberByNameOrId(nameId));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Gick inte att skriva till hasvisited.txt");
                System.exit(1);
            }
        }

    }
}
