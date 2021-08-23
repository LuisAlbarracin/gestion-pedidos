/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.model;

/**
 *
 * @author luis-albarracin
 */
public class Cuenta {

    private String tarjetaCredito;
    private Float cantidadDinero;

    public Cuenta() {
    }

    public Cuenta(String tarjetaCredito, Float cantidadDinero) {
        this.tarjetaCredito = tarjetaCredito;
        this.cantidadDinero = cantidadDinero;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Float getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(Float cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

}
