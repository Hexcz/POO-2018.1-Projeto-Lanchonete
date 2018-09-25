package com.ifpb.view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class GerenciaMenu extends JFrame {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton buscarButton;
    private JTextField textField2;
    private JTextArea textArea1;
    private JFormattedTextField formattedTextField1;
    private JButton salvarButton;
    private JButton excluirButton;
    private JButton editarButton;
    private JButton buttonOK;

    public GerenciaMenu() {
        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        GerenciaMenu dialog = new GerenciaMenu();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        MaskFormatter formatterPreco = null;

        try{
            formatterPreco = new MaskFormatter("R$");
        }catch(ParseException ex){
            System.out.println(ex.getMessage());
        }
        formattedTextField1 = new JFormattedTextField();
        if(formatterPreco != null){
            formatterPreco.install(formattedTextField1);
        }
    }
}
