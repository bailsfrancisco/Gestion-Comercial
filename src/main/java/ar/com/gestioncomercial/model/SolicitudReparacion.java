package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.util.List;

//TODO: AMPLIAR
@Entity
@Table(name = "solicitud_reparacion")
@NamedQueries({
    @NamedQuery(
            name = "solicitudReparacion.getAllSolicitudes",
            query = "select s from SolicitudReparacion s")
    ,
    @NamedQuery(
            name = "solicitudReparacion.getSolicitudPorCliente",
            query = "select s from SolicitudReparacion s")
})
public class SolicitudReparacion extends AbstractEntity {

    private String marca;
    private String modelo;
    private String sintomas;
    private String descripcionFallo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private AbstractPersona cliente;

    private Estado estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
    private List<Image> fileNames;

    public SolicitudReparacion() {

    }

    public SolicitudReparacion(String descripcionFallo, Cliente cliente) {
        this.descripcionFallo = descripcionFallo;
        this.cliente = cliente;
    }

    public String getDescripcionFallo() {
        return descripcionFallo;
    }

    public void setDescripcionFallo(String descripcionFallo) {
        this.descripcionFallo = descripcionFallo;
    }

    public AbstractPersona getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCliente(AbstractPersona cliente) {
        this.cliente = cliente;
    }

    public List<Image> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<Image> fileNames) {
        this.fileNames = fileNames;
    }

    public void addFileName(Image fileName) {
        this.fileNames.add(fileName);
    }

    public void removeFileName(Image fileName) {
        this.fileNames.remove(fileName);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

}
