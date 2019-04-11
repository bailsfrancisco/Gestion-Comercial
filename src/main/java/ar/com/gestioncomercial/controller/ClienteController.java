package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.CategoriaIVA;
import ar.com.gestioncomercial.model.Cliente;

public interface ClienteController extends CrudController<Cliente> {

    CategoriaIVA[] getCategoiasIVA();
}
