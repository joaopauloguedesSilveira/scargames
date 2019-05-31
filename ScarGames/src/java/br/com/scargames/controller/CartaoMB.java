/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.controller;

import br.com.scargames.domain.Cartao;
import br.com.scargames.services.CartaoService;
import br.com.scargames.util.UtilMessages;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author aluno1
 */
@ManagedBean(name = "cartaoMB")
@SessionScoped
public class CartaoMB {

    private Cartao cartao = new Cartao();
    private List<Cartao> cartoes;
    private CartaoService service;
    
    public CartaoMB() {
        service = new CartaoService();
        cartoes = service.listar();
    }
    
    public void novo(){
        cartao = new Cartao();
        
    }
    
    public void inserir(){
        
        if (service.inserir(cartao)){
            UtilMessages.messageInfo("Genero cadastrada com sucesso");
            cartoes = service.listar();
            PrimeFaces current = PrimeFaces.current();
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a Cartao");
        }
    }
    
    public void carregarDados(Cartao cartao){
        this.cartao = cartao;
    }
    
    public void excluir(Cartao cartao){
        if (service.excluir(cartao)){
            UtilMessages.messageInfo("Cartao excluida com sucesso");
            cartoes = service.listar();
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a gênero");
           
            
        }
    }
    
    
    public Cartao getGenero() {
        return cartao;
    }

    public void setGenero(Cartao genero) {
        this.cartao = genero;
    }

    public CartaoService getGeneroService() {
        return service;
    }

    public void setGeneroService(CartaoService generoService) {
        this.service = generoService;
    }

    public List<Cartao> getGeneros() {
        return cartoes;
    }

    public void setGeneros(List<Cartao> generos) {
        this.cartoes = generos;
    }
    
}
