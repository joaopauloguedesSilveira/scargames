/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.GeneroDao;
import br.com.scargames.domain.Genero;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class GeneroService {
    private final GeneroDao generoDao = new GeneroDao();
    public List<Genero> listar(){
        return generoDao.listar();
    }
    public boolean inserir(Genero genero){
        return generoDao.inserir(genero);
    }
    public Genero consulta(int id){
        return generoDao.consultar(id);
    }
    public boolean alterar(Genero genero){
        return generoDao.alterar(genero);
    }
    public boolean excluir(Genero genero){
        return generoDao.excluir(genero);
    }
}
