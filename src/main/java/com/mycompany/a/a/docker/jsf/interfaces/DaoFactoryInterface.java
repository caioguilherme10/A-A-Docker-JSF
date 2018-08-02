/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.a.docker.jsf.interfaces;

import com.mycompany.a.a.docker.jsf.dao.interfaces.ContatoDaoInterface;
import java.sql.SQLException;

/**
 *
 * @author ifpb
 */
public interface DaoFactoryInterface {
    
    public ContatoDaoInterface criaDaoContato() throws SQLException, ClassNotFoundException;
    
}
