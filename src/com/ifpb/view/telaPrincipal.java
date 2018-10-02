package com.ifpb.view;

import com.ifpb.model.Funcionario;

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

    public telaPrincipal(Funcionario func) {
        setContentPane(contentPane);
        setTitle("Tela Principal");
//        getRootPane().setDefaultButton(buttonOK);

        cardápioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerenciaMenu cardapio = new gerenciaMenu();
                cardapio.pack();
                cardapio.setVisible(true);
                dispose();
            }
        });

        minhaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarFuncionario editor = new editarFuncionario(func);
                editor.pack();
                editor.setVisible(true);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin bkTela = new telaLogin();
                bkTela.pack();
                bkTela.setVisible(true);
                dispose();
            }
        });

    }
}
