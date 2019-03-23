/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Proveedor;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class ProveedorDAO extends AbstractDAO<Proveedor> {

    public ProveedorDAO() {
        super(Proveedor.class);
    }

    @Override
    protected List<Proveedor> getAll() {
        return null;
    }

}
