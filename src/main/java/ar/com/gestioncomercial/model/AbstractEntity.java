package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fechaAlta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        } else if (!(obj instanceof AbstractEntity)) {
            return false;

        } else if (((AbstractEntity) obj).id == null) {
            return super.equals(obj);

        } else if (((AbstractEntity) obj).id.equals(this.id)) {
            return true;

        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "AbstractEntity{" + "id=" + id + '}';
    }
}
