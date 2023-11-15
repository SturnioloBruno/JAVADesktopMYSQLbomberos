/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Brigada;
import com.mycompany.cuarteldebomberos.modelo.Siniestro;
import com.mycompany.cuarteldebomberos.modelo.TipoIncidente;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author br1st
 */
public class SiniestroData {
    // Me valgo de la clase util, para conectarme a la BD;
    private Connection conexion = null;
    private BrigadaData bd = new BrigadaData();

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
    
    public Siniestro asignarSiniestroABrigadaConNombre(Siniestro siniestro, String nombreBrigada){
        Brigada brigada = bd.buscarBrigadaSegunNombre(nombreBrigada);
        if(brigada == null){
            JOptionPane.showMessageDialog(null, "No puedes asignar un bombero a una brigada que no existe");
            return siniestro;
        }
        
        // Segundo verifico que el siniestro existe y no tenga una brigada ya asignada,ademas le llamo siniestroC, porque este conoce su PK
        Siniestro siniestroC = this.buscarSiniestroPorFechaYTipo(siniestro.getFecha_siniestro(), siniestro.getTipo());
        if(siniestroC != null && siniestroC.getFKcodBrigada() == null){ // se encontro un siniestro sin brigada asignada
            siniestroC.setFKcodBrigada(brigada.getCodBrigada());
            // y ahora actualizo mi siniestro en la BD con la FK de la brigada asignada
            String query = "UPDATE siniestro set codBrigada=" + siniestroC.getFKcodBrigada() + " WHERE codigo=" + siniestroC.getCodigo();
            try{
                Statement statement = conexion.createStatement();
                int filasAfectadas = statement.executeUpdate(query);
                if(filasAfectadas == 1) {
                    JOptionPane.showMessageDialog(null, "siniestro actualizado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "No hubo un error, pero el query afecto a varios siniestros o a ninguno");
                }
                statement.close();
            }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar siniestro");
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "no se encontro el siniestro, o ya tenia una brigada asignada");
        }
        return siniestroC;
    }
    
    public Siniestro buscarSiniestroPorFechaYTipo(LocalDate fecha, TipoIncidente tipo) {
    Siniestro respuesta = new Siniestro();
    String query = "SELECT * FROM siniestro WHERE fecha_siniestro = ? AND tipo = ?";
    
    try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setDate(1, java.sql.Date.valueOf(fecha));
        preparedStatement.setString(2, tipo.toString());

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            respuesta.setCodigo(rs.getInt(1));
            respuesta.setTipo(TipoIncidente.valueOf(rs.getString(2)));
            respuesta.setFecha_siniestro(rs.getDate(3).toLocalDate());
            respuesta.setCoord_X(rs.getInt(4));
            respuesta.setCoord_Y(rs.getInt(5));
            respuesta.setDetalles(rs.getString(6));
            if (rs.getDate(7) != null) {
                respuesta.setFecha_resol(rs.getDate(7).toLocalDate());
            } else {
                respuesta.setFecha_resol(null);
            }

            respuesta.setPuntuacion((Integer) rs.getObject(8));
            respuesta.setFKcodBrigada((Integer) rs.getObject(9));

        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el siniestro con esas caracteristicas");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar siniestro");
            ex.printStackTrace();
    }

    return respuesta;
}

    
    
    
    public Siniestro buscarSiniestroPorCod(Integer cod){
        Siniestro respuesta = new Siniestro();
        String query = "SELECT * FROM siniestro WHERE codigo=" + cod;
        
        try {
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                respuesta.setCodigo(rs.getInt(1));
                respuesta.setTipo(TipoIncidente.valueOf(rs.getString(2)));
                respuesta.setFecha_siniestro(rs.getDate(3).toLocalDate());
                respuesta.setCoord_X(rs.getInt(4));
                respuesta.setCoord_Y(rs.getInt(5));
                respuesta.setDetalles(rs.getString(6));
                if(rs.getDate(7) != null){
                    respuesta.setFecha_resol(rs.getDate(7).toLocalDate());
                }else{
                    respuesta.setFecha_resol(null);
                }
                
                respuesta.setPuntuacion((Integer)rs.getObject(8));
                respuesta.setFKcodBrigada((Integer) rs.getObject(9));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el siniestro con codigo " + cod);
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar siniestro con codigo: " + cod);
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public List<Siniestro> listarTodosLosSiniestros() {
        List<Siniestro> siniestros = new ArrayList<>();
        String query = "SELECT * FROM siniestro";
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Siniestro siniestro = new Siniestro();
                siniestro.setCodigo(rs.getInt(1));
                siniestro.setTipo(TipoIncidente.valueOf(rs.getString(2)));
                siniestro.setFecha_siniestro(rs.getDate(3).toLocalDate());
                siniestro.setCoord_X(rs.getInt(4));
                siniestro.setCoord_Y(rs.getInt(5));
                siniestro.setDetalles(rs.getString(6));
                if (rs.getDate(7) != null) {
                    siniestro.setFecha_resol(rs.getDate(7).toLocalDate());
                } else {
                    siniestro.setFecha_resol(null);
                }

                siniestro.setPuntuacion((Integer) rs.getObject(8));
                siniestro.setFKcodBrigada((Integer) rs.getObject(9));
                
                siniestros.add(siniestro);
            }
            statement.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return siniestros;
    }
    
    public Siniestro actualizarOResolverSiniestro(Siniestro siniestroAActualizar, Siniestro siniestro) {
        Siniestro siniestroC = this.buscarSiniestroPorFechaYTipo(siniestroAActualizar.getFecha_siniestro(), siniestroAActualizar.getTipo());
        String query = "UPDATE siniestro SET tipo=?, fecha_siniestro=?, coord_X=?, coord_Y=?, detalles=?, fecha_resol=?, puntuacion=? WHERE codigo=?";
        
        // me fijo si se encontro el siniestro que se quiere actualizar:
        if(siniestroC == null){
            JOptionPane.showMessageDialog(null, "No se encontro un siniestro con fecha: " + siniestro.getFecha_siniestro() + " y tipo: " + siniestro.getTipo().toString());
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el siniestro: " + siniestroAActualizar.toString());
            return siniestro;
        }
        // preparo mi sentencia
        try{
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, siniestro.getTipo().toString());
            ps.setDate(2, Date.valueOf(siniestro.getFecha_siniestro()));
            ps.setInt(3, siniestro.getCoord_X());
            ps.setInt(4, siniestro.getCoord_Y());
            ps.setString(5, siniestro.getDetalles());
            if(siniestro.getFecha_resol() != null){
                ps.setDate(6,Date.valueOf(siniestro.getFecha_resol()));
            }else{
                ps.setObject(6, null);
            }
            
            ps.setObject(7, (Integer)siniestro.getPuntuacion());
            
            // seteo el codigo del que recupero de la BD:
            ps.setInt(8, siniestroC.getCodigo());
            
            // ejecuto
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas == 1){
                JOptionPane.showMessageDialog(null, "siniestro actualizado con exito");
            }else{
                JOptionPane.showMessageDialog(null, "no se actulizo ningun registro, o varios");
            }
            
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar siniestro");
            ex.printStackTrace();
        }
        return siniestro;
    }
}
