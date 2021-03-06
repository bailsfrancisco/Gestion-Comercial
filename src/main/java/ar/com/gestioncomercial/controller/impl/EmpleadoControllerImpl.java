package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.EmpleadoDAO;
import ar.com.gestioncomercial.controller.EmpleadoController;
import ar.com.gestioncomercial.model.AbstractPersona;
import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import javax.mail.Session;

@Stateless
public class EmpleadoControllerImpl extends AbstractPersonaControllerImpl implements EmpleadoController {

    @EJB
    private EmpleadoDAO empleadoDAO;

    @Override
    public AbstractPersona retrievebyId(Long id) {
        return empleadoDAO.find(id);
    }

    @Override
    public List<AbstractPersona> getAll() {
        return empleadoDAO.getAllEmpleados();
    }
    
    @Override
    public Double getSueldoTotal(double porcentaje, Date fechaDesde, Date fechaHasta, Long empleado){
        return empleadoDAO.getSueldoTotal(porcentaje, fechaDesde, fechaHasta, empleado);
    }
}
