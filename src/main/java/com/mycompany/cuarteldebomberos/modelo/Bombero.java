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
public class Bombero {
    private Integer id_bombero;
    private String dni;
    private String nombre_ape;
    private String grupo_sanguineo;
    private LocalDate fecha_nac;
    private String celular;
    private Boolean activo;
    private Integer FKcodBrigada;
}
