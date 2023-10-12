/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabrizio
 */
public class detalle_pedido extends conexion implements sentencia {
    int id_pedido,id_funcionario,id_empresa,id_servicio,cant_pedida;
    Statement query;
    public detalle_pedido(int id_pedido,int id_funcionario,int id_empresa,int id_servicio,int cant_pedida){
        this.cant_pedida=cant_pedida;
        this.id_empresa=id_empresa;
        this.id_funcionario=id_funcionario;
        this.id_pedido=id_pedido;
        this.id_servicio=id_servicio;
    }
    public detalle_pedido(){

    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public void setCant_pedida(int cant_pedida) {
        this.cant_pedida = cant_pedida;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public int getCant_pedida() {
        return cant_pedida;
    }

    @Override
    public boolean insertar() {
    try {
        String sql = "INSERT INTO detalle_pedido VALUES(" + getId_funcionario() + "," + getId_pedido() + "," + getId_empresa() + "," + getId_servicio() + "," + getCant_pedida() + ")";
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
        String sql = "UPDATE detalle_pedido SET id_funcionario=" + getId_funcionario() + ", id_pedido=" + getId_pedido()+ ", id_empresa=" + getId_empresa() + ", id_servicio=" + getId_servicio() + ", cant_pedida=" + getCant_pedida();
        query = getCon().createStatement();
        query.executeUpdate(sql);
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}


    @Override
    public boolean borrar() {
        try {
            String sql = "DELETE FROM detalle_pedido WHERE id_pedido=" + getId_pedido();
            query = getCon().createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList consultar() {
      ArrayList<detalle_pedido> det_ped = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detalle_pedido";
            query = getCon().createStatement();
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()) {
                int Id_funcionario = rs.getInt(1);
                int Id_pedido = rs.getInt(2);
                int Id_servicio = rs.getInt(3);
                int Id_empresa = rs.getInt(4);
                int Cant_pedida = rs.getInt(5);
                detalle_pedido dp = new detalle_pedido(Id_pedido, Id_funcionario, Id_empresa, Id_servicio, Cant_pedida);
                det_ped.add(dp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return det_ped;
    }
    
}
