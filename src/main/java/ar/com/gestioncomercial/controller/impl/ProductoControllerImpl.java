/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ProductoDAO;
import ar.com.gestioncomercial.controller.ProductoController;
import ar.com.gestioncomercial.model.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class ProductoControllerImpl implements ProductoController {

    @EJB
    private ProductoDAO productoDAO;

    @Override
    public void create(Producto entity) {
        productoDAO.create(entity);
    }

    @Override
    public Producto retrieve(Producto entity) {
        return null;
    }

    @Override
    public Producto retrievebyId(Long id) {
        return null;
    }

    @Override
    public void update(Producto entity) {
        productoDAO.update(entity);
    }

    @Override
    public void delete(Producto entity) {
        productoDAO.delete(entity);
    }

    @Override
    public List<Producto> getAll() {
        return productoDAO.getAllProductos();
    }

    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

}
