package com.company;

import javax.swing.*;
import java.io.IOException;

public class GymGUI {

    public static String getInput() {

            String nameId = JOptionPane.showInputDialog("Namn eller personnummer");
            return nameId.trim().toLowerCase();
    }

    public static void processMember(Customer c) throws IOException {
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Tyvärr finns ingen sådan medlem.");
        }
        if (c.isCurrentMember()) {
            IOUtil.writeMemberToFile(c);
            JOptionPane.showMessageDialog(null, "Välkommen " + c.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Tyvärr har " + c.getName() + "s medlemskap gått ut");
        }
    }
}
