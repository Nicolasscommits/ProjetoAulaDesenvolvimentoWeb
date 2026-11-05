package com.curso.boot.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AbstractDao<T, PK extends Serializable> {

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(PK id) {
        getEntityManager().remove(getEntityManager().getReference(entityClass, id));
    }

    public T findById(PK id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        return getEntityManager()
                .createQuery("from " + entityClass.getName(), entityClass).getResultList();
    }

    protected List<T> createQuery(String jpql, Object... params) {
        var query = getEntityManager().createQuery(jpql, entityClass);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }

}
