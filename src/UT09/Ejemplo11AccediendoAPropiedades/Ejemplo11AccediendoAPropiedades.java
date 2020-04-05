package UT09.Ejemplo11AccediendoAPropiedades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como exponer una propiedad de parte de una vista
 * para que pueda ser usada desde otra parte del código.
 * @author Salvador Romero
 */
public class Ejemplo11AccediendoAPropiedades extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo11AccediendoAPropiedades.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 11: Accediendo a propiedades.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
    
    /* 1º Creamos una lista que contendrá la lista de barras.*/
    private List<BarraView> listaDeBarras=new ArrayList<>();
        
    /* 2º En otro método, por ejemplo, en el constructor, rellenamos la lista
    de barras.*/
    public Ejemplo11AccediendoAPropiedades() {
        for (int i=10;i<=400;i+=40)
        {
            BarraView bv=new BarraView(i, 20);            
            listaDeBarras.add(bv);
        
        }
    }            
    
    public Scene crearScenePrincipal ()
    {
        VBox sp=new VBox ();           
        
        sp.setPadding(new Insets(0,0,5,0));
        sp.setSpacing(5);                               
        
        //3º Añadimos todos los objetos de la lista de barras
        sp.getChildren().addAll(listaDeBarras);            
     
        //5º Añadimos un botón a una botonera.
        HBox botonera=new HBox();
        
        Button sumar=new Button("Sumar anchos");
        botonera.getChildren().add(sumar);
        Button tamAleatorio=new Button("Tamaño aleatorio");
        botonera.getChildren().add(tamAleatorio);
        
        sp.getChildren().add(botonera);
        
        //6º Añadimos un manejador de "acción" al botón suma.
        sumar.setOnAction(new EventHandler<ActionEvent> ()
        {
            @Override
            public void handle(ActionEvent event) {
                double suma=0;
                for (BarraView barra:listaDeBarras)
                    suma+=barra.getAnchoBarra().doubleValue();
                Alert a=new Alert(AlertType.INFORMATION);
                a.setTitle("Suma de anchos de barras:");
                a.setHeaderText("Suma total de anchos!");
                a.setContentText("La suma total es "+suma);
                a.showAndWait();                
            }
            
        });
            
        //7º Añadimos un manejador de "acción" al botón tamAleatorio.
        tamAleatorio.setOnAction(new EventHandler<ActionEvent> ()
        {
            @Override
            public void handle(ActionEvent event) {
                double suma=0;
                Random r=new Random();
                for (BarraView barra:listaDeBarras)
                {
                    barra.getAnchoBarra().setValue((r.nextInt(40)+1)*10);
                }                                               
            }
        });
        
        Scene s=new Scene(sp,500,300);
        return s;
    }       
    
    
}
