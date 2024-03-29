/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author silvio.junior
 */
public class PedidoDaoImpl extends BaseDaoImpl<Pedido, Long>
                                     implements PedidoDao, Serializable{

    @Override
    public Pedido pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> pesquisarEntreDatas(Date dataInicial,
            Date dataFinal, Session sessao) throws HibernateException {
         Query<Pedido> consulta = sessao
                 .createQuery("from Pedido p join fetch p.cliente where p.dt_pedido between :dtInicial and :dtFinal");
        consulta.setParameter("dtInicial", dataInicial);
        consulta.setParameter("dtFinal", dataFinal);
        return consulta.getResultList();
    }

    @Override
    public int capturaPedido(Session sessao) throws HibernateException {
         Query<Integer> consulta = sessao.
                    createQuery("select max(numero) from Pedido");
        return consulta.getSingleResult();
    }
    
    
}
