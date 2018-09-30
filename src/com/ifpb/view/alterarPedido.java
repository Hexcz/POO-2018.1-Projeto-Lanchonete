package com.ifpb.view;

import javax.swing.*;

public class alterarPedido extends JFrame {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JButton modificarButton;
    private JButton excluirButton;
    private JSpinner spinner1;
    private JButton buttonOK;

    public alterarPedido() {
        setContentPane(contentPane);
        setTitle("Fazer pedido");
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        alterarPedido dialog = new alterarPedido();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
