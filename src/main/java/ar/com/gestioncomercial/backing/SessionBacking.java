/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.DAO.UsuarioDAO;
import ar.com.gestioncomercial.model.Cliente;
import ar.com.gestioncomercial.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bailsfrancisco
 */
@ManagedBean
@SessionScoped
public class SessionBacking implements Serializable {

    private String email;
    private String password;

    private Usuario usuario;
    private Cliente cliente;

    @EJB
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
    }

    public String login_admin() {
        usuario = usuarioDAO.login(email, password);
        if (usuario == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("¡¡¡ Email o contraseña incorrectos !!!");
            context.addMessage(null, message);
            return null;
        }
        return "template?faces-redirect=true";
    }

    public String logout() {
        usuario = null;
        return "index_login?faces-redirect=true";
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
