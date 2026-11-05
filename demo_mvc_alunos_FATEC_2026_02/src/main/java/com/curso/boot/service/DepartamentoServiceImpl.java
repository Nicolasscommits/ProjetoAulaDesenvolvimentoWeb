package com.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.dao.DepartamentoDAO;
import com.curso.boot.domain.Departamento;

@Service 
@Transactional (readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired 
    private DepartamentoDAO departamentoDao;


    public void salvar(Departamento departamento) {
        departamentoDao.save(departamento);
    }

    public void excluir(Long id) {
        departamentoDao.delete(id);
    }   

    public void editar(Departamento departamento) {
        departamentoDao.update(departamento);
    }   

    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return departamentoDao.findById(id);
    }   

    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return departamentoDao.findAll();
    }
}
