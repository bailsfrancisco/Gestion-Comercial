package ar.com.gestioncomercial.i18n;

import java.util.PropertyResourceBundle;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;


@RequestScoped
public class BundleProducer {
    @Produces
    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication()
                .evaluateExpressionGet(context, "#{i18n}",
                        PropertyResourceBundle.class);
    }
}