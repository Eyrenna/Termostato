package componentes;

import ambiente.Ambiente;
import interfaces.Calentable;


public class Regulator {

    public void regulate(Thermometer t, Calentable calentador, double minTemp, double maxTemp, Ambiente temperatura) {
        RegulatorDisplayCodes code;
        while (t.read(temperatura) < maxTemp) {
            code = RegulatorDisplayCodes.HEATING;
            calentador.engage(temperatura);
            message(code, temperatura);
        }
        while (t.read(temperatura) > minTemp) {
            code = RegulatorDisplayCodes.WAITING;
            calentador.disengage(temperatura);
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
