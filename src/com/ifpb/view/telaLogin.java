package com.ifpb.view;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaLogin extends JFrame {
    private JPanel contentPane;
    private JButton criarNovaContaButton;
    private JTextField username;
    private JPasswordField password;
    private JLabel usuario;
    private JLabel senha;
    private JPanel panelMain;
    private JButton autenticarButton;

    public telaLogin() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(autenticarButton);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        autenticarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAutenticar();
            }
        });

        criarNovaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCriarNovaConta();
            }
        });
    }

    private void onAutenticar(){
        JOptionPane.showMessageDialog(null, "Autenticado com sucesso");
        dispose();
    }

    private void onCriarNovaConta(){
        telaCadastro cadastro = new telaCadastro();
        cadastro.pack();
        cadastro.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        telaLogin dialog = new telaLogin();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
