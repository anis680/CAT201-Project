package com.example.catjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAdd;
    @FXML
    private TextField txtQt;
    @FXML
    private RadioButton cob;
    @FXML
    private RadioButton cod;
    @FXML
    private ToggleGroup payment;
    @FXML
    public ChoiceBox<String> cMenu;
    private String[] food = {"PALATAO CHEESE BURGER (RM11.90)",
            "BEEF PATTY+MELTED CHEESE+ (RM11.90)", "CARAMELISED ONIONS +SIGNATURE SAUCE (RM11.90)"};

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDetail(ActionEvent event) throws IOException {
        if (txtQt.getText().isEmpty() || txtAdd.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please enter QUANTITY of order and your ADDRESS ");
            a.show();
        } if (txtQt.getText().matches("\\d+")) {
            detail();
            Parent root = FXMLLoader.load(getClass().getResource("DetailAndProgress.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert b = new Alert(Alert.AlertType.ERROR);
            b.setContentText("Please enter DIGITS only");
            b.show();
        }
    }

    private void detail() {
        Menu.name = txtName.getText();
        Menu.add = txtAdd.getText();
        Menu.quantity = Integer.parseInt(txtQt.getText());
        Menu.value = (String) cMenu.getValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cMenu.getItems().addAll(food);
        cMenu.getSelectionModel().select(0);
    }
}
