package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servicios extends conexion implements sentencia {
    private int id, costo;
    private String nombre, descripcion;
    private Statement query;

    public servicios(int id, int costo, String nombre, String descripcion) {
        this.id = id;
        this.costo = costo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public servicios() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public int getCosto() {
        return costo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean insertar() {
        try {
            String sql = "INSERT INTO servicio VALUES(" + getId() + ",'" + getNombre() + "','" + getDescripcion() + "'," + getCosto() + ")";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean modificar() {
        try {
            String sql = "UPDATE servicio SET id_servicio=" + getId() + ", nombre_servicio='" + getNombre() + "', desc_servicio='" + getDescripcion() + "', costo_sevicio=" + getCosto() +  " WHERE id_servicio=" + getId() + ";";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<servicios> consultar() {
        ArrayList<servicios> serv = new ArrayList<>();
        try {
            String sql = "SELECT * FROM servicio";
            query = getCon().createStatement();
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String nomb = rs.getString(2);
                String desc = rs.getString(3);
                int cost = rs.getInt(4);
                servicios s = new servicios(Id, cost, nomb, desc);
                serv.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serv;
    }

    @Override
    public boolean borrar() {
        try {
            String sql = "DELETE FROM servicio WHERE id_servicio=" + getId();
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
