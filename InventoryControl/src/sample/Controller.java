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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Button IMSAddPartButton;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
