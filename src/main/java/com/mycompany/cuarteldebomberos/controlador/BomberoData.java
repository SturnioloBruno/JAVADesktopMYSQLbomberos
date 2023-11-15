/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Bombero;
import com.mycompany.cuarteldebomberos.modelo.Brigada;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author br1st
 */
public class BomberoData {
    
    // Me valgo de la clase util, para conectarme a la BD;
    private Connection conexion = null;
    private BrigadaData bd = new BrigadaData();

    public BomberoData() {
        this.conexion = Conexion.getConexion();
    }
    
    // CRUD de bomberos:
    
    public Bombero guardarBomberoSinBrigada(Bombero bombero){
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
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear bombero. \n Asegurese de que el DNI no este repetido");
        }
        return bombero;
    }
    
    
    public Bombero asignarBomberoABrigadaConNombre(Bombero bombero, String nombreBrigada) {
        // Primero verifico que la brigada con ese nombre existe y recupero su PK
        Brigada brigada = bd.buscarBrigadaSegunNombre(nombreBrigada);
        if(brigada == null){
            JOptionPane.showMessageDialog(null, "No puedes asignar un bombero a una brigada que no existe");
            return bombero;
        }
        
        // Segundo verifico que el bombero existe y no tenga una brigada ya asignada,ademas le llamo bomberoC, porque este conoce su PK
        Bombero bomberoC = this.buscarBomberoSegunNombre(bombero.getNombre_ape());
        if(bomberoC != null && bomberoC.getFKcodBrigada() == null){// se encontro un bombero con ese nombre, y sin brigada asignada
            bomberoC.setFKcodBrigada(brigada.getCodBrigada());
            // y ahora actualizo mi bombero en la BD con ese FK
            String query = "UPDATE bombero set codBrigada=" + bomberoC.getFKcodBrigada() + " WHERE id_bombero=" + bomberoC.getId_bombero();
            try{
                Statement statement = conexion.createStatement();
                int filasAfectadas = statement.executeUpdate(query);
                if(filasAfectadas == 1) {
                    JOptionPane.showMessageDialog(null, "bombero actualizado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "No hubo un error, pero el query afecto a varios bomberos o a ninguno");
                }
                statement.close();
            }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar bombero");
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "no se encontro el bombero, o ya tenia una brigada asignada");
        }
        return bomberoC;
    }
    
    public Bombero buscarBomberoSegunNombre(String nombreCompleto) {
        Bombero respuesta = new Bombero();
        String query = "SELECT * FROM bombero WHERE nombre_ape LIKE '" + nombreCompleto + "'";
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                respuesta.setId_bombero(rs.getInt(1));
                respuesta.setDni(rs.getString(2));
                respuesta.setNombre_ape(rs.getString(3));
                respuesta.setGrupo_sanguineo(rs.getString(4));
                respuesta.setFecha_nac(rs.getDate(5).toLocalDate());
                respuesta.setCelular(rs.getString(6));
                respuesta.setActivo(rs.getBoolean(7));
                respuesta.setFKcodBrigada((Integer)rs.getObject(8));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro un bombero con ese nombre");
            }
            statement.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al buscar bombero con nombre: " + nombreCompleto);
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public Bombero buscarBomberoPorCod(Integer cod) {
        Bombero respuesta = new Bombero();
        String query = "SELECT * FROM bombero WHERE id_bombero=" + cod;
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                respuesta.setId_bombero(rs.getInt(1));
                respuesta.setDni(rs.getString(2));
                respuesta.setNombre_ape(rs.getString(3));
                respuesta.setGrupo_sanguineo(rs.getString(4));
                respuesta.setFecha_nac(rs.getDate(5).toLocalDate());
                respuesta.setCelular(rs.getString(6));
                respuesta.setActivo(rs.getBoolean(7));
                respuesta.setFKcodBrigada((Integer)rs.getObject(8));
            }else{
                JOptionPane.showMessageDialog(null, "No existe un bombero con codigo: " + cod);
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar bombero con codigo: " + cod);
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public List<Bombero> listarTodosLosBomberos() {
        List<Bombero> bomberos = new ArrayList<>();
        String query = "SELECT * FROM bombero";
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                Bombero bombero = new Bombero();
                bombero.setId_bombero(rs.getInt(1));
                bombero.setDni(rs.getString(2));
                bombero.setNombre_ape(rs.getString(3));
                bombero.setGrupo_sanguineo(rs.getString(4));
                bombero.setFecha_nac(rs.getDate(5).toLocalDate());
                bombero.setCelular(rs.getString(6));
                bombero.setActivo(rs.getBoolean(7));
                bombero.setFKcodBrigada((Integer)rs.getObject(8));
                
                bomberos.add(bombero);
            }
            statement.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return bomberos;
    }
    
    public Boolean darDeBajaBomberoConDNI(String dni) {
        Boolean respuesta = false;
        String query = "UPDATE bombero SET activo=0 WHERE dni LIKE '" + dni + "'";
        try{
            Statement statement = conexion.createStatement();
            int filasAfectadas = statement.executeUpdate(query);
                if(filasAfectadas == 1) {
                    respuesta = true;
                    JOptionPane.showMessageDialog(null, "bombero actualizado con exito");
                }
        }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar bombero");
        }
        return respuesta;
    } 
    
}
