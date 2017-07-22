package Model.service.impl;


import Model.dao.api.Dao;
import Model.impl.JpaDao;
import Model.service.api.Service;
import Model.transactions.Command;
import Model.transactions.MultiResultCommand;
import Model.transactions.Transactional;
import Model.transactions.VoidCommand;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ServiceImpl<E,K> implements Service<E, K>, Transactional<E>{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    protected EntityManager em;
    protected Dao<E,K> dao;
    @Override
    public E findById(Class<E> serviceClass, K id) {

        E result = runInTransaction(new Command<E>() {
            @Override
            public E execute() {
                return dao.findById(serviceClass,id);
            }
        });

        return result;
    }

    @Override
    public void remove(E entity) {
        runInTransaction(new VoidCommand<E>() {
            @Override
            public void execute() {
                dao.remove(entity);
            }
        });
    }

    @Override
    public List<E> findAll(Class<E> serviceClass) {
        return runInTransaction(new MultiResultCommand<E>() {
            @Override
            public List<E> execute() {
                return dao.findAll(serviceClass);
            }
        });
    }

    @Override
    public void save(E Entity) {
        runInTransaction(new VoidCommand<E>() {
            @Override
            public void execute() {
                dao.save(Entity);
            }
        });
    }

    @Override
    public void runInTransaction(VoidCommand<E> command) {
        em = emf.createEntityManager();
        try {
            dao = createDao();
            em.getTransaction().begin();
            command.execute();
            em.getTransaction().commit();

        } catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        } finally {
            try{em.close();} catch (IllegalStateException e){
                //log
            }
        }
    }

    protected Dao<E,K> createDao() {
        return new JpaDao<E, K>(em);
    }


    @Override
    public E runInTransaction(Command<E> command) {
        em = emf.createEntityManager();
        try {
            dao = createDao();
            em.getTransaction().begin();
            E result = command.execute();
            em.getTransaction().commit();
            return result;
        } catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        } finally {
            try{em.close();} catch (IllegalStateException e){
                //log
            }
        }
    }

    @Override
    public List<E> runInTransaction(MultiResultCommand<E> command) {
        em = emf.createEntityManager();
        try {
            dao = createDao();
            em.getTransaction().begin();
            List<E> result =  command.execute();
            em.getTransaction().commit();
            return result;

        } catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        } finally {
            try{em.close();} catch (IllegalStateException e){
                //log
            }
        }
   
    }
}
