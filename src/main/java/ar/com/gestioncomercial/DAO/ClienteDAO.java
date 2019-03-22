/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.Cliente;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class ClienteDAO extends AbstractDAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }

}
