package com.example.catjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private double p1=11.90, total=p1*Menu.quantity;

    @FXML
    private TextArea taSummary;

    public void switchToOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Order.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MenuReview.fxml"));
        taSummary.setText("Name : " + Menu.name + "\n\nAddress : " + Menu.add + "\n\nBurger : " + Menu.value +
                "\n\nQuantity of Order : " + Menu.quantity  +
                "\n\nTOTAL : " + total);
    }
}
