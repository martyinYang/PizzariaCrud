/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.entidade.Cliente;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author martyin.okuma
 */
public class Utils {

    private final ClienteDao clienteDao;
    private Session sessao;

    public Utils() {
        clienteDao = new ClienteDaoImpl();
    }

    public boolean verificaCampo3(String campo) {
        if (campo.length() < 3) {
            JOptionPane.showMessageDialog(null, "No minimo 3 caracteres");
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaCampo2(String campo) {
        if (campo.length() < 2) {
            JOptionPane.showMessageDialog(null, "No minimo 2 caracteres");
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaEmail(String campo) {
        if (campo.contains("@") && campo.contains(".")) {
            try {
                sessao = HibernateUtil.abrirConexao();
                Cliente clienteCaptura = clienteDao.pesquisarEmail(campo, sessao);
                JOptionPane.showMessageDialog(null, "E-mail já cadastrado");
                return false;
            } catch (Exception e) {
                return true;
            } finally {
                sessao.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "E-mail invalido");
            return false;
        }
    }

    public boolean verificaNumerico(String campo) {
        String campoFormatado = campo.replace(".", "").replace(",", "");
        boolean numerico = campoFormatado.matches("[0-9]*");
        if (numerico) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Valor não numérico");
            return false;
        }
    }

    public boolean verificaTelefone(String telefone) {
        if (telefone.length() != 13) {
            JOptionPane.showMessageDialog(null, "Telefone inválido");
            return false;
        } else {
            try {
                sessao = HibernateUtil.abrirConexao();
                Cliente clienteCaptura = clienteDao.pesquisarPorTelefone(telefone, sessao);
                JOptionPane.showMessageDialog(null, "Telefone já cadastrado");
                return false;
            } catch (Exception e) {
                return true;
            } finally {
                sessao.close();
            }

        }

    }

    public boolean verificaData(String campo) {
        if (campo.contains("/") && campo.length() == 10) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Formato de data invalido");

            return false;
        }
    }

}
