/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.a.docker.jsf.dao.interfaces;

import com.mycompany.a.a.docker.jsf.model.Contato;
import java.util.List;

/**
 *
 * @author ifpb
 */
public interface ContatoDaoInterface {
    
    public boolean salvar(Contato contato);
    public List<Contato> listar();
    public boolean atualizar(Contato contato);
    public boolean deletar(Contato contato);
    public boolean login(String email, String senha);
    public Contato getContatoByNome(String nome);
    public List<Contato> listarOrdenado();
}
