/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuarteldebomberos;

import com.mycompany.cuarteldebomberos.controlador.BomberoData;
import com.mycompany.cuarteldebomberos.controlador.BrigadaData;
import com.mycompany.cuarteldebomberos.controlador.CuartelData;
import com.mycompany.cuarteldebomberos.controlador.SiniestroData;
import com.mycompany.cuarteldebomberos.modelo.Bombero;
import com.mycompany.cuarteldebomberos.modelo.Brigada;
import com.mycompany.cuarteldebomberos.modelo.Cuartel;
import com.mycompany.cuarteldebomberos.modelo.Siniestro;
import com.mycompany.cuarteldebomberos.modelo.TipoIncidente;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import com.mycompany.cuarteldebomberos.utils.Punto;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author br1st
 */
public class CuartelDeBomberos {

    public static void main(String[] args) {
//        BomberoData bd = new BomberoData();
//        Bombero bomberoAGuardarSinBrigada = new Bombero("36046044", "Sturniolo Bruno", "0+", LocalDate.now(), "2665039175", true, null);
//        bd.crearBomberoSinBrigada(bomberoAGuardarSinBrigada);

//          CuartelData cd = new CuartelData();
//          Cuartel cuartelSinBrigadas = new Cuartel("polvorin", "CuchiCorral", 13, 92, "039175", "@polvorin", null);
//          cd.crearCuartel(cuartelSinBrigadas);

//            BrigadaData bd = new BrigadaData();
//            Brigada brigadaSinCuartelSinBomberosYSinSiniestros = new Brigada("suicideSquad", TipoIncidente.INCENDIOS_EN_VIVIENDAS_E_INDUSTRIAS, true, null, null, null);
//            bd.guardarBrigadaSinCuartel(brigadaSinCuartelSinBomberosYSinSiniestros);

//        SiniestroData sd = new SiniestroData();
//        Siniestro siniestroSinAsignarAGuardar = new Siniestro(TipoIncidente.SOCORRER_INUNDACIONES, LocalDate.now(), 13, 92, "esto es una inundacion en una casa \n los habitantes ya han sido evacuados", null, null, null);
//        sd.guardarSiniestroSinAsignar(siniestroSinAsignarAGuardar);

//        CuartelData cd = new CuartelData();
//        Cuartel cuartelBuscado = cd.buscarCuartelSegunNombre("polvorin");
//        System.out.println(cuartelBuscado.toString());
//        
//        BrigadaData bd = new BrigadaData();
//        Brigada brigadaBuscada = bd.buscarBrigadaSegunNombre("suicideSquad");
//        bd.asignarBrigadaAlCuartelConNombre(brigadaBuscada, "polvorin");

//        BrigadaData bd = new BrigadaData();
//        List<Brigada> todasMisBrigadas = bd.listarTodasLasBrigadas();
//        for (Brigada brigada : todasMisBrigadas) {
//            System.out.println(brigada.toString());
//        }

//        CuartelData cd = new CuartelData();
//        List<Cuartel> todosMisCuarteles = cd.listarTodosLosCuarteles();
//        for(Cuartel cuartel:todosMisCuarteles){
//            System.out.println(cuartel.toString());
//        }

//        CuartelData cd = new CuartelData();
//        Cuartel cuartelActualizado = new Cuartel("sinBrigadas", "siempreViva", 13, 92, "039175", "@polvorin", null);
//        cd.actualizarCuartel(cuartelActualizado, 1);
        
//        BrigadaData bd = new BrigadaData();
//        System.out.println(bd.buscarBrigadaPorCod(1).toString());
        
//        BomberoData bd = new BomberoData();
//        Bombero yo = bd.buscarBomberoPorCod(2);
//        System.out.println(yo.toString());
//        bd.asignarBomberoABrigadaConNombre(yo, "suicideSquad");
//        List<Bombero> bomberos = bd.listarTodosLosBomberos();
//        for(Bombero bombero: bomberos){
//            System.out.println(bombero.toString());
//        }
//        bd.darDeBajaBomberoConDNI("36046044");

//        SiniestroData sd = new SiniestroData();
//        LocalDate fecha = LocalDate.of(2023, 11, 14);
//        TipoIncidente tipo = TipoIncidente.SOCORRER_INUNDACIONES;
//        Siniestro sin = sd.buscarSiniestroPorFechaYTipo(fecha, tipo);
//        System.out.println(sin.toString());
//        sd.asignarSiniestroABrigadaConNombre(sin, "suicideSquad");
//        List<Siniestro> siniestros = sd.listarTodosLosSiniestros();
//        for(Siniestro sin: siniestros){
//            System.out.println(sin.toString());
//        }
//        SiniestroData sd = new SiniestroData();
//        LocalDate fecha = LocalDate.of(2023, 11, 14);
//        TipoIncidente tipo = TipoIncidente.SOCORRER_INUNDACIONES;
//        Siniestro sinAActualizar = sd.buscarSiniestroPorCod(1);
//        Siniestro sinYaActualizado = new Siniestro(TipoIncidente.SALVAMENTO_EN_DERRUMBES, LocalDate.now(), 1, 1, "ahora esta resuelto .si lo cambie de verdad \n por completo, o casi\nlos habitantes ya han sido evacuados", LocalDate.now().plusDays(1), 10, null);
//        sd.actualizarOResolverSiniestro(sinAActualizar, sinYaActualizado);

        CuartelData cd = new CuartelData();
        System.out.println(cd.devolverCuartelEnPunto(new Punto(13,92)));
    }
}
