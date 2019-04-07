package main;

import ambiente.Ambiente;
import componentes.calentador.Calentador;
import componentes.calentador.EstufaSolar;
import componentes.regulador.Regulador;
import componentes.Termometro;
import interfaces.Calentable;
import interfaces.Termosensible;

public class Main {

    public static void main( String[] args ) {

        final double minTemp = 15.0;
        final double maxTemp = 21.0;

        Ambiente temperatura = Ambiente.getTemperatura(15.0);
        Calentable radiador = new Calentador();
        Termosensible sensorTemp = new Termometro();

        Regulador regulador = new Regulador();

        System.out.println( "Arrancando..." );
        regulador.regular(sensorTemp, radiador, minTemp, maxTemp, temperatura);

        Calentable solaris = new EstufaSolar();
        ((EstufaSolar) solaris).setReservas(60);
        ((EstufaSolar) solaris).setAlertaReserva(35);
        System.out.println( "Arrancando sistema de energía solar...");
        regulador.regular(sensorTemp, solaris, minTemp, maxTemp, temperatura);
    }
}
