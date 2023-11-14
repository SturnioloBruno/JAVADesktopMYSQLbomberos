/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.cuarteldebomberos.modelo;

/**
 *
 * @author br1st
 */
public enum TipoIncidente {
    INCENDIOS_EN_VIVIENDAS_E_INDUSTRIAS(1),
    SALVAMENTO_EN_DERRUMBES(2),
    RESCATES_EN_AMBITO_MONTAGNA(3),
    RESCATE_DE_PERSONAS_ATRAPADAS_EN_ACCIDENTES_DE_TRAFICO(4),
    SOCORRER_INUNDACIONES(5),
    OPERATIVOS_DE_PREVENCION(6);

    private final int alias;

    TipoIncidente(int alias) {
        this.alias = alias;
    }

    public int getAlias() {
        return alias;
    }
}

