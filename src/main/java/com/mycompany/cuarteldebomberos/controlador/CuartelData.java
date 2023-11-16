/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Cuartel;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import com.mycompany.cuarteldebomberos.utils.Punto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public Cuartel buscarPorCodCuartel(Integer cod){
        String query = "SELECT * FROM cuartel WHERE codCuartel=" + cod;
        Cuartel respuesta = new Cuartel();
        try{
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                respuesta.setCodCuartel(rs.getInt(1));
                respuesta.setNombre_cuartel(rs.getString(2));
                respuesta.setDireccion(rs.getString(3));
                respuesta.setCoord_X(rs.getInt(4));
                respuesta.setCoord_Y(rs.getInt(5));
                respuesta.setTelefono(rs.getString(6));
                respuesta.setCorreo(rs.getString(7));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al buscar cuartel con cod: " + cod);
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public Cuartel buscarCuartelSegunNombre(String nombre) {
        Cuartel respuesta = new Cuartel();
        String query = "SELECT * FROM cuartel WHERE nombre_cuartel LIKE '" + nombre + "'";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                respuesta.setCodCuartel(rs.getInt(1));
                respuesta.setNombre_cuartel(rs.getString(2));
                respuesta.setDireccion(rs.getString(3));
                respuesta.setCoord_X(rs.getInt(4));
                respuesta.setCoord_Y(rs.getInt(5));
                respuesta.setTelefono(rs.getString(6));
                respuesta.setCorreo(rs.getString(7));
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar cuartel con nombre: " + nombre);
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public List<Cuartel> listarTodosLosCuarteles() {
        List<Cuartel> cuarteles = new ArrayList<>();
        String query = "SELECT * FROM cuartel";
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Cuartel cuartel = new Cuartel();
                cuartel.setCodCuartel(rs.getInt(1));
                cuartel.setNombre_cuartel(rs.getString(2));
                cuartel.setDireccion(rs.getString(3));
                cuartel.setCoord_X(rs.getInt(4));
                cuartel.setCoord_Y(rs.getInt(5));
                cuartel.setTelefono(rs.getString(6));
                cuartel.setCorreo(rs.getString(7));
                
                cuarteles.add(cuartel);
            }
            statement.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return cuarteles;
    }
    
    public Cuartel devolverCuartelEnPunto(Punto punto){
        int coordX = punto.getCoordx();
        int coordY = punto.getCoordy();
        Cuartel respuesta = new Cuartel();
        String query = "SELECT * FROM cuartel WHERE coord_X = ? AND coord_Y = ?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, coordX);
            ps.setInt(2,coordY);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                respuesta.setCodCuartel(rs.getInt(1));
                respuesta.setNombre_cuartel(rs.getString(2));
                respuesta.setDireccion(rs.getString(3));
                respuesta.setCoord_X(rs.getInt(4));
                respuesta.setCoord_Y(rs.getInt(5));
                respuesta.setTelefono(rs.getString(6));
                respuesta.setCorreo(rs.getString(7));
            }
            ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return respuesta;       
    }
    
    public void actualizarCuartel(Cuartel cuartel, Integer codigo){
        String query = "UPDATE cuartel SET nombre_cuartel=?,direccion=?,coord_X=?,coord_Y=?,telefono=?,correo=? WHERE codCuartel=" + codigo;
        try{
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, cuartel.getNombre_cuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setInt(3, cuartel.getCoord_X());
            ps.setInt(4, cuartel.getCoord_Y());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            
            if(ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel Actualizado con exito");
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
