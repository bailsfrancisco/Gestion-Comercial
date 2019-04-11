package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.CategoriaIVA;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Cliente;
import ar.com.gestioncomercial.model.Usuario;

public interface ClienteController extends PersonaController {


    CategoriaIVA[] getCategoiasIVA();

}
