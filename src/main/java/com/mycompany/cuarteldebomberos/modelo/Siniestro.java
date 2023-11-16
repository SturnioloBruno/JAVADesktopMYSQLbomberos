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

    public Siniestro() {
    }

    public Siniestro(TipoIncidente tipo, LocalDate fecha_siniestro, Integer coord_X, Integer coord_Y, String detalles, LocalDate fecha_resol, Integer puntuacion, Integer FKcodBrigada) {
        this.tipo = tipo;
        this.fecha_siniestro = fecha_siniestro;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.detalles = detalles;
        this.fecha_resol = fecha_resol;
        this.puntuacion = puntuacion;
        this.FKcodBrigada = FKcodBrigada;
    }

    public Siniestro(Integer codigo, TipoIncidente tipo, LocalDate fecha_siniestro, Integer coord_X, Integer coord_Y, String detalles, LocalDate fecha_resol, Integer puntuacion, Integer FKcodBrigada) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fecha_siniestro = fecha_siniestro;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.detalles = detalles;
        this.fecha_resol = fecha_resol;
        this.puntuacion = puntuacion;
        this.FKcodBrigada = FKcodBrigada;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoIncidente getTipo() {
        return tipo;
    }

    public void setTipo(TipoIncidente tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha_siniestro() {
        return fecha_siniestro;
    }

    public void setFecha_siniestro(LocalDate fecha_siniestro) {
        this.fecha_siniestro = fecha_siniestro;
    }

    public Integer getCoord_X() {
        return coord_X;
    }

    public void setCoord_X(Integer coord_X) {
        this.coord_X = coord_X;
    }

    public Integer getCoord_Y() {
        return coord_Y;
    }

    public void setCoord_Y(Integer coord_Y) {
        this.coord_Y = coord_Y;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getFecha_resol() {
        return fecha_resol;
    }

    public void setFecha_resol(LocalDate fecha_resol) {
        this.fecha_resol = fecha_resol;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getFKcodBrigada() {
        return FKcodBrigada;
    }

    public void setFKcodBrigada(Integer FKcodBrigada) {
        this.FKcodBrigada = FKcodBrigada;
    }

    @Override
    public String toString() {
        return tipo + ", fecha_siniestro=" + fecha_siniestro;
    }
    
}
