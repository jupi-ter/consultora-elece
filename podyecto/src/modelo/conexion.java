package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TERCEROS TM
 */
public class conexion {
    
    private String base;
    private String usuario;
    private String contra;
    private String host;
    private Connection con;

    public conexion(String base, String usuario, String contra, String host) {
        this.base = base;
        this.usuario = usuario;
        this.contra = contra;
        this.host = host;
    }
    public conexion() {
        this.base = "elece";
        this.usuario = "root";
        this.contra = "";
        this.host = "localhost" ;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Connection getCon() {
        try {
            String url="jdbc:mysql://"+host+"/"+base;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,contra);
            //JOptionPane.showMessageDialog(null,"Conectado");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
   
}