/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo18FXML;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Ejemplo de uso de una vista FXML junto su controlador.
 * @author Salvador Romero
 */
public class Ejemplo18FXML extends Application {
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Obtenemos un recurso en el directorio de la clase actual.
        URL urlDelRecurso=getClass().getResource("rectangulos.fxml");
        
        //Creamos una instancia de FXMLLoader para cargar el recurso dada su localización (URL)
        FXMLLoader loader=new FXMLLoader(urlDelRecurso);               
        
        //Cargamos (loader.load()) el recurso / nodo contenedor.
        Parent root=loader.load();
        
        /* Obtenemos el controlador (previamente indicado en el FXML)
         con fx:controller="UT09.Ejemplo18FXML.RectangulosFxmlController" 
        en el nodo principal. */
        RectangulosFxmlController rc=loader.getController();
        
        /* Invocamos nuestro método propio de inicializacion o lo que necesitemos.
           (customInicialization es un método propio, no tiene nada que ver con JavaFX ) */
        rc.customInicialization(10);
        
        //Establecemos el nodo raiz de la escena como el contenedor anterior
        Scene scene= new Scene(root);                
        
        //Establecemos la escena de este escenario como la anterior.        
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("Ejemplo 18. Aplicacion sencilla FXML.");
        
        primaryStage.show();

    }
}
