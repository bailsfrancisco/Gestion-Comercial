package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.DAO.UsuarioDAO;
import ar.com.gestioncomercial.model.Usuario;
import ar.com.gestioncomercial.utils.URLMap;
import ar.com.gestioncomercial.utils.JSFUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJBException;

@Named
@ViewScoped
public class UsuarioBacking implements Serializable, CRUDBacking<Usuario> {

    private Usuario usuario;

    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
    }

    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private URLMap urlMap;

    @Inject
    private SessionBacking sessionBacking;

    private List<Usuario> getUsers(){
        return usuarioDAO.getAllUsers();
    }

    @Override
    public String create(){
        try{
            usuarioDAO.create(usuario);
            return urlMap.getIndexUsuarios() + URLMap.getFacesRedirect();
        }catch(EJBException e){
            return null;
        }
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update(){
        try{
            usuarioDAO.update(usuario);
            return urlMap.getIndexUsuarios() + URLMap.getFacesRedirect();
        }catch(Exception e){
            return null;
        }
    }


    public void delete(Usuario usuario){
        if(!sessionBacking.getUsuario().equals(usuario)){
            usuarioDAO.delete(usuario);
        }else{
            JSFUtils.createFacesMessage("No te podes borrar a vos mismo!!!");
        }

    }

    @Override
    public List<Usuario> getAll() {
        return getUsers();
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }


    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
