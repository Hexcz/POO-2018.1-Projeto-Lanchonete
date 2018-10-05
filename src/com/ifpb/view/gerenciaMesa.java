package com.ifpb.view;

import com.ifpb.control.ComandaDao;
import com.ifpb.control.ComandaImpDao;
import com.ifpb.model.Comanda;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class gerenciaMesa extends JFrame {
    private JPanel contentPane;
    private JSpinner spinner1;
    private JButton novaComandaButton;
    private JButton verPedidosButton;
    private JButton fazerPedidoButton;
    private JButton encerrarComandaButton;
    private ComandaDao cdao;

    public gerenciaMesa() {
        try{
            cdao = new ComandaImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try{
            System.out.println("entrou no try");
            System.out.println(cdao.getComandas());
        }catch(IOException|ClassNotFoundException ex){
            System.out.println("deu erro");
        }

        encerrarComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda c;
                    try {
                        if(spinner1.getValue()!=null) {
                            c = cdao.buscarPorNumero((Integer) spinner1.getValue());
                            cdao.deletar(c);
                            JOptionPane.showMessageDialog(null, "Comanda encerrada com sucesso. Total: " + c.calcTotal());
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
                try {
                    if(spinner1.getValue()!=null) {
                        c = new Comanda((Integer) spinner1.getValue());
                        cdao.salvar(c);
                        JOptionPane.showMessageDialog(null, "Comanda criada com sucesso para a mesa .");
                    }else{
                        JOptionPane.showMessageDialog(null, "Comanda não especificada corretamente.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(ClassNotFoundException|IOException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        fazerPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda c = null;
                try{
                    c = cdao.buscarPorNumero((Integer) spinner1.getValue());
                }catch(ClassNotFoundException|IOException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
                if(c!=null && spinner1!=null) {
                    gerenciaPedido gp = new gerenciaPedido(c);
                    gp.pack();
                    gp.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro! Comanda não especificada corretamente", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });




    }
}
