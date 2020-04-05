/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo19ComunicacionEntreScenes;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author salva
 */
public class Main extends Application{
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Lista de personas.");
        crearContenido(primaryStage);               
        primaryStage.show();
        
    }
    
    
    //Lista de personas
    private List<Persona> listaDePersona=new LinkedList<>();
    
    //Donde aparecerán las personas
    private VBox mostrarListaDePersonas=new VBox(10);
    
    /**
     * Actualiza la lista de personas.
     */
    private void actualizarLista()
    {
        mostrarListaDePersonas.getChildren().clear();
        for (Persona p:listaDePersona)
            mostrarListaDePersonas.getChildren().add(new Text(p.toString()));
    }
    
    //Crea el contenido de la ventana
    public void crearContenido (Stage primaryStage)
    {
        BorderPane h=new BorderPane();
        Button añadir=new Button("Añadir Persona");
        Button vaciar=new Button("Vaciar");
        h.setTop(new HBox(10,añadir,vaciar));
        h.setCenter(mostrarListaDePersonas);       
        añadir.setOnAction((a)->
        {
            DialogAddPerson s=new DialogAddPerson(primaryStage);
            s.showAndWait();
            if (!s.esCancelado())
                listaDePersona.add(s.getPersona());
            actualizarLista();
        }
        );       
        vaciar.setOnAction((a)-> { 
            Alert avisa=new Alert(AlertType.CONFIRMATION,"¿Seguro que desea vaciar la lista?",ButtonType.NO,ButtonType.YES);
            Optional<ButtonType> result = avisa.showAndWait();
            if (result.orElse(ButtonType.NO)==ButtonType.YES)
            {
                listaDePersona.clear();
                actualizarLista();
            }
        });
        actualizarLista();
        primaryStage.setScene(new Scene(h,300,300));
    }    
    
}
