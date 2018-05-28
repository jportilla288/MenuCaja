package com.carta.dx.menucaja;

import java.sql.Time;

/**
 * Created by jennyandrea on 10/11/2016.
 */

public class NuevoPedido {

    private int idPedido;
    private int idEmpleado;
    private int precio;
    private Time duracion;
    private int numMesa;

    public NuevoPedido() {
    }

    public NuevoPedido(int idPedido, int idEmpleado, int precio, Time duracion, int numMesa) {
        this.idPedido = idPedido;
        this.idEmpleado = idEmpleado;
        this.precio = precio;
        this.duracion = duracion;
        this.numMesa = numMesa;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }
}
