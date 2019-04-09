package got;

import ambiente.Ambiente;
import interfaces.Calentable;

public class Daenerys implements Calentable {

    //Atributos

    private final int DRAGONFUEGO = 150419;
    private final int DRAGONHIELO = -137117;

    //Métodos

    public void engage(Ambiente temperatura) {
        temperatura.modificarTemperatura(this.DRAGONFUEGO);
    }

    public void disengage(Ambiente temperatura) {
        temperatura.modificarTemperatura(this.DRAGONHIELO);
    }
}
