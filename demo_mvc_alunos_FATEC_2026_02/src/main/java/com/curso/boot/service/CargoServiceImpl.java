package com.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.dao.CargoDAO;
import com.curso.boot.domain.Cargo;


@Service 
@Transactional(readOnly = false) 
public class CargoServiceImpl implements CargoService {

    @Autowired 
    private CargoDAO cargoDao;


    public void salvar(Cargo cargo) {
        cargoDao.save(cargo);
    }

    public void excluir(Long id) {
        cargoDao.delete(id);
    }   

    public void editar(Cargo cargo) {
        cargoDao.update(cargo);
    }   

    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return cargoDao.findById(id);
    }   

    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return cargoDao.findAll();
    }

}
