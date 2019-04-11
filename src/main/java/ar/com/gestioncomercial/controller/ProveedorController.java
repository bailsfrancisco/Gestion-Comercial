package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.CategoriaIVA;
import ar.com.gestioncomercial.model.Proveedor;

public interface ProveedorController extends PersonaController {

    CategoriaIVA[] getCategoriasIVA();
}
