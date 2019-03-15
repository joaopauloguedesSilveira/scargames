/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.services;

import br.com.scargames.dao.BandeiraDao;
import br.com.scargames.domain.Bandeira;
import java.util.List;

/**
 *
 * @author aluno1
 */
public class BandeiraService {
    private final BandeiraDao bandeiraDao = new BandeiraDao();
    public List<Bandeira> Listar(){
        return bandeiraDao.listar();
    }
    public boolean inserir(Bandeira bandeira){
        return bandeiraDao.inserir(bandeira);
    }
    public Bandeira consulta(int id){
        return bandeiraDao.consultar(id);
    }
    public boolean alterar(Bandeira bandeira){
        return bandeiraDao.alterar(bandeira);
    }
    public boolean excluir(Bandeira bandeira){
        return bandeiraDao.excluir(bandeira);
    }
    
}
