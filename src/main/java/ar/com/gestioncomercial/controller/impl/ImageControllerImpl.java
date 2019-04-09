package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ImageDAO;
import ar.com.gestioncomercial.controller.ImageController;
import ar.com.gestioncomercial.model.Image;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ImageControllerImpl implements ImageController {

    @EJB
    private ImageDAO imageDAO;

    @Override
    public void create(Image entity) {
        imageDAO.create(entity);
    }

    @Override
    public Image retrieve(Image entity) {
        return imageDAO.find(entity.getId());
    }

    @Override
    public Image retrievebyId(Long id) {
        return imageDAO.find(id);
    }

    @Override
    public void update(Image entity) {
        imageDAO.update(entity);
    }

    @Override
    public void delete(Image entity) {
        imageDAO.delete(entity);
    }

    @Override
    public List<Image> getAll() {
        return imageDAO.getAllImages();
    }
}
