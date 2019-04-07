package componentes;

import ambiente.Ambiente;
import interfaces.Termosensible;

public class Termometro implements Termosensible {

    //Constructor

    public Termometro() {
    }


    //Métodos

    public double read(Ambiente temperatura) {
        return temperatura.getTemp();
    }

}
