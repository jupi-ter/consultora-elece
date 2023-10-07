package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class funcionario extends conexion implements sentencia {
    private int id_funcionario;
    private String nombre_funcionario, ci_especialista, profesion_funcionario, especialidad_funcionario, tel_especialista, email_funcionario;
    Statement query;

    public funcionario(int id_funcionario, String nombre_funcionario, String ci_especialista, String profesion_funcionario, String especialidad_funcionario, String tel_especialista, String email_funcionario) {
        this.id_funcionario = id_funcionario;
        this.nombre_funcionario = nombre_funcionario;
        this.ci_especialista = ci_especialista;
        this.profesion_funcionario = profesion_funcionario;
        this.especialidad_funcionario = especialidad_funcionario;
        this.tel_especialista = tel_especialista;
        this.email_funcionario = email_funcionario;
    }

    public funcionario() {
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNombre_funcionario() {
        return nombre_funcionario;
    }

    public void setNombre_funcionario(String nombre_funcionario) {
        this.nombre_funcionario = nombre_funcionario;
    }

    public String getCi_especialista() {
        return ci_especialista;
    }

    public void setCi_especialista(String ci_especialista) {
        this.ci_especialista = ci_especialista;
    }

    public String getProfesion_funcionario() {
        return profesion_funcionario;
    }

    public void setProfesion_funcionario(String profesion_funcionario) {
        this.profesion_funcionario = profesion_funcionario;
    }

    public String getEspecialidad_funcionario() {
        return especialidad_funcionario;
    }

    public void setEspecialidad_funcionario(String especialidad_funcionario) {
        this.especialidad_funcionario = especialidad_funcionario;
    }

    public String getTel_especialista() {
        return tel_especialista;
    }

    public void setTel_especialista(String tel_especialista) {
        this.tel_especialista = tel_especialista;
    }

    public String getEmail_funcionario() {
        return email_funcionario;
    }

    public void setEmail_funcionario(String email_funcionario) {
        this.email_funcionario = email_funcionario;
    }

    @Override
    public boolean insertar() {
        try {
            String sql = "INSERT INTO funcionario VALUES(" + getId_funcionario() + ",'" + getNombre_funcionario() + "','" + getCi_especialista() + "','" + getProfesion_funcionario() + "','" + getEspecialidad_funcionario() + "','" + getTel_especialista() + "','" + getEmail_funcionario() + "')";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(funcionario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean modificar() {
        try {
            String sql = "UPDATE funcionario SET nombre_funcionario='" + getNombre_funcionario() + "', ci_especialista='" + getCi_especialista() + "', profesion_funcionario='" + getProfesion_funcionario() + "', especialidad_funcionario='" + getEspecialidad_funcionario() + "', tel_especialista='" + getTel_especialista() + "', email_funcionario='" + getEmail_funcionario() + "' WHERE id_funcionario=" + getId_funcionario() + ";";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(funcionario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList consultar() {
        ArrayList<funcionario> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM funcionario";
            query = getCon().createStatement();
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String ci = rs.getString(3);
                String profesion = rs.getString(4);
                String especialidad = rs.getString(5);
                String telefono = rs.getString(6);
                String email = rs.getString(7);
                funcionario f = new funcionario(id, nombre, ci, profesion, especialidad, telefono, email);
                funcionarios.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    @Override
    public boolean borrar() {
        try {
            String sql = "DELETE FROM funcionario WHERE id_funcionario=" + getId_funcionario() + ";";
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(funcionario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
