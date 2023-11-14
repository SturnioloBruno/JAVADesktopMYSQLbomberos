/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Bombero;
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
public class BomberoData {
    
    // Me valgo de la clase util, para conectarme a la BD;
    private Connection conexion = null;

    public BomberoData() {
        this.conexion = Conexion.getConexion();
    }
    
    // CRUD de bomberos:
    
    public Bombero crearBomberoSinBrigada(Bombero bombero){
        String query = "INSERT INTO bombero(dni,nombre_ape,grupo_sanguineo,fecha_nac,celular,activo) VALUES (?,?,?,?,?,?)";
        try{
            // Primero seteo los valores que recibo por parametro en mi query
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,bombero.getDni());
            ps.setString(2, bombero.getNombre_ape());
            ps.setString(3,bombero.getGrupo_sanguineo());
            ps.setDate(4, Date.valueOf(bombero.getFecha_nac()));
            ps.setString(5, bombero.getCelular());
            ps.setBoolean(6, bombero.getActivo().booleanValue());
            
            // ejecuto y Guardo la respuesta que recibo de mysql para recuperar la PK:
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                bombero.setId_bombero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Bombero: " + bombero.toString() + "creado correctamente");
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear bombero. \n Asegurese de que el DNI no este repetido");
        }
        return bombero;
    }
    
    
}
