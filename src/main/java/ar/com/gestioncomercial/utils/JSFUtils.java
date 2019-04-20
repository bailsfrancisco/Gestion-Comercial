package ar.com.gestioncomercial.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class JSFUtils {


    public static void createFacesMessage(String message){
        FacesMessage facesMessage = new FacesMessage();
        facesMessage.setSummary(message);
        FacesContext facesContext= FacesContext.getCurrentInstance();
        facesContext.addMessage(null, facesMessage);
    }

    public static String getAbsoluteURL(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getRequestURL().toString().substring(0,request.getRequestURL().toString().lastIndexOf("/"));
    }

}
