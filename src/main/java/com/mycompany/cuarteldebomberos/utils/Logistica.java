/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuarteldebomberos.utils;

import com.mycompany.cuarteldebomberos.controlador.CuartelData;
import com.mycompany.cuarteldebomberos.controlador.SiniestroData;
import com.mycompany.cuarteldebomberos.modelo.Cuartel;
import com.mycompany.cuarteldebomberos.modelo.Siniestro;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author br1st
 */
public class Logistica {
    private List<Punto> puntosQRepresentanCuarteles=new ArrayList<>();
    private List<Punto> puntosQRepresentanSiniestros=new ArrayList<>();
    private SiniestroData sd = new SiniestroData();
    private CuartelData cd = new CuartelData();
    
    public Double medirDistanciaEntreDosPuntos(Punto punto1, Punto punto2) {
        // Obtiene las coordenadas de los puntos
        int cordx1 = punto1.getCoordx();
        int cordy1 = punto1.getCoordy();
        int cordx2 = punto2.getCoordx();
        int cordy2 = punto2.getCoordy();

        // Calcula la distancia euclidiana
        double distancia = Math.sqrt(Math.pow(cordx2 - cordx1, 2) + Math.pow(cordy2 - cordy1, 2));

        return distancia;
    }
    
    public List<Punto> cargarPuntosAPartirDeLosSiniestrosSinResolver() {
        List<Siniestro> siniestros = sd.listarTodosLosSiniestros();
        List<Punto> puntos = new ArrayList<>();
        for(Siniestro sin: siniestros){
            if(sin.getFecha_resol() == null) {
                Punto punto = new Punto(sin.getCoord_X(), sin.getCoord_Y());
                puntos.add(punto);
            }
        }
        return puntos;        
    }
    
    public List<Punto> cargarPuntosAPartirDeLosCuarteles() {
        List<Cuartel> cuarteles = cd.listarTodosLosCuarteles();
        List<Punto> puntos = new ArrayList<>();
        for(Cuartel cuartel:cuarteles){
            Punto punto = new Punto(cuartel.getCoord_X(), cuartel.getCoord_Y());
            puntos.add(punto);
        }
        return puntos;
    }
    
    
    public SortedMap<Double, Punto> listarDistanciasOrdenadasAlPunto(Punto puntoOrigen, TipoPunto tipo) {
        SortedMap<Double, Punto> distanciasOrdenadasDeMenorAMayor = new TreeMap<>();
        switch (tipo) {
            case CUARTEL -> {
                // Lógica para calcular distancias a siniestros a partir del dado CUARTEL
                puntosQRepresentanSiniestros = cargarPuntosAPartirDeLosSiniestrosSinResolver();
                for (Punto p : puntosQRepresentanSiniestros) {
                    Double distancia = medirDistanciaEntreDosPuntos(puntoOrigen, p);
                    distanciasOrdenadasDeMenorAMayor.put(distancia, p);
                }
                return distanciasOrdenadasDeMenorAMayor;
            }

            case SINIESTRO -> {
                // Logica para calcular distancias a cuarteles a partir del dado SINIESTRO
                puntosQRepresentanCuarteles = cargarPuntosAPartirDeLosCuarteles();
                for (Punto p : puntosQRepresentanCuarteles) {
                    Double distancia = medirDistanciaEntreDosPuntos(puntoOrigen, p);
                    distanciasOrdenadasDeMenorAMayor.put(distancia, p);
                }
                return distanciasOrdenadasDeMenorAMayor;
            }

            default -> {
                System.out.println("Tipo de punto incorrecto");
                return distanciasOrdenadasDeMenorAMayor;
            }
        }
    }
    
}
