package com.GeekCloud.client;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthController implements Initializable {

    @FXML
    Button logIn;

    @FXML
    Button signIn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logIn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pressOnLogIn();
            }
        });
        signIn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pressOnSignIn();
            }
        });
    }
    @FXML
    public void pressOnLogIn() {
        if (logIn.isManaged()) {
            System.out.println("hrty");
            try{
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("D:\\GeekCloud111\\src\\main\\resources\\com\\flamexander\\netty\\example\\Login.fxml.fxml"));
                Parent root = loader.load();
                AuthController lc = (AuthController) loader.getController();
//                lc.id = 100;
                stage.setTitle("JavaFX Autorization");
                stage.setScene(new Scene(root, 400, 200));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void pressOnSignIn() {
        if (signIn.isManaged()) {
            System.out.println("tyuytuky6u");

        }
    }
}
