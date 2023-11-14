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

    public Brigada() {
    }

    public Brigada(String nombre_br, TipoIncidente especialidad, Boolean libre, Integer FKnro_cuartel, Set<Bombero> bomberosEnLaBrigada, Set<Siniestro> listaSiniestrosAsignados) {
        this.nombre_br = nombre_br;
        this.especialidad = especialidad;
        this.libre = libre;
        this.FKnro_cuartel = FKnro_cuartel;
        this.bomberosEnLaBrigada = bomberosEnLaBrigada;
        this.listaSiniestrosAsignados = listaSiniestrosAsignados;
    }

    public Brigada(Integer codBrigada, String nombre_br, TipoIncidente especialidad, Boolean libre, Integer FKnro_cuartel, Set<Bombero> bomberosEnLaBrigada, Set<Siniestro> listaSiniestrosAsignados) {
        this.codBrigada = codBrigada;
        this.nombre_br = nombre_br;
        this.especialidad = especialidad;
        this.libre = libre;
        this.FKnro_cuartel = FKnro_cuartel;
        this.bomberosEnLaBrigada = bomberosEnLaBrigada;
        this.listaSiniestrosAsignados = listaSiniestrosAsignados;
    }
    

    public Integer getCodBrigada() {
        return codBrigada;
    }

    public void setCodBrigada(Integer codBrigada) {
        this.codBrigada = codBrigada;
    }

    public String getNombre_br() {
        return nombre_br;
    }

    public void setNombre_br(String nombre_br) {
        this.nombre_br = nombre_br;
    }

    public TipoIncidente getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(TipoIncidente especialidad) {
        this.especialidad = especialidad;
    }

    public Boolean getLibre() {
        return libre;
    }

    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

    public Integer getFKnro_cuartel() {
        return FKnro_cuartel;
    }

    public void setFKnro_cuartel(Integer FKnro_cuartel) {
        this.FKnro_cuartel = FKnro_cuartel;
    }

    public Set<Bombero> getBomberosEnLaBrigada() {
        return bomberosEnLaBrigada;
    }

    public void setBomberosEnLaBrigada(Set<Bombero> bomberosEnLaBrigada) {
        this.bomberosEnLaBrigada = bomberosEnLaBrigada;
    }

    public Set<Siniestro> getListaSiniestrosAsignados() {
        return listaSiniestrosAsignados;
    }

    public void setListaSiniestrosAsignados(Set<Siniestro> listaSiniestrosAsignados) {
        this.listaSiniestrosAsignados = listaSiniestrosAsignados;
    }

    @Override
    public String toString() {
        return "Brigada{" + "codBrigada=" + codBrigada + ", nombre_br=" + nombre_br + ", especialidad=" + especialidad + ", libre=" + libre + ", FKnro_cuartel=" + FKnro_cuartel + ", bomberosEnLaBrigada=" + bomberosEnLaBrigada + ", listaSiniestrosAsignados=" + listaSiniestrosAsignados + '}';
    }
    
}
