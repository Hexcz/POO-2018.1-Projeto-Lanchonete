package com.ifpb.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton cozinhaButton;
    private JButton gerenciaButton;
    private JButton cardápioButton;
    private JButton mesasButton;
    private JButton minhaContaButton;
    private JButton sairButton;
    private JPanel logoImagem;
    private JButton buttonOK;

    public telaPrincipal() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        cardápioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciaMenu cardapio = new GerenciaMenu();
                cardapio.pack();
                cardapio.setVisible(true);
                dispose();
            }
        });


    }

    public static void main(String[] args) {
        telaPrincipal dialog = new telaPrincipal();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
