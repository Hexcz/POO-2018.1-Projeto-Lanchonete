package com.ifpb.view;

import com.ifpb.control.ProdutoDao;
import com.ifpb.control.ProdutoImpDao;
import com.ifpb.model.Funcionario;
import com.ifpb.model.Produto;
import jdk.nashorn.internal.scripts.JO;
import sun.plugin2.message.Message;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Formatter;
import java.util.Locale;

public class gerenciaMenu extends JFrame {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton buscarButton;
    private JTextField textField2;
    private JTextArea textArea1;
    private JFormattedTextField prcfrmfd;
    private JButton salvarButton;
    private JButton excluirButton;
    private JButton editarButton;
    private ProdutoDao daop;
    private Produto prod;
    private final Locale BRAZIL = new Locale("pt", "BR");

    public gerenciaMenu() {

        try{
            daop = new ProdutoImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textField1.getText();
                String nome = textField2.getText();
                String descricao = textArea1.getText();
                Double preco = Double.valueOf(prcfrmfd.getText());
                prod = new Produto(codigo, preco, nome, descricao);
                try{
                    System.out.println("!!!!!!!!!   ");
                    if (daop.salvar(prod)){
                    JOptionPane.showMessageDialog(null, "Produto salvo!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Produto cadastrado.", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(IOException | ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prod = null;

                try {
                    prod = daop.buscarPorCodigo(textField1.getText());
                    if(prod != null){
                        textField1.setText(prod.getCodigo());
                        textField2.setText(prod.getNome());
                        textArea1.setText(prod.getDescricao());
                        prcfrmfd.setValue(prod.getPreco());
                    }else{
                        JOptionPane.showMessageDialog(null, "Produto não cadastrado");}
                }catch(ClassNotFoundException|IOException ex4){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }


            }

        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    prod = daop.buscarPorCodigo(textField1.getText());
                    String nome = textField1.getText();
                    String descricao = textArea1.getText();
                    Double valor = Double.parseDouble(prcfrmfd.getText());
                    Produto prodAtt = new Produto(prod.getCodigo(),valor, nome, descricao);
                    if(daop.atualizar(prodAtt)){
                        JOptionPane.showMessageDialog(null, "Produto atualizado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Produto não foi alterado");
                    }
                }catch(ClassNotFoundException|IOException ex1){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    prod = daop.buscarPorCodigo(textField1.getText());
                    int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?");
                    if(op == JOptionPane.YES_OPTION) {
                        daop.deletarPorCodigo(prod.getCodigo());
                        JOptionPane.showMessageDialog(null, "Produto excluido", "Warning message", JOptionPane.WARNING_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Produto não alterado", "Mensagem de aviso", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (ClassNotFoundException | IOException ex2) {
                    JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            });

    }

}
