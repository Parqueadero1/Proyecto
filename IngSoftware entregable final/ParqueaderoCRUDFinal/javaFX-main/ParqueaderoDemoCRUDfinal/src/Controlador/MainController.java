/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.VehiculoDao;
import DAO.VehiculoDaoJDBC;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Modelo.Vehiculo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Clase Controladora
 *
 * @author Paula
 */
public class MainController implements Initializable {

    
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfPlaca;
    @FXML
    private TextField tfTipoVehiculo;
    @FXML
    private TextField tfTiempo;
    @FXML
    private TextField tlValorTotal;
    @FXML
    private TableView<Vehiculo> tvVehiculos;
    @FXML
    private TableColumn<Vehiculo, Integer> colID;
    @FXML
    private TableColumn<Vehiculo, String> colPlaca;
    @FXML
    private TableColumn<Vehiculo, String> colTipoVehiculo;
    @FXML
    private TableColumn<Vehiculo, Integer> colTiempo;
    @FXML
    private TableColumn<Vehiculo, Double> colValorTotal;
    @FXML
    private TextField tfColor;
 
    private static Connection conn;
    
    VehiculoDao vehiculoDao = new VehiculoDaoJDBC();

    /**
     * Acciones de los botones
     * Se crea un objeto tipo vehiculo donde los parametros corresponden a los textfield de javafx 
     * la operacion del boton recibe el objeto
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        Vehiculo vehiculo = new Vehiculo(tfId, tfPlaca, tfTipoVehiculo, tfTiempo, tfColor, tlValorTotal);
        
        if (event.getSource() == btnInsert) {
            vehiculoDao.insertarVehiculo(vehiculo);
        } else if (event.getSource() == btnUpdate) {
            vehiculoDao.editarVehiculo(vehiculo);
        } else if (event.getSource() == btnDelete) {
            vehiculoDao.eliminarVehiculo(vehiculo);
        }

    }

    /**
     * Muestra la vista con los registros de la base de datos
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mostrarListaVehiculos();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Los campos de la tabla vehiculos se asignan los campos de la tabla de la
     * vista Main.fxml
     */
    public void mostrarListaVehiculos() throws SQLException {
        
        ObservableList<Vehiculo> listaVehiculos = vehiculoDao.listaVehiculos();

        colID.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("IdVehiculo"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("Placa"));
        colTipoVehiculo.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("TipoVehiculo"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("Tiempo"));
        colValorTotal.setCellValueFactory(new PropertyValueFactory<Vehiculo, Double>("Valor_total"));

        //coloca los valores en la tabla vehiculos
        tvVehiculos.setItems(listaVehiculos);
    }
}
