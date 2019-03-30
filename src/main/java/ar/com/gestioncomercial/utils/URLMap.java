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
    private static final String EDIT_CATEGORIA = CATEGORIAS + "edit.xhtml";

    private static final String FACES_REDIRECT = "?faces-redirect=true";

    public String getINDEX() {
        return INDEX;
    }

    public String getWELCOME() {
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

    public static String getFacesRedirect() {
        return FACES_REDIRECT;
    }

}
