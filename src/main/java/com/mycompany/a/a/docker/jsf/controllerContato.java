/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.a.docker.jsf;

import com.mycompany.a.a.docker.jsf.gerenciadores.GerenciadorContato;
import com.mycompany.a.a.docker.jsf.model.Contato;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ifpb
 */
@Named
@SessionScoped
public class controllerContato implements Serializable {
    
    private Contato contato = new Contato();
    private GerenciadorContato gercontato = new GerenciadorContato();

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    public String salvar(){

        this.gercontato.salvar(contato);
        
        return "index.xhtml";
    }
    
    public String update(){

        this.gercontato.atualizar(contato);
        
        return "index.xhtml";
    }
    
    public String delete(Contato contato){

        this.gercontato.deletar(contato);
        
        return "index.xhtml";
    }
    
    public boolean login(String email, String senha){
        
        return this.gercontato.login(email, senha);
    }
    
    public Contato getContatoByNome(String nome){
        
        return this.gercontato.getContatoByNome(nome);
    }
    
    public List<Contato> listar(){
        
        return this.gercontato.listar();
    }
    
    public List<Contato> listarOrdenado(){
        
        return this.gercontato.listarOrdenado();
    }
}
