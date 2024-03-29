/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

//import br.com.senac.entidade.Usuario;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Endereco;
import br.com.pizzaria.entidade.Pedido;
import br.com.pizzaria.entidade.Pessoa;
import br.com.pizzaria.entidade.Usuario;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Silvio
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; //Singleton

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Pessoa.class);
            cfg.addAnnotatedClass(Cliente.class);
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Pedido.class);
            cfg.addAnnotatedClass(Usuario.class);
            cfg.configure("/META-INF/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().
                    applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session abrirConexao() {
        return sessionFactory.openSession();
    }
}
