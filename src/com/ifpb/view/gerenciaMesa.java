package com.ifpb.view;

import com.ifpb.model.Comanda;

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

    public gerenciaMesa() {
        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        encerrarComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Comanda encerrada com sucesso. Total: ");
            }
        });

        novaComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda c = new Comanda();
//                c.create();
                JOptionPane.showConfirmDialog(null, "Comanda criada com sucesso para a mesa .");
            }
        });
    }
}
