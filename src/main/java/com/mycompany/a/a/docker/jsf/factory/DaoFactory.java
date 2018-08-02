/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.a.docker.jsf.factory;

import com.mycompany.a.a.docker.jsf.interfaces.DaoFactoryInterface;

/**
 *
 * @author ifpb
 */
public class DaoFactory {
    
    public static DaoFactoryInterface criarFabricaPostgres() {
        return new DaoFactoryPostgres();
    }

}
