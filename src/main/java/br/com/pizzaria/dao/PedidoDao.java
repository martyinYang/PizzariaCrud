/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author silvio.junior
 */
public interface PedidoDao extends BaseDao<Pedido, Long>{
    
    List<Pedido> pesquisarEntreDatas(Date dataInicial, Date dataFinal,
            Session sessao) throws HibernateException;
    
    int capturaPedido(Session sessao) throws HibernateException;
}
