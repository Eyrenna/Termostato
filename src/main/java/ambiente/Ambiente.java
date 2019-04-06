package ambiente;

public class Ambiente {

    /*_________Singleton Pattern_________*/
    /*
    * -Instancia privada y estática
    * -Constructor privado
    * -getObjeto para "new Objeto" public y static
    */

    //Atributos

    private Double temp = 0d;
    private static Ambiente temperatura = null;


    //Constructor

    private Ambiente(Double temp) {
        this.temp = temp;
    }

    //Getters

    public static Ambiente getTemperatura(Double temp) {
        if (temperatura == null) {
            temperatura = new Ambiente(temp);
        }
        return temperatura;
    }

    public Double getTemp() {
        return this.temp;
    }
}
