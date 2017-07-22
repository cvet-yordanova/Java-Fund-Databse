package Model.impl;

import Model.dao.api.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class JpaDao<E, K> implements Dao<E,K> {
    private EntityManager em;
    public JpaDao (EntityManager em){
        this.em = em;
    }

    @Override
    public E findById(Class<E> entityClass, K primaryKey) {
        return  em.find(entityClass,primaryKey);
    }

    @Override
    public void remove(E entity) {
        em.remove(entity);
    }

    @Override
    public List<E> findAll(Class<E> entityClass) {
        return em.createQuery("FROM "+entityClass.getSimpleName()).getResultList();
    }

    @Override
    public void save(E Entity) {
        em.persist(Entity);
    }
}
