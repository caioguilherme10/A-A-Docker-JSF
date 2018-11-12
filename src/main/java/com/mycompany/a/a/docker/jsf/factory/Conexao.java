/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.a.docker.jsf.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ifpb
 */
public class Conexao {
    
    private static final String url = "jdbc:postgresql://host-banco:5432/Docker-JSF";
    private static final String usuario = "postgres";
    private static final String senha = "postgres";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, usuario, senha);
    }

}
