/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Producto;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class ProductoDAO extends AbstractDAO<Producto> {

    public ProductoDAO() {
        super(Producto.class);
    }

    @Override
    protected List<Producto> getAll() {
        return null;
    }

}
