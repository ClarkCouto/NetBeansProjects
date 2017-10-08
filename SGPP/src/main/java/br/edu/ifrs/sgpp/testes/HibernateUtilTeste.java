/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.testes;

import br.edu.ifrs.sgpp.dao.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 *
 * @author CristianoSilva
 */
public class HibernateUtilTeste {
    @Test
    public void conectar(){
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.close();
        HibernateUtil.getFabricaDeSessoes().close();
    }
}