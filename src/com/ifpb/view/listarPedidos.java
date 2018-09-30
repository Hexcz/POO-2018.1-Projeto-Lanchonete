package com.ifpb.view;

import javax.swing.*;

public class listarPedidos extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JButton atenderButton;

    public listarPedidos() {
        setContentPane(contentPane);
        setTitle("Pedidos");

    }

    public static void main(String[] args) {
        listarPedidos dialog = new listarPedidos();
        dialog.pack();
        dialog.setVisible(true);
    }
}
