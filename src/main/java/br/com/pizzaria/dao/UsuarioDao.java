/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author silvio.junior
 */
public interface UsuarioDao extends BaseDao<Usuario, Long>{
    
    Usuario pesquisarPorLogin(String login, String senha, 
                                Session sessao) throws HibernateException;
    
    

}
