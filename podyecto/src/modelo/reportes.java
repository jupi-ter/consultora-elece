package modelo;

import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class reportes extends conexion {
    public reportes() {
    }
    
    public void generarReporte(String ubicacion, String titulo) {
        try {
            HashMap parametro =  new HashMap();
            parametro.put("","");
            URL direccion = getClass().getClassLoader().getResource(ubicacion);
            JasperReport jr = (JasperReport) JRLoader.loadObject(direccion);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, getCon());
            JasperViewer ventana = new JasperViewer(jp,false);
            ventana.setTitle(titulo);
            ventana.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generarReporteParametro(String ubicacion, String titulo, String nombreParametro, String valorParametro){
        try {
            HashMap parametro =  new HashMap();
            parametro.put(nombreParametro,valorParametro);
            URL direccion = getClass().getClassLoader().getResource(ubicacion);
            JasperReport jr = (JasperReport) JRLoader.loadObject(direccion);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, getCon());
            JasperViewer ventana = new JasperViewer(jp,false);
            ventana.setTitle(titulo);
            ventana.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}