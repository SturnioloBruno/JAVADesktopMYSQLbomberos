/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.modelo;

import java.util.Set;

/**
 *
 * @author br1st
 */
public class Cuartel {
    private Integer codCuartel;
    private String nombre_cuartel;
    private String direccion;
    private Integer coord_X;
    private Integer coord_Y;
    private String telefono;
    private String correo;
    private Set<Brigada> BrigadasDelCuartel;
}
