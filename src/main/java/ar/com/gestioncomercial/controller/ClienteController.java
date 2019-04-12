package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.CategoriaIVA;

public interface ClienteController extends PersonaController {


    CategoriaIVA[] getCategoiasIVA();

}
