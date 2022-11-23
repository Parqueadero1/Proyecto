/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
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
    private ChoiceBox<String> tfTipoVehiculo;
    @FXML
    private TextField tfTiempo;
    @FXML
    private TextField tfColor;
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
    private ImageView ivImagen;
    
    private String[] v = {"Carro electrico", "Carro a gas", "Bici", "Moto"};

    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alert4 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Informacion");
        alert1.setContentText("Se ha agregado un registro exitosamente !!!");
        alert2.setTitle("Informacion");
        alert2.setContentText("Se ha editado el registro");
        alert3.setContentText("¿Seguro que quiere eliminar el registro?");
        alert4.setContentText("imagen seleccionada : ");

        if (event.getSource() == btnInsert) {
            alert1.showAndWait();
            insertRecord();
        } else if (event.getSource() == btnUpdate) {
            alert2.showAndWait();
            updateRecord();
        } else if (event.getSource() == btnDelete) {
            alert3.showAndWait();
            deleteButton();
        } 

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfTipoVehiculo.getItems().addAll(v);
        showBooks();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/parqueadero", "root", "admin");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Vehiculo> getBooksList() {
        ObservableList<Vehiculo> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM vehiculo";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Vehiculo vehiculos;
            while (rs.next()) {
                vehiculos = new Vehiculo(rs.getInt("IdVehiculo"), rs.getString("Placa"), rs.getString("TipoVehiculo"),
                        rs.getString("Color"), rs.getInt("Valor_total"), rs.getInt("Tiempo"));
                
                
                bookList.add(vehiculos);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    public void showBooks() {
        ObservableList<Vehiculo> list = getBooksList();
        
        colID.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("IdVehiculo"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("Placa"));
        colTipoVehiculo.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("TipoVehiculo"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("Tiempo"));
        colValorTotal.setCellValueFactory(new PropertyValueFactory<Vehiculo, Double>("Valor_total"));

        tvVehiculos.setItems(list);
    }

    private void insertRecord() {

        
        String query = "INSERT INTO vehiculo VALUES (" + tfId.getText() + ",'" + tfPlaca.getText() + "','" + tfTipoVehiculo.getValue() + "','"
                + tfColor.getText() + "'," + tlValorTotal.getText() + "," + tfTiempo.getText() + ")";
        
        executeQuery(query);
        showBooks();
    }

    private void updateRecord() {
        String query = "UPDATE  vehiculo SET IdVehiculo  = " + tfId.getText() + ", Placa = '" + tfPlaca.getText() + "', TipoVehiculo = '"
                + tfTipoVehiculo.getValue() + "', Color = '" + tfColor.getText() + "', Valor_total = " + tlValorTotal.getText() + ", Tiempo = "
                + tfTiempo.getText() + " WHERE IdVehiculo = " + tfId.getText() + "";
        executeQuery(query);
        showBooks();
    }

    private void deleteButton() {
        String query = "DELETE FROM vehiculo WHERE IdVehiculo =" + tfId.getText() + "";
        executeQuery(query);
        showBooks();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    

}
