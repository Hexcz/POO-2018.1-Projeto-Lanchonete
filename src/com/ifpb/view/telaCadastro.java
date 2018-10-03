package com.ifpb.view;

import com.ifpb.control.FuncionarioDao;
import com.ifpb.control.FuncionarioImpDao;
import com.ifpb.model.Funcionario;
import com.ifpb.model.Setor;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class telaCadastro extends JFrame {
    private JPanel contentPane;
    private JFormattedTextField cpffrmfield;
    private JTextField textField1;
    private JTextField textField2;
    private JFormattedTextField datanasc;
    private JFormattedTextField numTel;
    private JComboBox comboBox1;
    private JButton salvarButton;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JButton buttonOK;
    private FuncionarioDao daoFunc;

    public telaCadastro() {

        try{
            daoFunc = new FuncionarioImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha ao abrir o arquivo", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textField1.getText();
                String username = textField3.getText();
                String senha = new String(passwordField1.getPassword());
                Setor setor = (Setor) comboBox1.getSelectedItem();

                String cpf = cpffrmfield.getText();
                String telefone = numTel.getText();
                String email = textField2.getText();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate nascimento = LocalDate.parse(datanasc.getText(),formatter);

                Funcionario funcionario =  new Funcionario(username, senha, cpf, nome, email, telefone, nascimento, setor);

                try {
                    if (daoFunc.salvar(funcionario)) {
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário em uso.", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(IOException | ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }

                telaLogin telaLogin = new telaLogin();
                telaLogin.pack();
                telaLogin.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        telaCadastro dialog = new telaCadastro();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {

        MaskFormatter formatterCPF = null;
        MaskFormatter formatterData = null;
        MaskFormatter formatterTel = null;

        try{
            formatterCPF = new MaskFormatter("###.###.###-##");
            formatterData = new MaskFormatter("##/##/####");
            formatterTel = new MaskFormatter("(##)#####-####");
        }catch (ParseException ex){
            System.out.println(ex.getMessage());
        }

        cpffrmfield = new JFormattedTextField();
        datanasc = new JFormattedTextField();
        numTel = new JFormattedTextField();
        if(formatterCPF != null && formatterData != null && formatterTel!=null){
            formatterCPF.install(cpffrmfield);
            formatterData.install(datanasc);
            formatterTel.install(numTel);
        }

        comboBox1 = new JComboBox(Setor.values());
    }
}
