/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.JogoDao;
import br.com.scargames.domain.Jogo;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class JogoService {
    private final JogoDao jogoDao = new JogoDao();
    public List<Jogo> Lista(){
        return jogoDao.listar();
    }
    public Jogo Consultar(int id){
        return jogoDao.consultar(id);
    }
    public boolean inserir(Jogo jogo){
        return jogoDao.inserir(jogo);
    }
    public boolean alterar(Jogo jogo){
        return jogoDao.alterar(jogo);
    }
    public boolean excluir(Jogo jogo){
        return jogoDao.excluir(jogo);
    }
}
