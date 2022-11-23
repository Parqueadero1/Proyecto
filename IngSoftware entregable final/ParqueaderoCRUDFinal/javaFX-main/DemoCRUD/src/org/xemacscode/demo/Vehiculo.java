/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.xemacscode.demo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Vehiculo {
    private int IdVehiculo;
    private String Placa;
    private String TipoVehiculo;
    private String Color;
    private int Valor_total;
    private int Tiempo;

    public Vehiculo(int IdVehiculo, String Placa, String TipoVehiculo, String Color, int Valor_total, int Tiempo) {
        this.IdVehiculo = IdVehiculo;
        this.Placa = Placa;
        this.TipoVehiculo = TipoVehiculo;
        this.Color = Color;
        this.Valor_total = Valor_total;
        this.Tiempo = Tiempo;
    }

    public int getIdVehiculo() {
        return IdVehiculo;
    }

    public void setIdVehiculo(int IdVehiculo) {
        this.IdVehiculo = IdVehiculo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getValor_total() {
        return Valor_total;
    }

    public void setValor_total(int Valor_total) {
        this.Valor_total = Valor_total;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

}
