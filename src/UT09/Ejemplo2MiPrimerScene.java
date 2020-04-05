package UT09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como crear un primer Scene (vacío), con un 
 * contenedor simple (HBox).
 * @author Salvador Romero Villegas
 */
public class Ejemplo2MiPrimerScene extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo2MiPrimerScene.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Ejemplo 2: Un scene con un contenedor VBox.");        
        
        //3º Al método setScene le pasamos como parámetro el Scene asociado
        Scene scenePrincipal=crearScenePrincipal();       
        primaryStage.setScene(scenePrincipal);
        
        primaryStage.show();
    }
 
    /**
     * Método que construye la escena principal.
     * @return Instancia de Scene con la escena principal.
     */
    public Scene crearScenePrincipal ()
    {
        //1º Creamos el nodo raíz, que debe ser un contenedor.        
        VBox vBox=new VBox();                   
                
        //2º Creamos el scene donde metermos dicho stack pane.        
        Scene s=new Scene(vBox);        
               
                
        return s;
    }
    
}
