/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.CartaoDao;
import br.com.scargames.domain.Cartao;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class CartaoService {
    private final CartaoDao cartaoDao = new CartaoDao();
    public List<Cartao> listar(){
        return cartaoDao.listar();
    }
    public boolean inserir(Cartao cartao){
        return cartaoDao.inserir(cartao);
    }
    public Cartao consulta(int id){
        return cartaoDao.consultar(id);
    }
    public boolean alterar(Cartao cartao){
        return cartaoDao.alterar(cartao);
    }
    public boolean excluir(Cartao cartao){
        return cartaoDao.excluir(cartao);
    }
}
