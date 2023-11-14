/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuarteldebomberos;

import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;

/**
 *
 * @author br1st
 */
public class CuartelDeBomberos {

    public static void main(String[] args) {
        System.out.println("Probando conexion:");
        Connection con = Conexion.getConexion();
    }
}
