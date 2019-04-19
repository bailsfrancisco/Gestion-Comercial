package ar.com.gestioncomercial.backing;


import ar.com.gestioncomercial.DAO.EmpleadoDAO;
import ar.com.gestioncomercial.controller.UsuarioController;
import ar.com.gestioncomercial.model.Usuario;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionBacking implements Serializable {

    private String nombreUsuario;
    private String password;

    private Usuario usuario = null;

    @EJB
    private UsuarioController usuarioController;

    @EJB
    private URLMap urlMap;
    
    @EJB
    private EmpleadoDAO empleadoDao;

    public String login(){
        usuario = usuarioController.findByNombreAndPassword(this.nombreUsuario, this.password);

        if (usuario!=null){
            return URLMap.getWELCOME() + URLMap.getFacesRedirect();
        }else{
            JSFUtils.createFacesMessage("Nombre de usuario y/o Contraseña incorrectos");
            return null;
        }
    }

    public String logout(){
        this.usuario = null;
        this.nombreUsuario = null;
        this.password = null;

        return URLMap.getINDEX() +  URLMap.getFacesRedirect();

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
