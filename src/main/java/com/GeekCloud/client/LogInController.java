package com.GeekCloud.client;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    String queryLogin = "SELECT login FROM Users WHERE login ";
    String queryPassword = "select password from Users where";

    @FXML
    TextField login;
    @FXML
    TextField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            stmt = con.createStatement();
        con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/test");}

        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally {
            try { con.close(); } catch(SQLException se) { se.printStackTrace(); }
            try { stmt.close(); } catch(SQLException se) { se.printStackTrace(); }
        }

        login.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                loginIsValid(login.getText());
            }
        });
        password.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                passwordIsValid(password.getText());
            }
        });
    }

    public boolean loginIsValid(String login){
        try{
            rs = stmt.executeQuery(queryLogin + "= " + login );
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (login.equals(rs.toString())){
            System.out.println("ok");
            return true;
        }
        else return false;
    }
    public boolean passwordIsValid(String password){
        return false;
    }

}
