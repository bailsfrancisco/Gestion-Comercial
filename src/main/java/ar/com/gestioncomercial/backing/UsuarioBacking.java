package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.UsuarioController;
import ar.com.gestioncomercial.exception.NullOrEmptyException;
import ar.com.gestioncomercial.model.Usuario;
import ar.com.gestioncomercial.utils.StringUtils;
import ar.com.gestioncomercial.utils.URLMap;
import ar.com.gestioncomercial.utils.JSFUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;

@Named
@ViewScoped
public class UsuarioBacking implements Serializable, CRUDBacking<Usuario> {

    private static final Logger logger = Logger.getLogger(UsuarioBacking.class.getName());

    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        usuario.setFechaAlta(new Date());
    }

    @EJB
    private UsuarioController usuarioController;

    @Inject
    private SessionBacking sessionBacking;

    @EJB
    private URLMap urlMap;

    private List<Usuario> getUsers() {
        return usuarioController.getAll();
    }

    @Override
    public String create() {
        try {
            StringUtils.areNullOrEmpty(usuario.getNombreUsuario(),
                    usuario.getPassword());
            usuarioController.create(usuario);

            return URLMap.getIndexUsuarios() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());

        } catch (NullOrEmptyException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Campos: Nombre de usuario y Contraseña no pueden ser nulos");
        }
        return null;
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            usuarioController.update(usuario);
            return URLMap.getIndexReparaciones() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Usuario usuario) {
        if (!sessionBacking.getUsuario().equals(usuario)) {
            usuarioController.delete(usuario);
        } else {
            JSFUtils.createFacesMessage("No te podes borrar a vos mismo!");
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
