/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.a.docker.jsf.dao.postgres;

import com.mycompany.a.a.docker.jsf.dao.interfaces.ContatoDaoInterface;
import com.mycompany.a.a.docker.jsf.factory.Conexao;
import com.mycompany.a.a.docker.jsf.model.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ifpb
 */
public class ContatoDaoPostgres implements ContatoDaoInterface{
    
    private final Connection conn;
    
    public ContatoDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Contato contato) {
        
        String sql = "INSERT INTO contato (nome, email, senha, telefone, datanascimento) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getSenha());
            stmt.setString(4, contato.getTelefone());
            stmt.setDate(5, Date.valueOf(contato.getDataNascimento()));

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<Contato> listar() {
        
        String sql = "SELECT * FROM Contato;";
        List<Contato> contatos = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Date data = rs.getDate("datanascimento");
                Instant instant = Instant.ofEpochMilli(data.getTime());

                Contato contato = new Contato(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("telefone"),
                        LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
                );

                contatos.add(contato);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return contatos;
    }

    @Override
    public boolean atualizar(Contato contato) {
        
    }

    @Override
    public boolean deletar(Contato contato) {
        
    }

    @Override
    public boolean login(String email, String senha) {
        
    }

    @Override
    public Contato getContatoByNome(String nome) {
        
    }
    
}
