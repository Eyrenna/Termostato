package interfaces;

import ambiente.Ambiente;
import componentes.regulador.ReguladorDisplayCodes;

public interface Regulable {

    //Métodos

    void regular(Termosensible termometro, Calentable calentador, double minTemp, double maxTemp, Ambiente temperatura);

    void message(ReguladorDisplayCodes code, Ambiente temperatura);
}
