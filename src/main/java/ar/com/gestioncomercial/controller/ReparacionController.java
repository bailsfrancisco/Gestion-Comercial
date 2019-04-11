package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Reparacion;

import java.util.List;

public interface ReparacionController extends CrudController<Reparacion> {

    Estado[] getEstados();

    List<Reparacion> findByEstado(Estado estado);

    List<Reparacion> findByCliente(AbstractPersona cliente);
}
