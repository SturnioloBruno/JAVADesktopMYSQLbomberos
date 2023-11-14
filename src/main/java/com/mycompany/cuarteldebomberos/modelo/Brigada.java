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
public class Brigada {
    private Integer codBrigada;
    private String nombre_br;
    private TipoIncidente especialidad;
    private Boolean libre;
    private Integer FKnro_cuartel;
    private Set<Bombero> bomberosEnLaBrigada;
    private Set<Siniestro> listaSiniestrosAsignados;
}
