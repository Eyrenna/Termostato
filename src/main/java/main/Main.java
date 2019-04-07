package main;

import ambiente.Ambiente;
import componentes.Regulator;
import interfaces.Calentable;

public class Main {

    public static void main( String[] args ) {

        final double minTemp = 15.0;
        final double maxTemp = 21.0;

        Ambiente temperatura = Ambiente.getTemperatura(15.0);
        Calentable radiador = new GasHeater();
        Thermometer thermometer = new RemoteCommandSensor();

        Regulator regulator = new Regulator();

        System.out.println( "Arrancando..." );
        regulator.regulate(thermometer, radiador, minTemp, maxTemp, temperatura);

        Jedi yoda = new Jedi();
        System.out.println( "\nArrancando a Yoda: " );
        regulator.regulate(thermometer, yoda, minTemp, maxTemp, temperatura);
        yoda.speak();
    }
}
