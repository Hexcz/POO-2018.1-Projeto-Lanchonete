package com.ifpb.view;

import com.ifpb.control.ComandaDao;
import com.ifpb.control.ComandaImpDao;
import com.ifpb.model.Comanda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class gerenciaComandasData extends JFrame {
    private JPanel contentPane;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JTable table1;
    private JButton buscarButton;
    private JButton buttonOK;
    private ComandaDao cdao;
    private Set<Comanda> comandasInt;
    private JLabel valorTotal;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public gerenciaComandasData() {

        try{
            cdao = new ComandaImpDao();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensagem de erro", JOptionPane.ERROR_MESSAGE);

        }
        setContentPane(contentPane);
        DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            dataInicio = LocalDate.parse(formattedTextField1.getText(),frm);
            dataFim = LocalDate.parse(formattedTextField2.getText(), frm);
            comandasInt = cdao.buscarEmIntervalo(dataInicio, dataFim);
        }catch(ClassNotFoundException | IOException ex){
            JOptionPane.showMessageDialog(null, "Falha", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        Comanda[] array = new Comanda[comandasInt.size()];
        comandasInt.toArray();

        float total = 0f;

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String[] colunas = {"Data", "Comanda", "Valor"};
        Object[][] valores = new String[array.length][colunas.length];
        for(int i = 0;i<array.length;i++){
            total += array[i].calcTotal();
            for(int k = 0; k<colunas.length; k++){
                switch(k){
                    case 0:
                        valores[i][k] = array[i].getData().format(frm);
                        break;
                    case 1:
                        valores[i][k] = "Comanda " +array[i].getNumeroComanda();
                        break;
                    case 2:
                        valores[i][k] = nf.format(array[i].calcTotal());
                        break;
                }
            }
        }

        DefaultTableModel tbm = new DefaultTableModel(valores, colunas);
        table1.setModel(tbm);
        valorTotal.setText("Total: " +nf.format(total));

    }

    private void createUIComponents() {

        MaskFormatter dataCmd = null;

        try{
            dataCmd = new MaskFormatter("##/##/####");
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        formattedTextField1 = new JFormattedTextField();
        formattedTextField2 = new JFormattedTextField();

        if(dataCmd!=null){
            dataCmd.install(formattedTextField1);
            dataCmd.install(formattedTextField2);
        }

        Object [][] valores = {{" ", " ", " "}};
        String colunas[] = {"Data", "Comanda", "Valor"};

        DefaultTableModel tbm = new DefaultTableModel(valores, colunas);
        table1 = new JTable();
        table1.setModel(tbm);

    }
}
