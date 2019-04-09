package ambiente;

public class Ambiente {

    /*_________Singleton Pattern_________*/
    /*
    * -Instancia privada y estática
    * -Constructor privado
    * -getObjeto para "new Objeto" public y static(obligatorio porque la instancia es privada por lo que para acceder a un
     * método de un objeto privado se necesita un punto de acceso goblal)
    * -Recomendable poner la instancia del objeto en mayúsculas dando a entender que es constante
    *
    * *El singleton es del estilo del Enum en el que se crean un número determinado de instancias.
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

    public void modificarTemperatura(double cambio) {
        this.temp += cambio;
    }
}
