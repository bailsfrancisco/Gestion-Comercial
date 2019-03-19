package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Cotizacion extends AbstractEntity{

    private Reparacion reparacion;

    private Float precioTotal;

    private Date fechaVencimiento;
}
