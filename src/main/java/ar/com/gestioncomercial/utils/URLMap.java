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

    // URLS para objetivos
    private static final String OBJETIVOS = "/objetivos/";
    private static final String INDEX_OBJETIVOS = OBJETIVOS +_INDEX;
    private static final String NEW_OBJETIVO = OBJETIVOS + _NEW;
    private static final String EDIT_OBJETIVO = OBJETIVOS + "edit.xhtml";
    private static final String DETAIL_OBJETIVO = OBJETIVOS + "details.xhtml";

    private static final String ACTIVIDADES = "/actividades/";
    private static final String INDEX_ACTIVIDADES_ALL = ACTIVIDADES + _INDEX;

    // URLS para Actividades Simples
    private static final String ACTIVIDADES_SIMPLES = "/actividades/simples/";
    private static final String INDEX_ACTIVIDADES = ACTIVIDADES_SIMPLES + _INDEX;
    private static final String NEW_ACTIVIDAD = ACTIVIDADES_SIMPLES + _NEW;
    private static final String EDIT_ACTIVIDAD = ACTIVIDADES_SIMPLES + _EDIT;
    private static final String DETAIL_ACTIVIDAD = ACTIVIDADES_SIMPLES + _DETAIL;

    // URLS para Actividades Compuestas
    private static final String ACTIVIDADES_COMPUESTAS = "/actividades/compuestas/";
    private static final String INDEX_ACTIVIDADES_COMPUESTAS = ACTIVIDADES_COMPUESTAS + _INDEX;
    private static final String NEW_ACTIVIDAD_COMPUESTA = ACTIVIDADES_COMPUESTAS + _NEW;
    private static final String EDIT_ACTIVIDAD_COMPUESTA = ACTIVIDADES_COMPUESTAS + _EDIT;
    private static final String DETAIL_ACTIVIDAD_COMPUESTA = ACTIVIDADES_COMPUESTAS + _DETAIL;

    // URLS para usuarios
    private static final String USUARIOS = "/usuarios/";
    private static final String INDEX_USUARIOS = USUARIOS + _INDEX;
    private static final String NEW_USUARIO = USUARIOS + _NEW;
    private static final String EDIT_USUARIO = USUARIOS + _EDIT;
    private static final String DETAIL_USUARIO = USUARIOS + _DETAIL;

    // URL para convocatorias
    private static final String CONVOCATORIAS = "/convocatorias/";
    private static final String INDEX_CONVOCATORIAS = CONVOCATORIAS + _INDEX;
    private static final String NEW_CONVOCATORIA = CONVOCATORIAS + _NEW;
    private static final String EDIT_CONVOCATORIA = CONVOCATORIAS + _EDIT;
    private static final String DETAIL_CONVOCATORIA  = CONVOCATORIAS + _DETAIL;

    // URL para LineasEstrategicas

    private static final String LINEAS_ESTRATEGICAS = "/lineasestrategicas/";
    private static final String INDEX_LINEAS_ESTRATEGICAS = LINEAS_ESTRATEGICAS + _INDEX;
    private static final String NEW_LINEA_ESTRATEGICA = LINEAS_ESTRATEGICAS + _NEW;
    private static final String EDIT_LINEA_ESTRATEGICA = LINEAS_ESTRATEGICAS + _EDIT;
    private static final String DETAIL_LINEA_ESTRATEGICA = LINEAS_ESTRATEGICAS + _DETAIL;

    // URL para Ambito
    private static final String AMBITO = "/ambitos/";
    private static final String INDEX_AMBITOS = AMBITO + _INDEX;
    private static final String NEW_AMBITO =  AMBITO + _NEW;
    private static final String EDIT_AMBITO = AMBITO + _EDIT;
    private static final String DETAIL_AMBITO = AMBITO + _DETAIL;

    private static final String OBJETIVO_REPORTE = "/objetivoreporte.xhtml";





    private static final String FACES_REDIRECT = "?faces-redirect=true";

    public String getINDEX() {
        return INDEX;
    }

    public String getWELCOME() {
        return WELCOME;
    }

    public String getIndexObjetivos() {
        return INDEX_OBJETIVOS;
    }

    public String getNewObjetivo() {
        return NEW_OBJETIVO;
    }

    public String getEditObjetivo() {
        return EDIT_OBJETIVO;
    }

    public String getDetailObjetivo() {
        return DETAIL_OBJETIVO;
    }

    public static String getIndexActividades() {
        return INDEX_ACTIVIDADES;
    }

    public String getNewActividad() {
        return NEW_ACTIVIDAD;
    }

    public String getEditActividad() {
        return EDIT_ACTIVIDAD;
    }

    public String getDetailActividad() {
        return DETAIL_ACTIVIDAD;
    }

    public String getIndexUsuarios() {
        return INDEX_USUARIOS;
    }

    public String getNewUsuario() {
        return NEW_USUARIO;
    }

    public String getEditUsuario() {
        return EDIT_USUARIO;
    }

    public String getDetailUsuario() {
        return DETAIL_USUARIO;
    }

    public static String getFacesRedirect() {
        return FACES_REDIRECT;
    }


    public static String getNewConvocatoria() {
        return NEW_CONVOCATORIA;
    }

    public static String getEditConvocatoria() {
        return EDIT_CONVOCATORIA;
    }

    public static String getDetailConvocatoria() {
        return DETAIL_CONVOCATORIA;
    }

    public static String getIndexConvocatorias() {
        return INDEX_CONVOCATORIAS;
    }

    public static String getIndexLineasEstrategicas() {
        return INDEX_LINEAS_ESTRATEGICAS;
    }

    public static String getNewLineaEstrategica() {
        return NEW_LINEA_ESTRATEGICA;
    }

    public static String getEditLineaEstrategica() {
        return EDIT_LINEA_ESTRATEGICA;
    }

    public static String getDetailLineaEstrategica() {
        return DETAIL_LINEA_ESTRATEGICA;
    }

    public static String getIndexAmbitos() {
        return INDEX_AMBITOS;
    }

    public static String getNewAmbito() {
        return NEW_AMBITO;
    }

    public static String getEditAmbito() {
        return EDIT_AMBITO;
    }

    public static String getDetailAmbito() {
        return DETAIL_AMBITO;
    }

    public static String getIndexActividadesCompuestas() {
        return INDEX_ACTIVIDADES_COMPUESTAS;
    }

    public static String getNewActividadCompuesta() {
        return NEW_ACTIVIDAD_COMPUESTA;
    }

    public static String getEditActividadCompuesta() {
        return EDIT_ACTIVIDAD_COMPUESTA;
    }

    public static String getDetailActividadCompuesta() {
        return DETAIL_ACTIVIDAD_COMPUESTA;
    }

    public static String getIndexActividadesAll() {
        return INDEX_ACTIVIDADES_ALL;
    }

    public static String getObjetivoReporte() {
        return OBJETIVO_REPORTE;
    }
}
