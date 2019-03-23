package ar.com.gestioncomercial.controller;


import ar.com.gestioncomercial.model.Usuario;
import ar.com.gestioncomercial.DAO.UsuarioDAO;
import ar.com.gestioncomercial.utils.URLMap;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionBacking implements Serializable {



    private String email;
    private String password;

    private Usuario usuario = null;

    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private URLMap urlMap;

    public String login(){
        usuario = usuarioDAO.findByEmailAndPassword(this.email, this.password);

        return (usuario!=null) ? urlMap.getWELCOME() + URLMap.getFacesRedirect() : null;
    }

    public String logout(){
        this.usuario = null;
        this.email = null;
        this.password = null;

        return urlMap.getINDEX() +  URLMap.getFacesRedirect();

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
