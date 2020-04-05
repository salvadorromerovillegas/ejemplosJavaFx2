/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo18FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Salvador Romero
 */
public class RectangulosFxmlController implements Initializable {

    private int valor=0;
    
    @FXML
    private TextField numero;
    
    @FXML
    private Label resultado;
    
    @FXML 
    private void handleSumar(ActionEvent event)
    {
        try {
            int valorLeido=Integer.parseInt(numero.getText());
            valor+=valorLeido;
        } 
        catch (NumberFormatException e)
        {
            Alert a=new Alert(AlertType.ERROR,"No se ha introducido un número.");
            a.showAndWait();
        }
        finally {
            numero.setText("0");
            resultado.setText(Integer.toString(valor));
        }
    }
    
    @FXML 
    private void handleRestar(ActionEvent event)
    {
        try {
            int valorLeido=Integer.parseInt(numero.getText());
            valor-=valorLeido;
        } 
        catch (NumberFormatException e)
        {
            Alert a=new Alert(AlertType.ERROR,"No se ha introducido un número.");
            a.showAndWait();
        }
        finally {
            numero.setText("0");
            resultado.setText(Integer.toString(valor));
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resultado.setText(Integer.toString(valor));
    }    
    
    /**
     * Inicialización personalizada. A través de este método del controlador
     * daremos un valor a los diferentes elementos de la intefaz que se
     * enlazaron aquí.
     * @param valor 
     */
    public void customInicialization (int valor)
    {
        this.valor=valor;
        resultado.setText(Integer.toString(valor));
    }
    
    
    public int getValor()
    {
        return valor;
    }
    
    
}
