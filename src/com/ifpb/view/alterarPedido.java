package com.ifpb.view;

import com.ifpb.control.ProdutoDao;
import com.ifpb.control.ProdutoImpDao;

import javax.swing.*;
import java.io.IOException;

public class alterarPedido extends JFrame {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JButton modificarButton;
    private JButton excluirButton;
    private JSpinner spinner1;
    private JButton buttonOK;
    ProdutoDao prodPed;

    public alterarPedido() {
        setContentPane(contentPane);
        setTitle("Fazer pedido");
        try{
            prodPed = new ProdutoImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha no arquivo.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        alterarPedido dialog = new alterarPedido();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() throws IOException, ClassNotFoundException{
        comboBox1 = new JComboBox(prodPed.getProdutos().toArray());
    }
}
