package componentes;

import ambiente.Ambiente;
import interfaces.Calentable;
import interfaces.Termosensible;


public class Regulador {

    public void regular(Termosensible termometro, Calentable calentador, double minTemp, double maxTemp, Ambiente temperatura) {
        RegulatorDisplayCodes code;
        while (termometro.read(temperatura) < maxTemp) {
            code = RegulatorDisplayCodes.HEATING;
            calentador.engage(temperatura);
            message(code, temperatura);
        }
        while (termometro.read(temperatura) > minTemp) {
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
