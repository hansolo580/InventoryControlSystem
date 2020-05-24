package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private boolean internalPart;

    @FXML private Button IMSAddPartButton;
    @FXML private Label partLabel;

    @FXML void AddPartButtonInternal(ActionEvent event) {
        internalPart = true;
        partLabel.setText("Machine ID");
    }
    @FXML void AddPartButtonOutsourced(ActionEvent event) {
        internalPart = false;
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



    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
