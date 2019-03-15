/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.CidadeDao;
import br.com.scargames.domain.Cidade;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class CidadeService {
    private final CidadeDao cidadeDao = new CidadeDao();
    public List<Cidade> listar(){
        return cidadeDao.listar();
    }
    public boolean inserir(Cidade cidade){
        return cidadeDao.inserir(cidade);
    }
    public Cidade consulta(int id){
        return cidadeDao.consultar(id);
    }
    public boolean alterar(Cidade cidade){
        return cidadeDao.alterar(cidade);
    }
    public boolean excluir(Cidade cidade){
        return cidadeDao.excluir(cidade);
    }
}
