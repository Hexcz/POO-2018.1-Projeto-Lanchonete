package com.ifpb.view;

import com.ifpb.control.ComandaDao;
import com.ifpb.control.ComandaImpDao;
import com.ifpb.model.Comanda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class listarPedidos extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JButton atenderButton;
    private ComandaDao daoc;
    Set<Comanda> comandasAbertas;

    public listarPedidos() {
        try{
            daoc = new ComandaImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setTitle("Pedidos");

        try {
            comandasAbertas = daoc.buscarEmAberto();
        }catch(ClassNotFoundException|IOException ex1){
            JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }



        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda c = (Comanda) comboBox1.getSelectedItem();
                int op = JOptionPane.showConfirmDialog(null, "Deseja encerrar a comanda?");
                if(op == JOptionPane.YES_OPTION){
                   c.setComandaAberta(false);
                    try{
                        daoc.atualizar(c);
                    }catch(ClassNotFoundException|IOException ex){
                        JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null, "Comanda fechada");
                }else{
                    JOptionPane.showMessageDialog(null, "Comanda não alterada");
                }
            }
        });

    }

    private void createUIComponents() {

        if(comandasAbertas == null){
            comboBox1 = new JComboBox();
        }else {
            comboBox1 = new JComboBox(comandasAbertas.toArray());
        }
    }
}
