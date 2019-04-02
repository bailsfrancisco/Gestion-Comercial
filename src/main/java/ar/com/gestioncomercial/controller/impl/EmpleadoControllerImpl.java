package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.EmpleadoDAO;
import ar.com.gestioncomercial.controller.EmpleadoController;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Empleado;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EmpleadoControllerImpl extends AbstractPersonaControllerImpl implements EmpleadoController {

    @EJB
    private EmpleadoDAO empleadoDAO;

    @Override
    public void create(Empleado entity) {
        super.create(entity);
    }

    @Override
    public Empleado retrieve(Empleado entity) {
        return  (Empleado) super.retrieve(entity);
    }

    @Override
    public Empleado retrievebyId(Long id) {
        return empleadoDAO.find(id);
    }


    @Override
    public void update(Empleado entity) {
        super.update(entity);
    }

    @Override
    public void delete(Empleado entity) {
        super.delete(entity);
    }

    @Override
    public List<Empleado> getAll() {
        return empleadoDAO.getAllEmpleados();
    }
}
