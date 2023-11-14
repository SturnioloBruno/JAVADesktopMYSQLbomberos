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

    public Cuartel() {
    }

    public Cuartel(String nombre_cuartel, String direccion, Integer coord_X, Integer coord_Y, String telefono, String correo, Set<Brigada> BrigadasDelCuartel) {
        this.nombre_cuartel = nombre_cuartel;
        this.direccion = direccion;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.telefono = telefono;
        this.correo = correo;
        this.BrigadasDelCuartel = BrigadasDelCuartel;
    }

    public Cuartel(Integer codCuartel, String nombre_cuartel, String direccion, Integer coord_X, Integer coord_Y, String telefono, String correo, Set<Brigada> BrigadasDelCuartel) {
        this.codCuartel = codCuartel;
        this.nombre_cuartel = nombre_cuartel;
        this.direccion = direccion;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.telefono = telefono;
        this.correo = correo;
        this.BrigadasDelCuartel = BrigadasDelCuartel;
    }

    
    public Integer getCodCuartel() {
        return codCuartel;
    }

    public void setCodCuartel(Integer codCuartel) {
        this.codCuartel = codCuartel;
    }

    public String getNombre_cuartel() {
        return nombre_cuartel;
    }

    public void setNombre_cuartel(String nombre_cuartel) {
        this.nombre_cuartel = nombre_cuartel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<Brigada> getBrigadasDelCuartel() {
        return BrigadasDelCuartel;
    }

    public void setBrigadasDelCuartel(Set<Brigada> BrigadasDelCuartel) {
        this.BrigadasDelCuartel = BrigadasDelCuartel;
    }

    @Override
    public String toString() {
        return "Cuartel{" + "codCuartel=" + codCuartel + ", nombre_cuartel=" + nombre_cuartel + ", direccion=" + direccion + ", coord_X=" + coord_X + ", coord_Y=" + coord_Y + ", telefono=" + telefono + ", correo=" + correo + ", BrigadasDelCuartel=" + BrigadasDelCuartel + '}';
    }
    
}
