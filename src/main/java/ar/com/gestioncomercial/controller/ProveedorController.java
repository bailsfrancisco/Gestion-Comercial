package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.CategoriaIVA;

public interface ProveedorController extends PersonaController {

    CategoriaIVA[] getCategoriasIVA();
}
