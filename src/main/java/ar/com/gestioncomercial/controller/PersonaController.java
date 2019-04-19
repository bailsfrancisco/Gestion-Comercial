/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.*;

import java.util.List;

/**
 *
 * @author Bails Francisco
 */
public interface PersonaController extends CrudController<AbstractPersona> {

    AbstractPersona getByUsuario(Usuario usuario);

    List<AbstractPersona> getAllAdmins();

    //este metodo se utiliza en la factura, facturaBacking
    public AbstractPersona obtenerClientePorCodigo() throws Exception;

}
