/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.controller;

import br.com.scargames.domain.Genero;
import br.com.scargames.services.GeneroService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author aluno1
 */
@ManagedBean(name = "GeneroMb")
@ViewScoped
public class GeneroMb implements Serializable{

    private Genero genero = new Genero();
    private List<Genero> generos;
    private GeneroService service;
    
    public GeneroMb() {
        service = new GeneroService();
        generos = service.listar();
        System.out.println(generos.get(0).getDescricao());
    }
    
    public void novo(){
        genero = new Genero();
        
    }
    
    public void inserir(){
        
        if (service.inserir(genero)){
            UtilMessages.messageInfo("Genero cadastrada com sucesso");
            generos = service.listar();
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('gestaoGenero).hide()");
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a genero");
        }
    }
    
    public void carregarDados(Genero genero){
        this.genero = genero;
    }
    
    public void excluir(Genero genero){
        if (service.excluir(genero)){
            UtilMessages.messageInfo("Genero excluida com sucesso");
            generos = service.listar();
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a gênero");
           
            
        }
    }
    
    
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public GeneroService getGeneroService() {
        return service;
    }

    public void setGeneroService(GeneroService generoService) {
        this.service = generoService;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
    
}
