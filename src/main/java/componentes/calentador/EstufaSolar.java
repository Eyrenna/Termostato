package componentes.calentador;

import ambiente.Ambiente;
import interfaces.Calentable;

public class EstufaSolar implements Calentable {

    //Atributos

    private double reservas = 0d; //Porcentaje
    private double alertaReserva = 0d;
    private final int NO_RESERVAS = 5; //Minimo no modificable por seguridad de la maquinaria
    private final double MAX_RENDIMIENTO = 2;
    private final int CONSUMO = -10;
    private final double MIN_RENDIMIENTO = 0.5;
    private final int BAJO_CONSUMO = -5;
    private final double ENFRIAMIENTO = -1.5;
    private final double RECARGA = 5;


    //Constructor

    public EstufaSolar() {
    }


    //Setter

    public void setReservas(double reservas) {
        this.reservas = reservas;               //Ajustable a voluntad del usuario
    }

    public void setAlertaReserva(double alertaReserva) {
        this.alertaReserva = alertaReserva;     //Ajustable a voluntad del usuario
    }


    //Getters

    public double getReservas() {
        return reservas;
    }

    public double getAlertaReserva() {

        return alertaReserva;
    }


    //Métodos

    public void engage(Ambiente temperatura) {
        if (reservas > alertaReserva) {
            temperatura.modificarTemperatura(this.MAX_RENDIMIENTO);
            setReservas(modificarReservas(this.CONSUMO));
        }
        else {
            if (reservas > NO_RESERVAS) {
                temperatura.modificarTemperatura(this.MIN_RENDIMIENTO);
                modificarReservas(this.BAJO_CONSUMO);
            }
            else {
                disengage(temperatura);
            }
        }
    }

    public void disengage(Ambiente temperatura) {
        temperatura.modificarTemperatura(this.ENFRIAMIENTO);
        modificarReservas(this.RECARGA);
    }

    public double modificarReservas(double variacion) {
        return this.reservas += variacion;
    }

}
