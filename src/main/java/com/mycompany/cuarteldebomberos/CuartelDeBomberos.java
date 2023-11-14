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
import java.sql.Connection;
import java.time.LocalDate;

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

        CuartelData cd = new CuartelData();
        Cuartel cuartelBuscado = cd.buscarCuartelSegunNombre("polvorin");
        System.out.println(cuartelBuscado.toString());
        
        BrigadaData bd = new BrigadaData();
        Brigada brigadaBuscada = bd.buscarBrigadaSegunNombre("suicideSquad");
        System.out.println(brigadaBuscada.toString());
    }
}
