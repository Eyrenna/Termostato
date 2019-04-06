package detalles;

import ambiente.Ambiente;


public class Regulator {

    public void regulate(Thermometer t, Heater h, double minTemp, double maxTemp, Ambiente temperatura) {
        RegulatorDisplayCodes code;
        while (t.read(temperatura) < maxTemp) {
            code = RegulatorDisplayCodes.HEATING;
            h.engage(temperatura);
            message(code, temperatura);
        }
        while (t.read(temperatura) > minTemp) {
            code = RegulatorDisplayCodes.WAITING;
            h.disengage(temperatura);
            message(code, temperatura);
        }
    }

    private void message(RegulatorDisplayCodes code, Ambiente temperatura) {
        switch (code) {
            case HEATING:
                System.out.println("Calentando => temperatura " + temperatura.getTemperatura());
                break;
            case WAITING:
                System.out.println("Apagado => temperatura " + temperatura.getTemperatura());
                break;
            default:
                System.out.println("Algo raro sucede...");
                break;
        }
    }

}
