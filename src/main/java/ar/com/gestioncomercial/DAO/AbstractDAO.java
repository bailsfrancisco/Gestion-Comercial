package ar.com.gestioncomercial.DAO;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author bailsfrancisco
 * @param <T>
 */
public abstract class AbstractDAO<T> {

    private final Class<T> typeParameter;

    @PersistenceContext(unitName = "PU")
    protected EntityManager em;

    public AbstractDAO(Class<T> type) {
        this.typeParameter = type;
    }

    public void create(T t) throws EJBException {
        em.persist(t);
    }

    public void update(T t) throws EJBException {
        em.merge(t);
    }

    public void delete(T t) throws EJBException {
        em.remove(em.contains(t) ? t : em.merge(t));
    }

    public T find(Long id) {
        return em.find(typeParameter, id);
    }

    public void flush() {
        em.flush();
    }

    public void refresh(T t) {
        em.refresh(t);
    }

    protected abstract List<T> getAll();
}
