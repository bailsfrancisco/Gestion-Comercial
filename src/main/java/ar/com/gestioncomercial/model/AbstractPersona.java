package ar.com.gestioncomercial.model;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipo_persona",
        discriminatorType = DiscriminatorType.STRING
)
@NamedQueries({
    @NamedQuery(
            name = "persona.getAll",
            query = "select p from AbstractPersona p")
})
public abstract class AbstractPersona extends AbstractEntity {

    private String nombre;

    private String telefono;

    private String mail;

    private String direccion;

    private String cuitCuil;

    private String observaciones;

    private String celular;

    @OneToOne
    private Usuario usuario;

    public AbstractPersona() {

    }

    public AbstractPersona(String nombre, String telefono, String mail, String direccion, String cuitCuil, String observaciones, String celular) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = direccion;
        this.cuitCuil = cuitCuil;
        this.observaciones = observaciones;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuitCuil() {
        return cuitCuil;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
