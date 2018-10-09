package com.ifpb.view;

import com.ifpb.control.ComandaDao;
import com.ifpb.control.ComandaImpDao;
import com.ifpb.model.Comanda;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class gerenciaMesa extends JFrame {
    private JPanel contentPane;
    private JSpinner spinner1;
    private JButton novaComandaButton;
    private JButton verPedidosButton;
    private JButton fazerPedidoButton;
    private JButton encerrarComandaButton;
    private ComandaDao cdao;
    private Set<Comanda> comandas = new HashSet<>();
    private boolean primeiraComanda = false;

    public gerenciaMesa() {
        try{
            cdao = new ComandaImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


       encerrarComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda c;
                    try {
                        if(spinner1.getValue()!=null) {
                            c = cdao.buscarPorNumero((Integer) spinner1.getValue());
                            cdao.deletar(c);
                            JOptionPane.showMessageDialog(null, "Comanda encerrada com sucesso. Total: ");
                        }else{
                            JOptionPane.showMessageDialog(null, "Comanda não especificada corretamente.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(ClassNotFoundException|IOException ex){
                        JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        novaComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda c;
                if ((int)spinner1.getValue() <= 0){
                    JOptionPane.showMessageDialog(null, "O número da mesa deve ser maior que 0.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
                else if(spinner1.getValue()!=null){
                    c = new Comanda((int) spinner1.getValue());
                    try{
                        if(!comandas.contains(c)){
                            comandas.add(c);
                            JOptionPane.showMessageDialog(null, "Comanda criada com sucesso para a mesa .");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Comanda já existente no sistema.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }catch (NullPointerException ex){
                        JOptionPane.showMessageDialog(null, "Ainda não há comandas cadastradas.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Comanda não especificada corretamente.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        fazerPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda c;
                try{
                    c = cdao.buscarPorNumero((int)spinner1.getValue());
                    System.out.println(c);
                    if(spinner1!=null) {
                        gerenciaPedido gp = new gerenciaPedido(c);
                        gp.pack();
                        gp.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro! Comanda não especificada corretamente", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(ClassNotFoundException|IOException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}
