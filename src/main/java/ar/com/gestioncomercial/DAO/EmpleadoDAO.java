/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Empleado;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class EmpleadoDAO extends AbstractDAO<Empleado> {

    public EmpleadoDAO() {
        super(Empleado.class);
    }

    @Override
    protected List<Empleado> getAll() {
        return null;
    }

}