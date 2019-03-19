/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpgm
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.auth;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthorizationListener implements PhaseListener {

  @Override
  public void afterPhase(PhaseEvent event) {
    FacesContext facesContext = event.getFacesContext();
    String currentPage = facesContext.getViewRoot().getViewId();
    
  }
  
  @Override
  public void beforePhase(PhaseEvent event) {
  }

  @Override
  public PhaseId getPhaseId() {
    return PhaseId.RESTORE_VIEW;
  }
}
