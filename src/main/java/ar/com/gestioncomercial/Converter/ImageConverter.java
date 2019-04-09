package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.model.Image;

public class ImageConverter extends AbstractConverter<Image> {
    @Override
    public String getDAOName() {
        return "ImageDAO";
    }
}
