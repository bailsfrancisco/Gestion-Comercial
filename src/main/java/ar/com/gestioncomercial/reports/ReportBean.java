/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.reports;

import ar.com.gestioncomercial.model.Reparacion;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 *
 * @author bailsfrancisco
 */

//@ManagedBean(name = "report")
//@ViewScoped
public class ReportBean {
    /*
    @PostConstruct
    public void init() {

    }

    //Here we make the method to create and download the report
    public void printPDF() throws JRException, IOException {
        //Now we can call to PDF method to download the report, first we need to do the datasource
        List<Reparacion> datasource = new ArrayList<>();
        datasource.add(new Reparacion());
        String filename = "orden_de_reparacion.pdf";
        //Params is a map object for params items, we not show that in this video
        String jasperPath = "/reportes/reporte-orden-reparacion.jasper";
        this.PDF(null, jasperPath, datasource, filename);
    }

    public void PDF(Map<String, Object> params, String jasperPath, List<?> dataSource, String fileName) throws JRException, IOException {
        String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
        File file = new File(relativeWebPath);
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(dataSource, false);
        JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, source);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment;filename=" + fileName);
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(print, stream);
        FacesContext.getCurrentInstance().responseComplete();
    }*/

}
