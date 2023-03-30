/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.tela;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.entidade.EnderecoDTO;
import br.com.pizzaria.webservice.CepRest;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Endereco;
import br.com.pizzaria.util.Utils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public class CadastroCliente extends javax.swing.JFrame {

    private ClienteDao clienteDao;
    private Session sessao;
    Utils util = new Utils();
    private Cliente cliente;

    /**
     * Creates new form Principal
     */
    public CadastroCliente() {
        initComponents();
        clienteDao = new ClienteDaoImpl();
    }

    public CadastroCliente(Cliente cliente) {
        initComponents();
        clienteDao = new ClienteDaoImpl();
        this.cliente = cliente;
        carregarDadosCliente();

    }

    private void carregarDadosCliente() {
        Endereco enderecosCarregado = cliente.getEnderecos().get(0);
        varNome.setText(cliente.getNome());
        varEmail.setText(cliente.getEmail());
        varTelefone.setText(cliente.getTelefone());
        varBairro.setText(enderecosCarregado.getBairro());
        varCep.setText(enderecosCarregado.getCep());
        varCidade.setText(enderecosCarregado.getCidade());
        varComplemento.setText(enderecosCarregado.getComplemento());
        varEstado.setText(enderecosCarregado.getEstado());
        varNumero.setText(enderecosCarregado.getNumero());
        varObservacao.setText(enderecosCarregado.getObservacao());
        varRua.setText(enderecosCarregado.getLogradouro());
    }

    private boolean validarFormulario(boolean atualizou) {
        if (!atualizou) {
            return util.verificaCampo2(varNome.getText().trim())
                    && util.verificaEmail(varEmail.getText().trim())
                    && util.verificaTelefone(varTelefone.getText().trim());
        } else {
            return util.verificaCampo2(varNome.getText().trim());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        varCep = new javax.swing.JTextField();
        btBuscarCep = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        varRua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        varCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        varTelefone = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        varBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        varEstado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        varNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        varComplemento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varObservacao = new javax.swing.JTextArea();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Cliente");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        btSalvar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CEP:");

        btBuscarCep.setText("Buscar");
        btBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarCepActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Rua:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Bairro:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("E-mail:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Telefone:");

        try {
            varTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varTelefoneActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cidade:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Estado:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Número:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Compl.:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Obs:");

        varObservacao.setColumns(20);
        varObservacao.setRows(5);
        jScrollPane1.setViewportView(varObservacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(varRua))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(varCidade))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(varTelefone))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(varCep, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(varBairro))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(varEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(varComplemento))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(varCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(varRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(varEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        boolean atualizou = false;
        clienteDao = new ClienteDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        Cliente clienteNovo = carregarCliente();
        if (cliente != null) {
            clienteNovo.setId(cliente.getId());
            atualizou = true;
        }
        if (validarFormulario(atualizou)) {
            try {
                clienteDao.salvarOuAlterar(clienteNovo, sessao);
                if (atualizou) {
                    JOptionPane.showMessageDialog(null, "Cliente Atualizado");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!!");
            } finally {
                sessao.close();
                limparCampos();

            }

    }//GEN-LAST:event_btSalvarActionPerformed
    }

    private Cliente carregarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(varNome.getText().trim());
        cliente.setEmail(varEmail.getText().trim());
        cliente.setTelefone(varTelefone.getText().trim());

        List<Endereco> enderecos = new ArrayList<>();
        Endereco endereco = new Endereco();
        endereco.setLogradouro(varRua.getText().trim());
        endereco.setBairro(varBairro.getText().trim());
        endereco.setCep(varCep.getText().trim());
        endereco.setCidade(varCidade.getText().trim());
        endereco.setEstado(varEstado.getText().trim());
        endereco.setNumero(varNumero.getText().trim());
        endereco.setComplemento(varComplemento.getText().trim());
        endereco.setObservacao(varObservacao.getText().trim());

        enderecos.add(endereco);
        endereco.setPessoa(cliente);
        cliente.setEnderecos(enderecos);

        return cliente;
    }


    private void btBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCepActionPerformed
        CepRest cepRest = new CepRest();
        EnderecoDTO enderecoDTO = cepRest.pesquisarCep(varCep.getText());
        if (enderecoDTO == null) {
            JOptionPane.showMessageDialog(null, "CEP não encontrado!");
            varRua.setText("");
            varCidade.setText("");
            varBairro.setText("");
            varEstado.setText("");
            varNumero.setText("");

        } else {
            varRua.setText(enderecoDTO.getLogradouro());
            varBairro.setText(enderecoDTO.getBairro());
            varCidade.setText(enderecoDTO.getLocalidade());
            varEstado.setText(enderecoDTO.getUf());
        }
    }//GEN-LAST:event_btBuscarCepActionPerformed

    private void limparCampos() {
        varNome.setText("");
        varEmail.setText("");
        varTelefone.setText("");
        varBairro.setText("");
        varCep.setText("");
        varCidade.setText("");
        varComplemento.setText("");
        varEstado.setText("");
        varNumero.setText("");
        varObservacao.setText("");
        varRua.setText("");
    }
    private void varTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varTelefoneActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_varTelefoneActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarCep;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField varBairro;
    private javax.swing.JTextField varCep;
    private javax.swing.JTextField varCidade;
    private javax.swing.JTextField varComplemento;
    private javax.swing.JTextField varEmail;
    private javax.swing.JTextField varEstado;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNumero;
    private javax.swing.JTextArea varObservacao;
    private javax.swing.JTextField varRua;
    private javax.swing.JFormattedTextField varTelefone;
    // End of variables declaration//GEN-END:variables
}
