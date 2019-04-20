package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.AbstractPersona;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface EmpleadoController extends PersonaController {
    
    Double getSueldoTotal(double porcentaje, Date fechaDesde, Date fechaHasta, Long empleado);
}
