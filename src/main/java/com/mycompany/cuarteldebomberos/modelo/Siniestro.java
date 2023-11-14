/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.modelo;

import java.time.LocalDate;

/**
 *
 * @author br1st
 */
public class Siniestro {
    private Integer codigo;
    private TipoIncidente tipo;
    private LocalDate fecha_siniestro;
    private Integer coord_X;
    private Integer coord_Y;
    private String detalles;
    private LocalDate fecha_resol;
    private Integer puntuacion;
    private Integer FKcodBrigada;
}
