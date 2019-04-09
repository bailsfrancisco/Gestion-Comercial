package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.Image;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ImageDAO extends AbstractDAO<Image> {

    public ImageDAO(){ super(Image.class);}

    public List<Image> getAllImages() {
        return getAll();
    }

    @Override
    protected List<Image> getAll() {
        Query query = em.createNamedQuery("images.getAllImages");
        return query.getResultList();
    }
}
