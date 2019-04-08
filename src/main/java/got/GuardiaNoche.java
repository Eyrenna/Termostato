package got;

import ambiente.Ambiente;
import componentes.regulador.ReguladorDisplayCodes;
import interfaces.Calentable;
import interfaces.Regulable;
import interfaces.Termosensible;

public class GuardiaNoche implements Regulable {

    //Métodos

    public void regular(Termosensible termometro, Calentable calentador, double minTemp, double maxTemp, Ambiente temperatura) {
        ReguladorDisplayCodes code;
        while (termometro.read(temperatura) < maxTemp) {
            code = ReguladorDisplayCodes.FUEGO;
            calentador.engage(temperatura);
            message(code, temperatura);
        }
        while (termometro.read(temperatura) > minTemp) {
            code = ReguladorDisplayCodes.HIELO;
            calentador.disengage(temperatura);
            message(code, temperatura);
        }
    }

    public void message(ReguladorDisplayCodes code, Ambiente temperatura) {
        switch (code) {
            case FUEGO:
                System.out.println( "DRACARYS...=> temperatura " + temperatura.getTemp());
                break;
            case HIELO:
                System.out.println("Winter is coming => temperatura " + temperatura.getTemp());
                break;
            default:
                System.out.println("Algo raro sucede...");
                break;
        }
    }
}
