/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.utils;

/**
 *
 * @author br1st
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static String url="jdbc:mariadb://localhost:3306/cuartelbomberos";
    private static String user="root";
    private static String pass="mysql";
    private static Connection con=null;
    
    private Conexion(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException cnte){
            JOptionPane.showMessageDialog(null, "Clase Driver no encontrada.");
        }
    }
    
    public static Connection getConexion(){
        if (con==null){
            try {
                con=DriverManager.getConnection(url,user,pass);
            } catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, "Error de conexion.");
            }
        }
        return con;
    }

}
