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
        System.out.println( "Estado de la reserva de energía: " + ((EstufaSolar) solaris).getReservas());

        /*___SALIDA CONSOLA____*/                       /*Calculos Reserva*/
        /*
        Arrancando sistema de energía solar...
        Calentando => temperatura 17.0                     >50   (-10)
        Calentando => temperatura 19.0                     >40   (-10)
        Calentando => temperatura 21.5                     >30   (-10) ERROR (-10)(-5) Sube Ta (2)(0.5)
        Apagado => temperatura 20.0                        >35   (+5)
        Apagado => temperatura 18.5                        >40   (+5)
        Apagado => temperatura 17.0                        >45   (+5)
        Apagado => temperatura 15.5                        >50   (+5)
        Apagado => temperatura 14.0                        >55   (+5)
        Estado de la reserva de energía: 50.0
        */

        /*Calentable solarjet = new EstufaSolar();
        ((EstufaSolar) solarjet).setReservas(20);
        ((EstufaSolar) solarjet).setAlertaReserva(15);
        System.out.println( "Arrancando sistema de energía solar...");
        regulador.regular(sensorTemp, solarjet, minTemp, maxTemp, temperatura);*/
    }
}
