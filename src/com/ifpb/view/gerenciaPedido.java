package com.ifpb.view;

import com.ifpb.control.ComandaDao;
import com.ifpb.control.ComandaImpDao;
import com.ifpb.control.ProdutoDao;
import com.ifpb.control.ProdutoImpDao;
import com.ifpb.model.Comanda;
import com.ifpb.model.Pedido;
import com.ifpb.model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

public class gerenciaPedido extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JButton criarButton;
    private ComandaDao daoc;
    private ProdutoDao daop;
    private Set<Produto> cardapio;
    private Pedido p;

    public gerenciaPedido(Comanda c) {

        try{
            daoc = new ComandaImpDao();
            daop = new ProdutoImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
        setContentPane(contentPane);
        setTitle("Criar pedido");

        try{
            cardapio = daop.getProdutos();
        }catch(ClassNotFoundException|IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        criarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Produto pd = (Produto) comboBox1.getSelectedItem();
                        Integer qtd = (Integer) spinner1.getValue();
                        p = new Pedido(pd, qtd);
                        c.create(p);
                    }
                }
        );


    }

    private void createUIComponents() {
        comboBox1 = new JComboBox(cardapio.toArray());
    }
}
