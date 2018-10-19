package com.company;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GymMembers gym = new GymMembers();
        gym.populateMembers(IOUtil.getMembersFromFile(IOUtil.pathToCustomers));

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
