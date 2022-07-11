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

    public Utils() {
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
        ClienteDao clienteDao;
        clienteDao = new ClienteDaoImpl();
        Session sessao;
        sessao = HibernateUtil.abrirConexao();
        Cliente cliente = clienteDao.pesquisarEmail(campo, sessao);

        if (cliente != null) {
            if (campo.contains("@") && campo.contains(".")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "E-mail invalido");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "E-mail já cadastrado");
            return false;
        }
    }

    public boolean verificaNumerico(String campo) {
        boolean numerico = campo.chars().allMatch(Character::isDigit);
        if (numerico) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Valor não numérico");
            return false;
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
