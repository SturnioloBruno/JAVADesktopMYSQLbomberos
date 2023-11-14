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

    public Bombero() {
    }

    public Bombero(String dni, String nombre_ape, String grupo_sanguineo, LocalDate fecha_nac, String celular, Boolean activo, Integer FKcodBrigada) {
        this.dni = dni;
        this.nombre_ape = nombre_ape;
        this.grupo_sanguineo = grupo_sanguineo;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.activo = activo;
        this.FKcodBrigada = FKcodBrigada;
    }

    public Bombero(Integer id_bombero, String dni, String nombre_ape, String grupo_sanguineo, LocalDate fecha_nac, String celular, Boolean activo, Integer FKcodBrigada) {
        this.id_bombero = id_bombero;
        this.dni = dni;
        this.nombre_ape = nombre_ape;
        this.grupo_sanguineo = grupo_sanguineo;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.activo = activo;
        this.FKcodBrigada = FKcodBrigada;
    }
    

    public Integer getId_bombero() {
        return id_bombero;
    }

    public void setId_bombero(Integer id_bombero) {
        this.id_bombero = id_bombero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_ape() {
        return nombre_ape;
    }

    public void setNombre_ape(String nombre_ape) {
        this.nombre_ape = nombre_ape;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getFKcodBrigada() {
        return FKcodBrigada;
    }

    public void setFKcodBrigada(Integer FKcodBrigada) {
        this.FKcodBrigada = FKcodBrigada;
    }

    @Override
    public String toString() {
        return "Bombero{" + "id_bombero=" + id_bombero + ", dni=" + dni + ", nombre_ape=" + nombre_ape + ", grupo_sanguineo=" + grupo_sanguineo + ", fecha_nac=" + fecha_nac + ", celular=" + celular + ", activo=" + activo + ", FKcodBrigada=" + FKcodBrigada + '}';
    }
    
}
