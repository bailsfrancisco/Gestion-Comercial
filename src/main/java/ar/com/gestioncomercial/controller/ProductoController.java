/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.Producto;

/**
 *
 * @author bailsfrancisco
 */
public interface ProductoController extends CrudController<Producto> {

    void disminuirStock(Producto producto, int cantidad);

    void aumentarStock(Producto producto, int cantidad);

    void notificarStockMinimo(Producto producto);

    boolean isProductoinStockMinimo(Producto producto);

}
