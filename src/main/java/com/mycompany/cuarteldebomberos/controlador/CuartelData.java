/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Cuartel;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author br1st
 */
public class CuartelData {
    // Me valgo de la clase util, para conectarme a la BD;
    private Connection conexion = null;

    public CuartelData() {
        this.conexion = Conexion.getConexion();
    }
    
    // CRUD de cuarteles:
    
    public Cuartel guardarCuartel(Cuartel cuartel) {
        String query = "INSERT INTO cuartel values(NULL,?,?,?,?,?,?)";
        try {                     
            PreparedStatement ps = conexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,cuartel.getNombre_cuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setInt(3, cuartel.getCoord_X());
            ps.setInt(4, cuartel.getCoord_Y());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                cuartel.setCodCuartel(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cuartel " + cuartel.toString() + "creado correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear cuartel");
        }
        return cuartel;
    }
    
    
}
