package viewscontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private void initialize() {

    }

    public Controller() {

    }

    Inventory currentInventory;

    public Controller(Inventory currentInventory) {
        this.currentInventory = currentInventory;
    }

    @FXML private Label partLabel;

    @FXML void AddPartButtonInternal(ActionEvent event) {
        partLabel.setText("Machine ID");
    }
    @FXML void AddPartButtonOutsourced(ActionEvent event) {
        partLabel.setText("Company Name");
    }

    /**
     * When this method is called, it will change the scene to AddPartView
     */

    public void changeScreenAddPart(ActionEvent event) throws IOException {
        Parent newPartParent = FXMLLoader.load(getClass().getResource("AddPartView.fxml"));
        Scene newPartScene = new Scene(newPartParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newPartScene);
        window.show();
    }

    // This changes to ModifyPartView

    public void changeScreenModifyPart(ActionEvent event) throws IOException {
        Parent modifyPartParent = FXMLLoader.load(getClass().getResource("ModifyPartView.fxml"));
        Scene modifyPartScene = new Scene(modifyPartParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(modifyPartScene);
        window.show();
    }

    //Changes to AddProductView

    public void changeScreenAddProduct(ActionEvent event) throws IOException {
        Parent addProductParent = FXMLLoader.load(getClass().getResource("AddProductView.fxml"));
        Scene addProductScene = new Scene(addProductParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(addProductScene);
        window.show();
    }

    //Changes to ModifyProductView

    public void changeScreenModifyProduct(ActionEvent event) throws IOException {
        Parent modifyProductParent = FXMLLoader.load(getClass().getResource("ModifyProductView.fxml"));
        Scene modifyProductScene = new Scene(modifyProductParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(modifyProductScene);
        window.show();
    }

    //Returns to Home Screen

    public void changeScreenHome(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML void Quit(ActionEvent event) {
        System.exit(0);
    }

//parts management

    @FXML private Label PartLabel;
    @FXML private TextField NewIDField;
    @FXML private TextField NewNameField;
    @FXML private TextField NewStockField;
    @FXML private TextField NewPriceField;
    @FXML private TextField NewMinField;
    @FXML private TextField NewMaxField;
    @FXML private TextField NewFlexField;
    @FXML private TableView<Part> HomePartsTableView;
    @FXML private TextField PartSearchField;
    @FXML private ObservableList<Part> PartsSearchInventory = FXCollections.observableArrayList();


    @FXML void AddPartsSave(ActionEvent event) throws IOException {
        int id = Integer.parseInt(NewIDField.getText());
        String name = NewNameField.getText();
        int stock = Integer.parseInt(NewStockField.getText());
        Double price = Double.parseDouble(NewPriceField.getText());
        int min = Integer.parseInt(NewMinField.getText());
        int max = Integer.parseInt(NewMaxField.getText());
        String diverter = partLabel.getText();
        String flex = NewFlexField.getText();


        if (diverter.equals("Machine ID")) {
            currentInventory.addPart(new InHouse(id, name, stock, price, min, max, Integer.parseInt(flex)));
        }
        else {
            currentInventory.addPart(new Outsourced(id, name, stock, price, min, max, flex));
        }
        Parent savedPart = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(savedPart);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML void DeleteParts(ActionEvent event) throws IOException {
        Part activePart = HomePartsTableView.getSelectionModel().getSelectedItem();
        currentInventory.deletePart(activePart);
    }

    @FXML private void PartSearch(ActionEvent event) {
        if (!PartSearchField.getText().trim().isEmpty()) {
           HomePartsTableView.setItems(currentInventory.lookupPart(PartSearchField.getText()));
        }
    }

    @FXML private void loadParts() {
        HomePartsTableView.setItems(currentInventory.getAllParts());
        HomePartsTableView.refresh();
    }

    //product management

    @FXML private Label ProductLabel;
    @FXML private TextField NewProductIDField;
    @FXML private TextField NewProductNameField;
    @FXML private TextField NewProductStockField;
    @FXML private TextField NewProductPriceField;
    @FXML private TextField NewProductMaxField;
    @FXML private TextField NewProductMinField;
    @FXML private TableView<Product> ProductsTableView;
    @FXML private TextField ProductSearchField;
    @FXML private ObservableList<Product> ProductSearchInventory = FXCollections.observableArrayList();

    @FXML void DeleteProducts(ActionEvent event) throws IOException {
        Product activeProduct = ProductsTableView.getSelectionModel().getSelectedItem();
        currentInventory.deleteProduct(activeProduct);
    }

    @FXML private void ProductSearch(ActionEvent event) {
            ProductsTableView.setItems(currentInventory.lookupProduct(ProductSearchField.getText()));
    }

    @FXML private void loadProducts() {
        ProductsTableView.setItems(currentInventory.getAllProducts());
        ProductsTableView.refresh();
    }




}
