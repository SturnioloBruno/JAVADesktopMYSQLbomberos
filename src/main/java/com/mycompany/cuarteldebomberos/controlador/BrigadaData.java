/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Brigada;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author br1st
 */
public class BrigadaData {
    // Me valgo de la clase util, para conectarme a la BD;
    private Connection conexion = null;

    public BrigadaData() {
        this.conexion = Conexion.getConexion();
    }
    
    // CRUD de brigada:
    
    public Brigada guardarBrigadaSinCuartel(Brigada brigada){
        String query = "INSERT INTO brigada values(NULL,?,?,?,NULL)";
        try{
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,brigada.getNombre_br());
            ps.setString(2, brigada.getEspecialidad().toString());
            ps.setBoolean(3, brigada.getLibre());
            
            // ejecuto y Guardo la respuesta que recibo de mysql para recuperar la PK:
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                brigada.setCodBrigada(1);
                JOptionPane.showMessageDialog(null, "Brigada: " + brigada.toString() + " guardada con exito");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar brigada");
        }
        return brigada;
    }
    
    
}
