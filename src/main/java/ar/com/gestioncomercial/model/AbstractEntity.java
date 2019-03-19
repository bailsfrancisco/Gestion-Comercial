package ar.com.gestioncomercial.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
