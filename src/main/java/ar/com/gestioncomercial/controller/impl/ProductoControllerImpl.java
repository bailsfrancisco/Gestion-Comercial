/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ProductoDAO;
import ar.com.gestioncomercial.controller.ProductoController;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Producto;
import ar.com.gestioncomercial.utils.EmailUtils;

import java.util.List;
import java.util.stream.Collectors;
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

    @EJB
    private AbstractPersonaControllerImpl abstractPersonaController;

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
        return productoDAO.find(id);
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

    @Override
    public void disminuirStock(Producto producto, int cantidad) {

        int stockActual = producto.getStockActual() - cantidad;
        producto.setStockActual(stockActual);

        if (isProductoinStockMinimo(producto)) {
            notificarStockMinimo(producto);
        }

        update(producto);
    }

    @Override
    public void aumentarStock(Producto producto, int cantidad) {
        int stockActual = producto.getStockActual() + cantidad;
        producto.setStockActual(stockActual);
        update(producto);
    }

    @Override
    public void notificarStockMinimo(Producto producto) {
        List<String> adminsEmails =  abstractPersonaController.
                getAllAdmins().stream()
                .map(AbstractPersona::getMail).collect(Collectors.toList());

        EmailUtils.productoStockMinimoEmail(producto.getNombre(),
                producto.getStockMinimo(),
                adminsEmails);
    }

    @Override
    public boolean isProductoinStockMinimo(Producto producto) {
        return producto.getStockActual()<= producto.getStockMinimo();
    }
}
