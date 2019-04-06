package main;

import ambiente.Ambiente;

public class Main {

    public static void main( String[] args ) {

        final double minTemp = 15.0;
        final double maxTemp = 21.0;

        Ambiente temperatura = Ambiente.getTemperatura(15.0);
        Heater heater = new GasHeater();
        Thermometer thermometer = new RemoteCommandSensor();

        Regulator regulator = new Regulator();

        System.out.println( "Arrancando..." );
        regulator.regulate(thermometer, heater, minTemp, maxTemp, temperature);

        Jedi yoda = new Jedi();
        System.out.println( "\nArrancando a Yoda: " );
        regulator.regulate(thermometer, yoda, minTemp, maxTemp, temperature);
        yoda.speak();
    }
}
