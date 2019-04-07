package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Reparacion;

public interface ReparacionController extends CrudController<Reparacion> {

    Estado[] getEstados();
}
