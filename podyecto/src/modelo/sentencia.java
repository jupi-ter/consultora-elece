/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author TERCEROS TM
 */
public interface sentencia {
    boolean insertar();
    boolean modificar();
    boolean borrar();
    ArrayList consultar();
}
