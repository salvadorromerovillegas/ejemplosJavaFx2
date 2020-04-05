package UT09;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra el punto de partida de una aplicación JavaFx.
 * @author Salvador Romero Villegas
 */
public class Ejemplo1ExtenderApplication extends Application {

    public static void main(String[] args) {
        /* Lanzar la aplicación JavaFX. Al método launch se le pasa como 
        argumento la clase que implementa la interfaz 
        "Application" y un array con los argumenos. 
        La clase que extiende la clase "Application" puede ser ella misma 
        u otra diferente. */        
        Application.launch(Ejemplo1ExtenderApplication.class,args);
                                       
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        /* Establecemos el título de la ventana. */
        primaryStage.setTitle("Ejemplo 1: Aplicación sin un Scene.");
        
        /* Mostramos la ventana (sin nada dentro). */
        primaryStage.show();
    }
    
}
