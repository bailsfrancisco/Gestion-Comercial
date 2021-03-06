package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.Cotizacion;

public interface CotizacionController extends CrudController<Cotizacion> {

    double getPrecioTotalInsumos(Cotizacion cotizacion);

    void handleCotizacionRespuesta(boolean acepto, String respuesta, Cotizacion cotizacion);
}


