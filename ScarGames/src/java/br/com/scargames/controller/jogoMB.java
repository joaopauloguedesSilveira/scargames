/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.controller;

import br.com.scargames.domain.Jogo;
import br.com.scargames.services.JogoService;
import br.com.scargames.util.UtilMessages;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aluno1
 */
@ManagedBean(name = "jogoMB")
@RequestScoped
public class JogoMB {
    private Jogo jogo;
    private List<Jogo> jogos;
    /**
     * Creates a new instance of jogoMB
     */
    public JogoMB() {
        this.listar();
    }
    
    public void listar(){
        JogoService service = new JogoService();
        jogos = service.listar();
    }
    
    public String novo(){
        jogo = new Jogo();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        JogoService service = new JogoService();
        if (service.inserir(jogo)){
            UtilMessages.messageInfo("Bandeira cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a jogo!");
            return null;
        }
    }
    
    public String alterar(){
        JogoService service = new JogoService();
        if (service.alterar(jogo)){
            UtilMessages.messageInfo("Bandeira alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a jogo!");
            return null;
        }
    }
    
    public String carregarDados(Jogo jogo){
        this.jogo = jogo;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Jogo jogo){
        JogoService service = new JogoService();
        if (service.excluir(jogo)){
            UtilMessages.messageInfo("Bandeira excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a jogo!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    
    
}
