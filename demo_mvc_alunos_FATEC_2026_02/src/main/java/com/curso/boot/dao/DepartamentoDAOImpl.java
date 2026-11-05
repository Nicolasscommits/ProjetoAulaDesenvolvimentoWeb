package com.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.curso.boot.domain.Departamento;

@Repository
public class DepartamentoDAOImpl extends AbstractDao<Departamento, Long> implements DepartamentoDAO {

    public boolean departamentoTemFuncionarios(Long id) {
        String query = "SELECT COUNT(f) FROM Funcionario f WHERE f.departamento.id = :id";
        Long count = (Long) getEntityManager().createQuery(query)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }

    public boolean departamentoTemCargos(Long id) {
        String query = "SELECT COUNT(c) FROM Cargo c WHERE c.departamento.id = :id";
        Long count = (Long) getEntityManager().createQuery(query)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public void save(Departamento entity) {
        super.save(entity);
    }
}
