/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import static br.com.pizzaria.util.GeradorUtil.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author silvio.junior
 */
public class PedidoDaoImplTest {

    private Pedido pedido;
    private PedidoDao pedidoDao;
    private Session sessao;

    public PedidoDaoImplTest() {
        pedidoDao = new PedidoDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ClienteDaoImplTest cdit = new ClienteDaoImplTest();

        pedido = new Pedido(5, new BigDecimal(gerarNumero(3)), new Date());
        pedido.setCliente(cdit.buscarClienteBd());
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, sessao);
        sessao.close();
        assertNotNull(pedido.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        Pedido pedidoId = pedidoDao.pesquisarPorId(pedido.getId(), sessao);
        sessao.close();
        assertNotNull(pedidoId);
    }

//        @Test
    public void pesquisarEntreDatas() {
        System.out.println("pesquisar por datas");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        List<Pedido> pedidoDatas = pedidoDao.pesquisarEntreDatas(pedido.getDt_pedido(), pedido.getDt_pedido(), sessao);
        sessao.close();
        assertTrue(!pedidoDatas.isEmpty());
    }

    
    public Pedido buscarClienteBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Pedido> consulta = sessao.createQuery("from Pedido p");
        List<Pedido> pedidos = consulta.getResultList();
        sessao.close();

        if (pedidos.isEmpty()) {
            testSalvar();
        } else {
            pedido = pedidos.get(0);
        }
        return pedido;
    }

}
