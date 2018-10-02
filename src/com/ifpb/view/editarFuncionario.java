package com.ifpb.view;

import com.ifpb.control.FuncionarioDao;
import com.ifpb.control.FuncionarioImpDao;
import com.ifpb.model.Funcionario;
import com.ifpb.model.Setor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

public class editarFuncionario extends JFrame {
    private JPanel contentPane;
    private Funcionario funcAtt;
    private JTextField nametfd;
    private JFormattedTextField cpffrmfd;
    private JTextField emailfd;
    private JFormattedTextField numfrmfd;
    private JFormattedTextField nascfrmfd;
    private JComboBox setorfd;
    private JPasswordField pssdfd;
    private JTextField usrfd;
    private JButton editarButton;
    private JButton cancelarButton;
    private FuncionarioDao daoEdit;

    public editarFuncionario(Funcionario funcionario) {

        try{
            daoEdit = new FuncionarioImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        setTitle("Editar funcionario");
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        nametfd.setText(funcionario.getNome());
        emailfd.setText(funcionario.getEmail());
        usrfd.setText(funcionario.getUsername());
        numfrmfd.setText(funcionario.getTelefone());
        if(nascfrmfd!=null){ nascfrmfd.setValue(funcionario.getDataNascimento().format(frmt));}
        cpffrmfd.setText(funcionario.getCpf());
        pssdfd.setText(funcionario.getSenha());
        setorfd.setSelectedItem(funcionario.getSetor());

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pswd = new String(pssdfd.getPassword());
                String nome = nametfd.getText();
                String email = emailfd.getText();
                String tel = numfrmfd.getText();
                LocalDate nas = LocalDate.parse(nascfrmfd.getText(), frmt);
                Setor set = (Setor) setorfd.getSelectedItem();
                funcAtt = new Funcionario(usrfd.getText(), pswd, cpffrmfd.getText(), nome, email, tel, nas, set);
                try {
                    System.out.println(daoEdit.getFuncionarios());
                    System.out.println(daoEdit.atualizar(funcAtt));
                }catch(ClassNotFoundException|IOException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void createUIComponents() {
        setorfd = new JComboBox(Setor.values());
    }
}
