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
public class pedido extends conexion implements sentencia{
        int id_pedido, costo_estimado, estado_pedido;
        String fecha_inicial, fecha_final, desc_pedido;
        Statement query;

    public pedido() {
        
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setCosto_estimado(int costo_estimado) {
        this.costo_estimado = costo_estimado;
    }

    public void setEstado_pedido(int estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public void setDesc_pedido(String desc_pedido) {
        this.desc_pedido = desc_pedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public int getCosto_estimado() {
        return costo_estimado;
    }

    public int getEstado_pedido() {
        return estado_pedido;
    }

    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public String getDesc_pedido() {
        return desc_pedido;
    }
        
        public pedido(int id_pedido, String fecha_inicial, String fecha_final, int costo_estimado, String desc_pedido, int estado_pedido){
            this.id_pedido = id_pedido;
            this.fecha_inicial = fecha_inicial;
            this.fecha_final = fecha_final;
            this.costo_estimado = costo_estimado;
            this.desc_pedido = desc_pedido;
            this.estado_pedido = estado_pedido;
        }

    @Override
    public boolean insertar() {
         try {
            String sql = "INSERT INTO pedido VALUES(" + getId_pedido() + ",'" + getFecha_inicial() + "','" + getFecha_final() + "'," + getCosto_estimado() + ",'"+getDesc_pedido()+"','"+getEstado_pedido()+"')";
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
            String sql = "UPDATE pedido SET id_pedido=" + getId_pedido() + ", fecha_inicial='" + getFecha_inicial()+ "', fecha_final='" + getFecha_final() + "', costo_estimado=" + getCosto_estimado()+", desc_pedido='"+getDesc_pedido()+"', estado_pedido="+getEstado_pedido()+")";
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
        String sql = "DELETE FROM pedido WHERE id_pedido=" + getId_pedido();
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
        ArrayList<pedido> ped = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido";
            query = getCon().createStatement();
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()) {
                int Id_pedido = rs.getInt(1);
                String Fecha_inicial = rs.getString(2);
                String Fecha_final = rs.getString(3);
                int Costo_estimado = rs.getInt(4);
                String Desc_pedido = rs.getString(5);
                int Estado_pedido = rs.getInt(6);
                pedido p = new pedido(Id_pedido, Fecha_inicial, Fecha_final, Costo_estimado, Desc_pedido,Estado_pedido);
                ped.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ped;
    }
    
    
}
