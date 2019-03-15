/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.ProdutoraDao;
import br.com.scargames.domain.Produtora;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class ProdutoraService {
    private final ProdutoraDao produtorDao = new produtoraDao();
    public List<Produtora> listar(){
        return produtorDao.listar();
    }
    public boolean inserir(Produtora produtor){
        return produtorDao.inserir(produtor);
    }
    public Produtora consulta(int id){
        return produtorDao.consultar(id);
    }
    public boolean alterar(Produtora produtor){
        return produtorDao.alterar(produtor);
    }
    public boolean excluir(Produtora produtor){
        return produtorDao.excluir(produtor);
    }
}
