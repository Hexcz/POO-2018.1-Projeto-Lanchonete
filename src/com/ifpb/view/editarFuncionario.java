package com.ifpb.view;

import com.ifpb.control.FuncionarioDao;
import com.ifpb.control.FuncionarioImpDao;
import com.ifpb.exceptions.CampoNuloException;
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
        pack();
        setLocationRelativeTo(null);

        Funcionario funcExib = funcionario;
        nametfd.setText(funcExib.getNome());
        emailfd.setText(funcExib.getEmail());
        usrfd.setText(funcExib.getUsername());
        numfrmfd.setText(funcExib.getTelefone());
        if(nascfrmfd!=null){ nascfrmfd.setValue(funcExib.getDataNascimento().format(frmt));}
        cpffrmfd.setText(funcExib.getCpf());
        pssdfd.setText(funcExib.getSenha());
        setorfd.setSelectedItem(funcExib.getSetor());

        cpffrmfd.setEditable(false);
        nascfrmfd.setEditable(false);
        usrfd.setEditable(false);

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
                    if (daoEdit.buscarPorEmail(email)!=null && !daoEdit.buscarPorEmail(email).getEmail().equals("")){
                        if (!daoEdit.buscarPorEmail(funcExib.getEmail()).getEmail().equals(email)){
                            JOptionPane.showMessageDialog(null, "O e-mail digitado já pertence a um usuário cadastrado!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            daoEdit.atualizar(funcAtt);
                            JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
                            funcExib.setEmail(email);
                            funcExib.setTelefone(tel);
                            funcExib.setNome(nome);
                            funcExib.setSenha(pswd);
                        }
                    }
                    else{
                        daoEdit.atualizar(funcAtt);
                        JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
                        funcExib.setEmail(email);
                        funcExib.setTelefone(tel);
                        funcExib.setNome(nome);
                        funcExib.setSenha(pswd);
                    }
                }catch(ClassNotFoundException|IOException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }catch(CampoNuloException ex){
                    JOptionPane.showMessageDialog(null, ex.getMensagem(), "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
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
        MaskFormatter formatter = null;

        try{
            formatter = new MaskFormatter("(##)#####-####");
        }
        catch (ParseException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        numfrmfd = new JFormattedTextField();

        if(formatter != null){
            formatter.install(numfrmfd);
        }
        setorfd = new JComboBox(Setor.values());
    }
}
