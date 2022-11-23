/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import javafx.scene.control.TextField;

/**
 * Clase vehiculo principal
 * 
 * 
 * @author Paula
 */
public class Vehiculo {
    public int IdVehiculo;
    public String Placa;
    public String TipoVehiculo;
    public String Color;
    public int Valor_total;
    public int Tiempo;

    public Vehiculo(int IdVehiculo, String Placa, String TipoVehiculo, String Color, int Valor_total, int Tiempo) {
        this.IdVehiculo = IdVehiculo;
        this.Placa = Placa;
        this.TipoVehiculo = TipoVehiculo;
        this.Color = Color;
        this.Valor_total = Valor_total;
        this.Tiempo = Tiempo;
    }
    
    
    /***
     * Constructor que me permite pasar parametros tipo TextField
     * 
     * @param tfId
     * @param tfPlaca
     * @param tfTipoVehiculo
     * @param tfTiempo
     * @param tfColor
     * @param tlValorTotal 
     */
    public Vehiculo(TextField tfId, TextField tfPlaca, TextField tfTipoVehiculo, TextField tfTiempo, TextField tfColor, TextField tlValorTotal) {
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