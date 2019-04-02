/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.Cliente;
import javax.ejb.Stateless;
import java.util.List;
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

    public List<Cliente> getAllClientes() {
        return getAll();
    }

    @Override
    protected List<Cliente> getAll() {
        Query query = em.createNamedQuery("cliente.getAllClientes");
        return query.getResultList();
    }
}
