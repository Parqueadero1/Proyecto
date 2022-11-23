/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Ejecucion de operaciones sobre la base de datos
 * 
 * Clase que modifica los metodos implementados en de la interface VehiculoDao
 * 
 * @author Paula
 */
public class VehiculoDaoJDBC implements VehiculoDao {

    public String SQL_SELECT = "SELECT IdVehiculo, Placa, TipoVehiculo, Color, Valor_total FROM vehiculo";
    public String SQL_INSERT = "INSERT INTO vehiculo(IdVehiculo, Placa, TipoVehiculo, Color,Valor_total) VALUES(?, ?, ?, ?, ?)";
    public String SQL_UPDATE = "UPDATE vehiculo SET Placa = ?, TipoVehiculo = ?, Color = ?, Valor_total = ? WHERE IdVehiculo = ?";
    public String SQL_DELETE = "DELETE FROM vehiculo WHERE IdVehiculo = ?";
    static Connection conn = Conexion.getConnection();

    public VehiculoDaoJDBC() {
    }

    
    /**
     * Se obtine los resgistros de la tabla vehiculo Al ejecutar la consulta
     * SQL_SELECT se asigna los campos en los paramentros del constructor
     * Vehiculo
     * 
     * @return
     * @throws SQLException 
     */
    @Override
    public ObservableList<Vehiculo> listaVehiculos() throws SQLException {
        ObservableList<Vehiculo> ListaVehiculos = FXCollections.observableArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vehiculo vehiculos = null;
        ps = conn.prepareStatement(SQL_SELECT);
        rs = ps.executeQuery();
        while (rs.next()) {
            vehiculos = new Vehiculo(rs.getInt("IdVehiculo"), rs.getString("Placa"), rs.getString("TipoVehiculo"), rs.getString("Color"), rs.getInt("Valor_total"), rs.getInt("Tiempo"));
            ListaVehiculos.add(vehiculos);
        }

        return ListaVehiculos;
    }

    /**
     * Crea un registro de la tabla vehiculo
     * 
     * @param vehiculo
     * @return registros
     * @throws SQLException 
     */
    @Override
    public int insertarVehiculo(Vehiculo vehiculo) throws SQLException {
        PreparedStatement ps = null;
        int registros = 0; //para saber cuantos registros se modifican 

        ps = conn.prepareStatement(SQL_INSERT);
        ps.setInt(1, vehiculo.getIdVehiculo()); // indice 
        ps.setString(2, vehiculo.getPlaca());
        ps.setString(3, vehiculo.getTipoVehiculo());
        ps.setString(4, vehiculo.getColor());
        ps.setInt(5, vehiculo.getValor_total());
        ps.setInt(6, vehiculo.getTiempo());
        System.out.println("Ejecutando query SQL_INSERT = " + SQL_INSERT);
        registros = ps.executeUpdate();
        System.out.println("numero de registros insertados = " + registros);
        return registros;

    }

    /**
     * Modifica todos los campos del IdVehiculo que se escriba
     * 
     * @param vehiculo
     * @return registros
     * @throws SQLException 
     */
    @Override
    public int editarVehiculo(Vehiculo vehiculo) throws SQLException {
        PreparedStatement ps = null;
        int registros = 0;
        ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, vehiculo.getPlaca());
        ps.setString(2, vehiculo.getTipoVehiculo());
        ps.setString(3, vehiculo.getColor());
        ps.setInt(4, vehiculo.getValor_total());
        ps.setInt(5, vehiculo.getTiempo());
        ps.setInt(6, vehiculo.getIdVehiculo());

        // se muestra en el log 
        System.out.println("Ejecutando query SQL_UPDATE = " + SQL_UPDATE);
        registros = ps.executeUpdate();
        System.out.println("se modifico el registro  = " + registros);
        return registros;
    }

    /**
     * Elimina el registro solo con escribir el IdVehiculo
     * 
     * @param vehiculo
     * @return registros
     * @throws SQLException 
     */
    @Override
    public int eliminarVehiculo(Vehiculo vehiculo) throws SQLException {
        PreparedStatement ps = null;
        int registros = 0;
        ps = conn.prepareStatement(SQL_DELETE);
        ps.setInt(1, vehiculo.getIdVehiculo());
        registros = ps.executeUpdate();// regresa la cantidad de registros modificados
        System.out.println("se elimino " + registros + " registro");
        return registros;
    }
}
