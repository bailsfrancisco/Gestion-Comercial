package ar.com.gestioncomercial.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtils {


    public static void createFacesMessage(String message){
        FacesMessage facesMessage = new FacesMessage();
        facesMessage.setSummary(message);
        FacesContext facesContext= FacesContext.getCurrentInstance();
        facesContext.addMessage(null, facesMessage);
    }

}
