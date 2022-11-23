/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Vehiculo;
import java.sql.SQLException;
import javafx.collections.ObservableList;


/**
 * Objeto de acceso a datos
 * 
 * Operacion principales de la clase vehiculo
 * 
 * @author Paula
 */
public interface VehiculoDao {

    public ObservableList<Vehiculo> listaVehiculos()throws SQLException;

    public int insertarVehiculo(Vehiculo vehiculo) throws SQLException;

    public int editarVehiculo(Vehiculo vehiculo) throws SQLException;

    public int eliminarVehiculo(Vehiculo vehiculo) throws SQLException;
}