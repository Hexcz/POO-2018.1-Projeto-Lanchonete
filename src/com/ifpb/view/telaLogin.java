package com.ifpb.view;

import com.ifpb.control.FuncionarioDao;
import com.ifpb.control.FuncionarioImpDao;
import com.ifpb.model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class telaLogin extends JFrame {
    private JPanel contentPane;
    private JButton criarNovaContaButton;
    private JTextField username;
    private JPasswordField password;
    private JLabel usuario;
    private JLabel senha;
    private JPanel panelMain;
    private JButton autenticarButton;
    private JLabel Logo;
    private FuncionarioDao userDao;

    public telaLogin() {

        try{
            userDao = new FuncionarioImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        setTitle("Tela Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        autenticarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                String passwd = new String(password.getPassword());
                Funcionario func = null;

                try{
                    func = userDao.buscarPorUsername(user);
                }catch(IOException|ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                }

                if(func!=null){
                    if(func.verifyLogin(user,passwd)){
                        telaPrincipal menuOpcoes = new telaPrincipal(func);
                        menuOpcoes.pack();
                        menuOpcoes.setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Senha incorreta.", "Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Usuário não cadastrado.", "Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        criarNovaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCriarNovaConta();
            }
        });
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
    }

    private void createUIComponents() {
        ImageIcon logo = new ImageIcon("logo.png");
        Logo = new JLabel(logo);
    }
}
