package ar.com.gestioncomercial.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(
            name = "Usuario.findByNombreAndPassword",
            query = "select u from Usuario u where u.nombreUsuario = :nombreUsuario and u.password = :password"
    )
    ,
    @NamedQuery(
            name = "Usuario.getAll",
            query = "select u from Usuario u")
    ,
    @NamedQuery(
            name = "Usuario.getByPersona",
            query = "select u from Usuario u where u.duenio = :persona")
    ,
})
public class Usuario extends AbstractEntity {

    @Column(name = "nombreUsuario"/*, unique = true*/)
    private String nombreUsuario;

    @Column(name = "password")
    private String password;

    @Column(name = "administrador")
    private boolean administrador;

    @OneToOne(mappedBy = "usuario")
    private AbstractPersona duenio;

    public Usuario() {

    }

    public Usuario(String nombreUsuario, String password, boolean administrador) {

        this.nombreUsuario = nombreUsuario;

        this.password = password;

        this.administrador = administrador;
      
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AbstractPersona getDuenio() {
        return duenio;
    }

    public void setDuenio(AbstractPersona duenio) {
        this.duenio = duenio;
    }
}
