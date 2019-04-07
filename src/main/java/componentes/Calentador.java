package componentes;

import ambiente.Ambiente;
import interfaces.Calentable;

public class Calentador implements Calentable {

    //Atributos

    private final double SUBIDA = 1;
    private final double BAJADA = -1;


    //Constructor

    public Calentador() {
    }


    //Métodos

    @Override
    public void engage(Ambiente temperatura) {
        temperatura.modificarTemperatura(this.SUBIDA);
    }

    @Override
    public void disengage(Ambiente temperatura) {
        temperatura.modificarTemperatura(this.BAJADA);
    }
}
