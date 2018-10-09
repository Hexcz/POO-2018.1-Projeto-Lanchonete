package com.ifpb.view;

import com.ifpb.control.ComandaDao;
import com.ifpb.control.ComandaImpDao;
import com.ifpb.model.Comanda;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class gerenciaComandasData extends JFrame {
    private JPanel contentPane;
    private JFormattedTextField diniciofd;
    private JFormattedTextField dfimfd;
    private JTable table1;
    private JButton buscarButton;
    private JScrollPane scrollPane1;
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
        pack();
        setLocationRelativeTo(null);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                try{

                    if(diniciofd.getText().equals("  /  /    ") && dfimfd.getText().equals("  /  /    ")){
                        JOptionPane.showMessageDialog(null, "Datas vazias", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else if(diniciofd.getText().equals("  /  /    ")){
                        JOptionPane.showMessageDialog(null, "Data vazia.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else if(dfimfd.getText().equals("  /  /    ")){
                        JOptionPane.showMessageDialog(null, "Data vazia.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    dataInicio = LocalDate.parse(diniciofd.getText(), frm);
                    dataFim = LocalDate.parse(dfimfd.getText(), frm);
                    comandasInt = cdao.buscarEmIntervalo(dataInicio, dataFim);
                }catch(IOException|ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Falha", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }

                try{
                    if(comandasInt!=null){
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
                }catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "Nenhuma comanda para mostrar", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }



    private void createUIComponents(){

        MaskFormatter dataInicioMask = null;
        MaskFormatter dataFimMask = null;
        diniciofd = new JFormattedTextField();
        dfimfd = new JFormattedTextField();
        table1 = new JTable();

        try{
            dataInicioMask = new MaskFormatter("##/##/####");
            dataFimMask = new MaskFormatter("##/##/####");
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }

        if(dataInicioMask!=null && dataFimMask!=null){
            dataInicioMask.install(diniciofd);
            dataFimMask.install(dfimfd);
        }

        String nomeCampo[] = {"Data", "Comanda", "Valor"};
        Object [][] valores = {{"","",""}};
        DefaultTableModel tbm = new DefaultTableModel(valores, nomeCampo);
        table1.setModel(tbm);
        scrollPane1 = new JScrollPane(table1);

    }
}
