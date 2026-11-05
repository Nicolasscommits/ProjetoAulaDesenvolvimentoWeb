package com.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.dao.FuncionarioDAO;
import com.curso.boot.domain.Funcionario;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDAO funcionarioDao;

    public void salvar(Funcionario funcionario) {
        funcionarioDao.save(funcionario);
    }

    public void excluir(Long id) {
        funcionarioDao.delete(id);
    }

    public void editar(Funcionario funcionario) {
        funcionarioDao.update(funcionario);
    }

    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return funcionarioDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return funcionarioDao.findAll();
    }
}
