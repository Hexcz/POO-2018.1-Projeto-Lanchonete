package com.ifpb.view;

import javax.swing.*;

public class gerenciaComandasData extends JDialog {
    private JPanel contentPane;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JTable table1;
    private JButton buttonOK;

    public gerenciaComandasData() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        gerenciaComandasData dialog = new gerenciaComandasData();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
