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
    private JLabel label1;
    private Funcionario f;

    public telaPrincipal(Funcionario func) {
        setContentPane(contentPane);
        setTitle("Tela Principal");
        f = func;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cardápioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerenciaMenu cardapio = new gerenciaMenu();
                cardapio.pack();
                cardapio.setVisible(true);
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

        mesasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cozinhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPedidos lP = new listarPedidos();
                lP.pack();
                lP.setVisible(true);
            }
        });

        gerenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    private void createUIComponents() {
        ImageIcon logo = new ImageIcon("logo.png");
        label1 = new JLabel(logo);
    }
}
