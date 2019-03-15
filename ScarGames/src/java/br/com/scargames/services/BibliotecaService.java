/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.BibliotecaDao;
import br.com.scargames.domain.Biblioteca;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class BibliotecaService {
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao();
    public List<Biblioteca> listar(){
        return bibliotecaDao.listar();
    }
    public boolean inserir(Biblioteca biblioteca){
        return bibliotecaDao.inserir(biblioteca);
    }
    public Biblioteca consulta(int id){
        return bibliotecaDao.consultar(id);
    }
    public boolean alterar(Biblioteca biblioteca){
        return bibliotecaDao.alterar(biblioteca);
    }
    public boolean excluir(Biblioteca biblioteca){
        return bibliotecaDao.excluir(biblioteca);
    }
}
