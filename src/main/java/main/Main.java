package main;

import ambiente.Ambiente;
import componentes.calentador.Calentador;
import componentes.calentador.EstufaSolar;
import componentes.regulador.Regulador;
import componentes.Termometro;
import got.Daenerys;
import got.GuardiaNoche;
import interfaces.Calentable;
import interfaces.Regulable;
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
        Calentando => temperatura 17.0                      >50
        Calentando => temperatura 19.0                      >40
        Calentando => temperatura 21.0                      >30
        Apagado => temperatura 19.5                         >35
        Apagado => temperatura 18.0                         >40
        Apagado => temperatura 16.5                         >45
        Apagado => temperatura 15.0                         >50   CORRECTO!!
        Estado de la reserva de energía: 50.0
        */

        /*Calentable solarjet = new EstufaSolar();
        ((EstufaSolar) solarjet).setReservas(20);
        ((EstufaSolar) solarjet).setAlertaReserva(15);
        System.out.println( "Arrancando sistema de energía solar...");
        regulador.regular(sensorTemp, solarjet, minTemp, maxTemp, temperatura);*/

        Calentable dragones = new Daenerys();
        Regulable jonNieve = new GuardiaNoche();
        System.out.println( "Hace su entrada Daenerys de la Tormenta de la casa Targaryen, " +
                "\nlegítima heredera del Trono de Hierro, Reina de los Ándalos y los Primeros Hombres, " +
                "\nProtectora de los Siete Reinos, Madre de Dragones, la Khaleesi del Gran Mar de Hierba  " +
                "\nla que no arde, Rompedora de cadenas");
        jonNieve.regular(sensorTemp, dragones, minTemp, maxTemp, temperatura);
    }
}
