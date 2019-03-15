/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.EnderecoDao;
import br.com.scargames.domain.Endereco;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class EnderecoService {
    private final EnderecoDao enderecoDao = new EnderecoDao();
    public List<Endereco> listar(){
        return enderecoDao.listar();
    }
    public boolean inserir(Endereco endereco){
        return enderecoDao.inserir(endereco);
    }
    public Endereco consulta(int id){
        return enderecoDao.consultar(id);
    }
    public boolean alterar(Endereco endereco){
        return enderecoDao.alterar(endereco);
    }
    public boolean excluir(Endereco endereco){
        return enderecoDao.excluir(endereco);
    }
}
