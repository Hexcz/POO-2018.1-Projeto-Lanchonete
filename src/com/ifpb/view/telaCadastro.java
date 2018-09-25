package com.ifpb.view;

import com.ifpb.model.Setor;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class telaCadastro extends JFrame {
    private JPanel contentPane;
    private JFormattedTextField cpf;
    private JTextField textField1;
    private JTextField textField2;
    private JFormattedTextField datanasc;
    private JFormattedTextField numTel;
    private JComboBox comboBox1;
    private JButton salvarButton;
    private JButton buttonOK;

    public telaCadastro() {
        setContentPane(contentPane);
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        cpf = new JFormattedTextField();
        datanasc = new JFormattedTextField();
        numTel = new JFormattedTextField();
        if(formatterCPF != null && formatterData != null && formatterTel!=null){
            formatterCPF.install(cpf);
            formatterData.install(datanasc);
            formatterTel.install(numTel);
        }

        comboBox1 = new JComboBox(Setor.values());
    }
}
