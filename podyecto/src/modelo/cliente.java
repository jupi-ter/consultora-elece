package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente extends conexion implements sentencia {
    private int id_empresa;
    private String nombre_empresa, dir_empresa, propietario_empresa, email_contacto, tel_contacto;
    Statement query;

    public cliente(int id_empresa, String nombre_empresa, String dir_empresa, String propietario_empresa, String email_contacto, String tel_contacto) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.dir_empresa = dir_empresa;
        this.propietario_empresa = propietario_empresa;
        this.email_contacto = email_contacto;
        this.tel_contacto = tel_contacto;
    }

    public cliente() {
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDir_empresa() {
        return dir_empresa;
    }

    public void setDir_empresa(String dir_empresa) {
        this.dir_empresa = dir_empresa;
    }

    public String getPropietario_empresa() {
        return propietario_empresa;
    }

    public void setPropietario_empresa(String propietario_empresa) {
        this.propietario_empresa = propietario_empresa;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }

    public String getTel_contacto() {
        return tel_contacto;
    }

    public void setTel_contacto(String tel_contacto) {
        this.tel_contacto = tel_contacto;
    }

    @Override
    public boolean insertar() {
        try {
            String sql = "INSERT INTO cliente VALUES(" + getId_empresa() + ",'" + getNombre_empresa() + "','" + getDir_empresa() + "','" + getPropietario_empresa() + "','" + getEmail_contacto() + "','" + getTel_contacto() + "')";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean modificar() {
        try {
            String sql = "UPDATE cliente SET nombre_empresa='" + getNombre_empresa() + "', dir_empresa='" + getDir_empresa() + "', propietario_empresa='" + getPropietario_empresa() + "', email_contacto='" + getEmail_contacto() + "', tel_contacto='" + getTel_contacto() + "' WHERE id_empresa=" + getId_empresa() + ";";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList consultar() {
        ArrayList<cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente";
            query = getCon().createStatement();
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String propietario = rs.getString(4);
                String email = rs.getString(5);
                String telefono = rs.getString(6);
                cliente c = new cliente(id, nombre, direccion, propietario, email, telefono);
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    @Override
    public boolean borrar() {
        try {
            String sql = "DELETE FROM cliente WHERE id_empresa=" + getId_empresa() + ";";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}