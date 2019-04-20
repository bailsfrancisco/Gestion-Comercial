package ar.com.gestioncomercial.utils;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class URLMap implements Serializable {

    private static final String INDEX = "/index.xhtml";
    private static final String WELCOME = "/welcome.xhtml";

    private static final String _INDEX = "index.xhtml";
    private static final String _EDIT = "edit.xhtml";
    private static final String _NEW = "new.xhtml";
    private static final String _DETAIL = "details.xhtml";

    private static final String _SUELDO = "sueldo.xhtml";
    private static final String _MIS_REPARACIONES = "misReparaciones.xhtml";
    private static final String _MIS_SOLICITUDES = "misSolicitudes.xhtml";

    // URLS para usuarios
    private static final String USUARIOS = "/usuarios/";
    private static final String INDEX_USUARIOS = USUARIOS + _INDEX;
    private static final String NEW_USUARIO = USUARIOS + _NEW;
    private static final String EDIT_USUARIO = USUARIOS + _EDIT;

    // URLS para categorias
    private static final String CATEGORIAS = "/categorias/";
    private static final String INDEX_CATEGORIAS = CATEGORIAS + _INDEX;
    private static final String NEW_CATEGORIA = CATEGORIAS + _NEW;
    private static final String EDIT_CATEGORIA = CATEGORIAS + _EDIT;

    // URLS para personas
    private static final String PERSONAS = "/personas/";
    private static final String INDEX_PERSONAS_ALL = PERSONAS + _INDEX;

    // URLS para clientes
    private static final String CLIENTES = "/personas/clientes/";
    private static final String INDEX_CLIENTES = CLIENTES + _INDEX;
    private static final String NEW_CLIENTE = CLIENTES + _NEW;
    private static final String EDIT_CLIENTE = CLIENTES + _EDIT;

    // URLS para empleados
    private static final String EMPLEADOS = "/personas/empleados/";
    private static final String INDEX_EMPLEADOS = EMPLEADOS + _INDEX;
    private static final String NEW_EMPLEADO = EMPLEADOS + _NEW;
    private static final String EDIT_EMPLEADO = EMPLEADOS + _EDIT;
    private static final String SUELDO_EMPLEADO = EMPLEADOS + _SUELDO;

    // URLS para proveedores
    private static final String PROVEEDORES = "/personas/proveedores/";
    private static final String INDEX_PROVEEDORES = PROVEEDORES + _INDEX;
    private static final String NEW_PROVEEDOR = PROVEEDORES + _NEW;
    private static final String EDIT_PROVEEDOR = PROVEEDORES + _EDIT;

    // URL para Reparaciones
    private static final String REPARACIONES = "/reparaciones/";
    private static final String INDEX_REPARACIONES = REPARACIONES + _INDEX;
    private static final String NEW_REPARACION = REPARACIONES + _NEW;
    private static final String EDIT_REPARACION = REPARACIONES + _EDIT;
    private static final String MIS_REPARACIONES = REPARACIONES + _MIS_REPARACIONES;

    // URL para Solicitudes Reparacion
    private static final String SOLICITUDES = "/solicitudes/";
    private static final String INDEX_SOLICITUDES = SOLICITUDES + _INDEX;
    private static final String NEW_SOLICITUD = SOLICITUDES + _NEW;
    private static final String EDIT_SOLICITUD = SOLICITUDES + _EDIT;
    private static final String DETAIL_SOLICITUD = SOLICITUDES + _DETAIL;
    private static final String MIS_SOLICITUDES = SOLICITUDES + _MIS_SOLICITUDES;

    // URL para Cotizaciones
    private static final String COTIZACIONES = "/cotizaciones/";
    private static final String INDEX_COTIZACIONES = COTIZACIONES + _INDEX;
    private static final String NEW_COTIZACION = COTIZACIONES + _NEW;
    private static final String EDIT_COTIZACION = COTIZACIONES + _EDIT;

    // URL para Productos
    private static final String PRODUCTOS = "/productos/";
    private static final String INDEX_PRODUCTOS = PRODUCTOS + _INDEX;
    private static final String NEW_PRODUCTO = PRODUCTOS + _NEW;
    private static final String EDIT_PRODUCTO = PRODUCTOS + _EDIT;

    private static final String FACES_REDIRECT = "?faces-redirect=true";

    public static String getINDEX() {
        return INDEX;
    }

    public static String getWELCOME() {
        return WELCOME;
    }

    public static String getIndexUsuarios() {
        return INDEX_USUARIOS;
    }

    public static String getNewUsuario() {
        return NEW_USUARIO;
    }

    public static String getEditUsuario() {
        return EDIT_USUARIO;
    }

    public static String getIndexCategorias() {
        return INDEX_CATEGORIAS;
    }

    public static String getNewCategoria() {
        return NEW_CATEGORIA;
    }

    public static String getEditCategoria() {
        return EDIT_CATEGORIA;
    }

    public static String getIndexPersonas() {
        return INDEX_PERSONAS_ALL;
    }

    public static String getIndexClientes() {
        return INDEX_CLIENTES;
    }

    public static String getNewCliente() {
        return NEW_CLIENTE;
    }

    public static String getEditCliente() {
        return EDIT_CLIENTE;
    }

    public static String getIndexEmpleados() {
        return INDEX_EMPLEADOS;
    }

    public static String getNewEmpleado() {
        return NEW_EMPLEADO;
    }

    public static String getEditEmpleado() {
        return EDIT_EMPLEADO;
    }
    
     public static String getSueldoEmpleado() {
        return SUELDO_EMPLEADO;
    }

    public static String getIndexProveedores() {
        return INDEX_PROVEEDORES;
    }

    public static String getNewProveedor() {
        return NEW_PROVEEDOR;
    }

    public static String getEditProveedor() {
        return EDIT_PROVEEDOR;
    }

    public static String getFacesRedirect() {
        return FACES_REDIRECT;
    }

    public static String getIndexReparaciones() {
        return INDEX_REPARACIONES;
    }

    public static String getNewReparacion() {
        return NEW_REPARACION;
    }

    public static String getEditReparacion() {
        return EDIT_REPARACION;
    }
    
    public static String getMisReparaciones(){
        return MIS_REPARACIONES;
    }

    public static String getMisSolicitudes(){
        return MIS_SOLICITUDES;
    }

    public static String getIndexSolicitudes() {
        return INDEX_SOLICITUDES;
    }

    public static String getNewSolicitud() {
        return NEW_SOLICITUD;
    }

    public static String getEditSolicitud() {
        return EDIT_SOLICITUD;
    }

    public static String getIndexCotizaciones() {
        return INDEX_COTIZACIONES;
    }

    public static String getNewCotizacion() {
        return NEW_COTIZACION;
    }

    public static String getEditCotizacion() {
        return EDIT_COTIZACION;
    }

    public static String getIndexProductos() {
        return INDEX_PRODUCTOS;
    }

    public static String getNewProducto() {
        return NEW_PRODUCTO;
    }

    public static String getEditProducto() {
        return EDIT_PRODUCTO;
    }

    public static String getDetailSolicitud() {
        return DETAIL_SOLICITUD;
    }
}
