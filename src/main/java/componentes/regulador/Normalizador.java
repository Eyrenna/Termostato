package componentes.regulador;

import ambiente.Ambiente;
import componentes.calentador.EstufaSolar;
import interfaces.Calentable;
import interfaces.Regulable;
import interfaces.Termosensible;

public class Normalizador implements Regulable {

    public void regular(Termosensible termometro, Calentable calentador, double minTemp, double maxTemp, Ambiente temperatura) {
        ReguladorDisplayCodes code;
        while (termometro.read(temperatura) < maxTemp) {
            if (((EstufaSolar) calentador ).getReservas() > ((EstufaSolar) calentador ).getAlertaReserva()) {
                    code = ReguladorDisplayCodes.HEATING;
                    calentador.engage(temperatura);
                    message(code, temperatura);
            }
            else break;
        }
        while (termometro.read(temperatura) > minTemp) {
            code = ReguladorDisplayCodes.WAITING;
            calentador.disengage(temperatura);
            message(code, temperatura);
        }
    }


    public void message(ReguladorDisplayCodes code, Ambiente temperatura) {
        switch (code) {
            case HEATING:
                System.out.println("Calentando => temperatura " + temperatura.getTemp());
                break;
            case WAITING:
                System.out.println("Apagado => temperatura " + temperatura.getTemp());
                break;
            default:
                System.out.println("Algo raro sucede...");
                break;
        }
    }

}
