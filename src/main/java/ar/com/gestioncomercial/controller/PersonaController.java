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
public interface PersonaController {

    void insertarPersona(AbstractPersona persona);

    AbstractPersona obtenerPersona(AbstractPersona persona);

    AbstractPersona obtenerPersonaById(Long id);

    void actualizarPersona(AbstractPersona persona);

    void borrarPersona(AbstractPersona persona);

    List<AbstractPersona> obtenerPersonas();
}
