/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ifpb
 * Created: 02/08/2018
 */
CREATE TABLE contato (
    ID serial PRIMARY KEY,
    nome  VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    datanascimento DATE
);
