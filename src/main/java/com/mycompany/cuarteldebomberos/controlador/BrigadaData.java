/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.controlador;

import com.mycompany.cuarteldebomberos.modelo.Bombero;
import com.mycompany.cuarteldebomberos.modelo.Brigada;
import com.mycompany.cuarteldebomberos.modelo.Cuartel;
import com.mycompany.cuarteldebomberos.modelo.TipoIncidente;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author br1st
 */
public class BrigadaData {
    // Me valgo de la clase util, para conectarme a la BD;
    private Connection conexion = null;
    private CuartelData cd= new CuartelData();

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
    
    public Brigada asignarBrigadaAlCuartelConNombre(Brigada brigada, String nombreCuartel){
        // Primero traigo la brigada de la BD para verificar que existe, y recuperar su PK
        Brigada brigadaC = this.buscarBrigadaSegunNombre(brigada.getNombre_br());
        
        if(brigadaC != null && brigadaC.getFKnro_cuartel() == null){ // se encontro una brigada con ese nombre            
            // traigo de la BD el cuartel y recupero el codigo de la FK para Brigada
            Cuartel cuartel = cd.buscarCuartelSegunNombre(nombreCuartel);
            if(cuartel == null){
                JOptionPane.showMessageDialog(null, "No puedes asignar una brigada a un cuartel que no existe, revisa el nombre del cuartel");
                return brigada;
            }
            
            // duda existencial, el modelo de cuartel no deberia de preocuparme por actualizarlo ahora?
            Set<Brigada> listaBrigadas = new HashSet<>();
            listaBrigadas.add(brigada);
            cuartel.setBrigadasDelCuartel(listaBrigadas);
            
            // seteo la FK en mi modelo brigada
            brigada.setFKnro_cuartel(cuartel.getCodCuartel());
            // actualizo mi BD, deberia actualizar cuartel? mi modelo tiene una coleccion de brigadas, pero la BD de cuartel no
            String query = "UPDATE brigada SET nro_cuartel=" + brigada.getFKnro_cuartel() + " WHERE codBrigada=" + brigadaC.getCodBrigada();
            try{
                 Statement statement = conexion.createStatement();
                 statement.executeUpdate(query);
                 statement.close();
            }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar brigada");
            }
            JOptionPane.showMessageDialog(null, "brigada " + brigadaC.getNombre_br() + " asignada al cuartel " + nombreCuartel);
        }else{
            JOptionPane.showMessageDialog(null, "No puedes asignar una brigada que no existe o ya asignada a un cuartel, revisa el nombre de la brigada");
        }
        
        return brigadaC;
    }
    
    public Brigada buscarBrigadaSegunNombre(String nombre) {
        Brigada respuesta = new Brigada();
        String query = "SELECT * FROM brigada WHERE nombre_br LIKE '" + nombre + "'";

        try{
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                respuesta.setCodBrigada(rs.getInt(1));
                respuesta.setNombre_br(rs.getString(2));
                respuesta.setEspecialidad(TipoIncidente.valueOf(rs.getString(3)));
                respuesta.setLibre(rs.getBoolean(4));
                // Para asignar el cuartel al cual pertenece esta brigada, tengo primero que construirlo con ayuda de CuartelData
                Cuartel cuartelAlQuePerteneceLaBrigada = cd.buscarPorCodCuartel(rs.getInt(5));
                respuesta.setFKnro_cuartel(cuartelAlQuePerteneceLaBrigada.getCodCuartel());
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al bucar brigada con nombre: " + nombre);
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public List<Brigada> listarTodasLasBrigadas() {
        List<Brigada> brigadas = new ArrayList<>();
        String query = "SELECT * FROM brigada";
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Brigada brigada = new Brigada();
                brigada.setCodBrigada(rs.getInt(1));
                brigada.setNombre_br(rs.getString(2));
                brigada.setEspecialidad(TipoIncidente.valueOf(rs.getString(3)));
                brigada.setLibre(rs.getBoolean(4));
                brigada.setFKnro_cuartel(rs.getInt(5));
                
                brigadas.add(brigada);
            }
            statement.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return brigadas;
    }
    
}
