package br.edu.ifrs.sgpp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public abstract class BaseDAO<T> implements
        Serializable {

    private static final long serialVersionULong = -5953225846505938118L;
    private EntityManager em;
    private Class entidade;

    public BaseDAO() {
    }

    public Class getEntidade() {
        if (entidade == null) {
            entidade = (Class) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entidade;
    }

    public void setEntidade(Class entidade) {
        this.entidade = entidade;
    }

    public T pesquisarPorId(Long id) {
        em = JPAUtil.getEntityManager();
        return (T) em.find(getEntidade(), id);
    }

    public void remover(Long id) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Object ref = em.getReference(getEntidade(), id);
            em.remove(ref);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Não existe o id: " + id);
        } finally {
            em.close();
        }
    }

    public void atualizar(T t) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
    }

    public void salvar(T t) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    public List<T> buscarTodos() {
        em = JPAUtil.getEntityManager();
        return em.createQuery("Select entity FROM " + getEntidade().getSimpleName() + " entity").getResultList();
    }
}
