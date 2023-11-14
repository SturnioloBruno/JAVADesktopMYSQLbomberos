/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuarteldebomberos;

import com.mycompany.cuarteldebomberos.controlador.BomberoData;
import com.mycompany.cuarteldebomberos.modelo.Bombero;
import com.mycompany.cuarteldebomberos.utils.Conexion;
import java.sql.Connection;
import java.time.LocalDate;

/**
 *
 * @author br1st
 */
public class CuartelDeBomberos {

    public static void main(String[] args) {
        BomberoData bd = new BomberoData();
        Bombero bomberoAGuardarSinBrigada = new Bombero("36046044", "Sturniolo Bruno", "0+", LocalDate.now(), "2665039175", true, null);
        bd.crearBomberoSinBrigada(bomberoAGuardarSinBrigada);
    }
}
