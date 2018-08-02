/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.a.docker.jsf.gerenciadores;

import com.mycompany.a.a.docker.jsf.dao.interfaces.ContatoDaoInterface;
import com.mycompany.a.a.docker.jsf.factory.DaoFactory;
import com.mycompany.a.a.docker.jsf.interfaces.DaoFactoryInterface;
import com.mycompany.a.a.docker.jsf.model.Contato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ifpb
 */
public class GerenciadorContato {
    
    private DaoFactoryInterface fabrica = null;
    private ContatoDaoInterface contatoDao = null;

    public GerenciadorContato() {
        fabrica = DaoFactory.criarFabricaPostgres();
        try {
            //usuDao = fabrica.criaDaoUsuario();
            contatoDao = fabrica.criaDaoContato();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean login(String email, String senha){
        return contatoDao.login(email,senha);
    }
    
    public Contato getContatoByNome(String nome) {
        ContatoDaoInterface contatoDao = null;
        try {
            contatoDao = fabrica.criaDaoContato();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
            
        }
        return contatoDao.getContatoByNome(nome);
    }
    
    public boolean salvar(Contato contato){
        return contatoDao.salvar(contato);
    }
    
    public List<Contato> listar(){
        return contatoDao.listar();
    }
    
    public boolean atualizar(Contato contato){
        return contatoDao.atualizar(contato);
    }
    
    public boolean deletar(Contato contato){
        return contatoDao.deletar(contato);
    }
    
    public List<Contato> listarOrdenado(){
        return contatoDao.listarOrdenado();
    }
    
}
