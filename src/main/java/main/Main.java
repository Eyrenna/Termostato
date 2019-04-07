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

        /*_____SALIDA CONSOLA_____*/
        /*
        Arrancando...
        Calentando => temperatura 16.0
        Calentando => temperatura 17.0
        Calentando => temperatura 18.0
        Calentando => temperatura 19.0
        Calentando => temperatura 20.0
        Calentando => temperatura 21.0
        Apagado => temperatura 20.0
        Apagado => temperatura 19.0
        Apagado => temperatura 18.0
        Apagado => temperatura 17.0
        Apagado => temperatura 16.0
        Apagado => temperatura 15.0
         */

        Calentable solaris = new EstufaSolar();
        ((EstufaSolar) solaris).setReservas(60);
        ((EstufaSolar) solaris).setAlertaReserva(35);
        System.out.println( "Arrancando sistema de energía solar...");
        regulador.regular(sensorTemp, solaris, minTemp, maxTemp, temperatura);

        /*___SALIDA CONSOLA____*/
        /*
        Arrancando sistema de energía solar...
        Calentando => temperatura 17.0
        Calentando => temperatura 19.0
        Calentando => temperatura 21.5
        Apagado => temperatura 20.0
        Apagado => temperatura 18.5
        Apagado => temperatura 17.0
        Apagado => temperatura 15.5
        Apagado => temperatura 14.0
        */

        /*Calentable solarjet = new EstufaSolar();
        ((EstufaSolar) solarjet).setReservas(20);
        ((EstufaSolar) solarjet).setAlertaReserva(15);
        System.out.println( "Arrancando sistema de energía solar...");
        regulador.regular(sensorTemp, solarjet, minTemp, maxTemp, temperatura);*/
    }
}
