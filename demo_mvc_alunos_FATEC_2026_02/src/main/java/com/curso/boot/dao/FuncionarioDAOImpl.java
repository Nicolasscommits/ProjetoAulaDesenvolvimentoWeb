package com.curso.boot.dao;

import org.springframework.stereotype.Repository;
import com.curso.boot.domain.Funcionario;

@Repository 
public class FuncionarioDAOImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDAO {

    @Override
    public void save(Funcionario funcionario) {
        super.save(funcionario);
    }

    @Override
    public void update(Funcionario funcionario) {
        super.update(funcionario);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public Funcionario findById(Long id) {
        return super.findById(id);
    }

}
