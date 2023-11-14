/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Siniestro;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author br1st
 */
public class SiniestroData {
    // Me valgo de la clase util, para conectarme a la BD;
    private Connection conexion = null;

    public SiniestroData() {
        this.conexion = Conexion.getConexion();
    }
    
    // CRUD de siniestro:
    
    public Siniestro guardarSiniestroSinAsignar(Siniestro siniestro) {
        String query = "INSERT INTO siniestro values(NULL,?,?,?,?,?,NULL,NULL,NULL)";
        try{
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,siniestro.getTipo().toString());
            ps.setDate(2, Date.valueOf(siniestro.getFecha_siniestro()));
            ps.setInt(3, siniestro.getCoord_X());
            ps.setInt(4, siniestro.getCoord_Y());
            ps.setString(5, siniestro.getDetalles());
            
            // ejecuto y Guardo la respuesta que recibo de mysql para recuperar la PK:
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                siniestro.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Siniestro: " + siniestro.toString() + " guardado con exito");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar siniestro");
            ex.printStackTrace();
        }
        return siniestro;
    }
    
}
