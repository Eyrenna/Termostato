package main;

import ambiente.Ambiente;
import componentes.Calentador;
import componentes.Regulator;
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

        Regulator regulator = new Regulator();

        System.out.println( "Arrancando..." );
        regulator.regulate(sensorTemp, radiador, minTemp, maxTemp, temperatura);

        Jedi yoda = new Jedi();
        System.out.println( "\nArrancando a Yoda: " );
        regulator.regulate(thermometer, yoda, minTemp, maxTemp, temperatura);
        yoda.speak();
    }
}
