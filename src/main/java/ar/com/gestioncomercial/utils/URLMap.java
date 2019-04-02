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

    // URLS para proveedores
    private static final String PROVEEDORES = "/personas/proveedores/";
    private static final String INDEX_PROVEEDORES = PROVEEDORES + _INDEX;
    private static final String NEW_PROVEEDOR = PROVEEDORES + _NEW;
    private static final String EDIT_PROVEEDOR = PROVEEDORES + _EDIT;

    private static final String FACES_REDIRECT = "?faces-redirect=true";

    public static String getINDEX() {
        return INDEX;
    }

    public static String  getWELCOME() {
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

}
