/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Cliente;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author silvio.junior
 */
public class ClienteDaoImpl extends BaseDaoImpl<Cliente, Long>
        implements ClienteDao, Serializable {

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao)
            throws HibernateException {
        return sessao.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome,
            Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao
                .createQuery("select distinct(c) from Cliente c join fetch c.enderecos "
                        + "where c.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public Cliente pesquisarPorTelefone(String telefone,
            Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao.
                createQuery("select distinct(c) from Cliente c join fetch c.enderecos "
                        + "where c.telefone = :tel");
        consulta.setParameter("tel", telefone);
        return consulta.getSingleResult();
    }

    @Override
    public Cliente pesquisarEmail(String email, Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao
                .createQuery("select distinct(c) from Cliente c join fetch c.enderecos "
                        + "where c.email like :email");
        consulta.setParameter("email", "%" + email + "%");
        return consulta.getSingleResult();
    }

}
