/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.tela;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.dao.PedidoDao;
import br.com.pizzaria.dao.PedidoDaoImpl;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Pedido;
import br.com.pizzaria.util.Utils;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marty
 */
public class CadastroPedido extends javax.swing.JFrame {

    private final ClienteDao clienteDao;
    private final PedidoDao pedidoDao;
    private Session sessao;
    private Cliente cliente;
    private final Utils util = new Utils();

    /**
     * Creates new form CadastroPedido
     */
    public CadastroPedido() {
        initComponents();
        clienteDao = new ClienteDaoImpl();
        pedidoDao = new PedidoDaoImpl();
        desativaElementos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        telClienteLb = new javax.swing.JLabel();
        telCliente = new javax.swing.JFormattedTextField();
        telClienteLb1 = new javax.swing.JLabel();
        valorPedido = new javax.swing.JTextField();
        btCadastro = new javax.swing.JButton();
        infoNum = new javax.swing.JLabel();
        dataPedido = new javax.swing.JLabel();
        infoData = new javax.swing.JLabel();
        numPedido = new javax.swing.JLabel();
        infoValor = new javax.swing.JLabel();
        valPedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Pedido");

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro Pedido");

        telClienteLb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telClienteLb.setText("Telefone Cliente:");

        try {
            telCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        telClienteLb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telClienteLb1.setText("Valor:");

        btCadastro.setText("Cadastrar");
        btCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroActionPerformed(evt);
            }
        });

        infoNum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoNum.setText("Numero Pedido:");

        dataPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dataPedido.setText("00/00/0000");

        infoData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoData.setText("Data Pedido:");

        numPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numPedido.setText("0000");

        infoValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoValor.setText("Valor Pedido: R$");

        valPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valPedido.setText("0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(telClienteLb)
                                    .addComponent(telClienteLb1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(telCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(valorPedido)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(infoValor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valPedido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(infoData)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dataPedido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(infoNum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numPedido))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(btCadastro)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telClienteLb)
                    .addComponent(telCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telClienteLb1)
                    .addComponent(valorPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btCadastro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoNum)
                    .addComponent(numPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoData)
                    .addComponent(dataPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoValor)
                    .addComponent(valPedido))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroActionPerformed
        String telefone = telCliente.getText().trim();
        String valor = valorPedido.getText().trim();
        sessao = HibernateUtil.abrirConexao();
        cliente = clienteDao.pesquisarPorTelefone(telefone, sessao);
        sessao.close();
        if (util.verificaNumerico(telefone) && util.verificaNumerico(valor)) {
            if (cliente != null) {
                Pedido pedido = new Pedido();
                int numeroPedido = pedido.getNumero() + 1;
                Date dtPedido = new Date();
                ativaElementos();

                pedido.setNumero(numeroPedido);
                pedido.setDt_pedido(dtPedido);
                pedido.setValor_total(BigDecimal.valueOf(Double.valueOf(valor)));
                try {
                    pedidoDao.salvarOuAlterar(pedido, sessao);
                    numPedido.setText(String.valueOf(numeroPedido));
                    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                    dataPedido.setText(String.valueOf(formatador.format(dtPedido)));
                    valPedido.setText(valor);
                    JOptionPane.showMessageDialog(null, "Pedido cadastrado");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar Pedido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
            }
        }

    }//GEN-LAST:event_btCadastroActionPerformed

    private void desativaElementos() {
        infoData.setVisible(false);
        infoNum.setVisible(false);
        infoValor.setVisible(false);
        numPedido.setVisible(false);
        dataPedido.setVisible(false);
        valPedido.setVisible(false);

    }

    private void ativaElementos() {
        infoData.setVisible(true);
        infoNum.setVisible(true);
        infoValor.setVisible(true);
        numPedido.setVisible(true);
        dataPedido.setVisible(true);
        valPedido.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastro;
    private javax.swing.JLabel dataPedido;
    private javax.swing.JLabel infoData;
    private javax.swing.JLabel infoNum;
    private javax.swing.JLabel infoValor;
    private javax.swing.JLabel numPedido;
    private javax.swing.JFormattedTextField telCliente;
    private javax.swing.JLabel telClienteLb;
    private javax.swing.JLabel telClienteLb1;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel valPedido;
    private javax.swing.JTextField valorPedido;
    // End of variables declaration//GEN-END:variables
}
