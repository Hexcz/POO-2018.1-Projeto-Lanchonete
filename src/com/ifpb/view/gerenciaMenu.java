package com.ifpb.view;

import com.ifpb.control.ProdutoDao;
import com.ifpb.control.ProdutoImpDao;
import com.ifpb.exceptions.CampoNuloException;
import com.ifpb.exceptions.PrecoInvalidoException;
import com.ifpb.model.Produto;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

    public gerenciaMenu() {
        setTitle("Cardápio");
        try{
            daop = new ProdutoImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textField1.getText();
                String nome = textField2.getText();
                String descricao = textArea1.getText();
                Double preco = 0.0;
                try{
                    preco = Double.valueOf(prcfrmfd.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "O formato do número é inválido.", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                }
                prod = new Produto(codigo, preco, nome, descricao);
                try{
                    if (daop.salvar(prod)){
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Produto já existente.", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(IOException | ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }catch (CampoNuloException ex){
                    JOptionPane.showMessageDialog(null, ex.getMensagem(), "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                }catch (PrecoInvalidoException ex){
                    JOptionPane.showMessageDialog(null, ex.getMensagem(), "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(null, "Produto não cadastrado.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);}
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
                    String nome = textField2.getText();
                    String descricao = textArea1.getText();
                    Double valor = Double.parseDouble(prcfrmfd.getText());
                    Produto prodAtt = new Produto(prod.getCodigo(),valor, nome, descricao);
                    if(daop.atualizar(prodAtt)){
                        JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Produto não foi alterado.");
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
