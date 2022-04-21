/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iep.triunfo.matriculappbackend.util;

public class Util {

   //Tipo de Descuento
   public static final int TD_NINGUNO=1;
   public static final int TD_ALUMNO_DESTACADO=2;
   public static final int TD_FAMILIAR_ADMINISTRATIVO=3;
   public static final int TD_DEPORTISTA_CALIFICADO=4;
   public static final int TD_MUSICO_CALIFICADO=5;

  //Porcentaje de Descuento
   public static final double D_NINGUNO=0.0;
   public static final float D_ALUMNO_DESTACADO=1F;
   public static final float D_FAMILIAR_ADMINISTRATIVO=0.5F;
   public static final float D_DEPORTISTA_CALIFICADO=0.8F;
   public static final float D_MUSICO_CALIFICADO=0.6F;

    //Estados de la Programación Académica

    public static final int ESTADO_PROG_ACADEMICA_ABIERTO = 1;
    public static final int ESTADO_PROG_ACADEMICA_CERRADO = 2;
    public static final int ESTADO_PROG_ACADEMICA_ANULADO = 3;

    //Estados de la Matrícula

    public static final int ESTADO_MATRICULA_REGISTRADO = 1;
    public static final int ESTADO_MATRICULA_CERRADO = 2;
    public static final int ESTADO_MATRICULA_ANULADO = 3;

    //Estados del Cronograma

    public static final int ESTADO_CRONOGRAMA_REGISTRADO = 1;
    public static final int ESTADO_CRONOGRAMA_CERRADO = 2;
    public static final int ESTADO_CRONOGRAMA_ANULADO = 3;

    //TIPOS DE PAGO
    public static final int TIPO_PAGO_MATRICULA = 1;
    public static final int TIPO_PAGO_MENSUALIDAD = 2;
    public static final int TIPO_PAGO_OTROS = 3;

}
