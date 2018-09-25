package com.ifpb.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gerenciaMesa extends JFrame {
    private JPanel contentPane;
    private JSpinner spinner1;
    private JButton novaComandaButton;
    private JButton verPedidosButton;
    private JButton fazerPedidoButton;
    private JButton encerrarComandaButton;
    private JButton buttonOK;

    public gerenciaMesa() {
        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);

        encerrarComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Comanda encerrada com sucesso. Total: ");
            }
        });

        novaComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Comanda criada com sucesso para a mesa .");
            }
        });
    }

    public static void main(String[] args) {
        gerenciaMesa dialog = new gerenciaMesa();
        dialog.pack();
        dialog.setVisible(true);
    }
}
