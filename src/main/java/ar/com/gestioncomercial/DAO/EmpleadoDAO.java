/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class EmpleadoDAO extends AbstractDAO<AbstractPersona> {

    public EmpleadoDAO() {
        super(AbstractPersona.class);
    }

    public List<AbstractPersona> getAllEmpleados() {
        return getAll();
    }

    @Override
    protected List<AbstractPersona> getAll() {
        Query query = em.createNamedQuery("empleado.getAll");
        return query.getResultList();
    }
    
    public Double getSueldoTotal(double porcentaje, Date fechaDesde, Date fechaHasta, Long empleado) {
        String qlString = "SELECT (sum(c.PRECIOMANOOBRA) * ? / 100)  FROM Reparacion as r, Cotizacion as c  WHERE (c.id = r.cotizacion)  AND (Date(r.fechaAlta) BETWEEN ? AND ?)  AND r.tecnico =  ?";
        Query query = em.createNativeQuery(qlString);
        query.setParameter(1, porcentaje);
        query.setParameter(2, fechaDesde);
        query.setParameter(3, fechaHasta);
        query.setParameter(4, empleado);
        
        Double results =  (Double)query.getSingleResult();

       
        System.out.println("RESULTADO: " + results);
        
        return results;
    }

}
