package UT09.Ejemplo12MiPrimerCSS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como usar CSS en un elemento concreto usando 
 * el método setStyle.
 * 
 * Consulta <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html" target="_blank">
 * la referencia de css</a>.
 * 
 * @author Salvador Romero Villegas
 */
public class Ejemplo12MiPrimerCSS extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo12MiPrimerCSS.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 12: Ejemplo de uso de CSS usando setStyle.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
        
    
    public Scene crearScenePrincipal ()
    {
        VBox sp=new VBox ();           
        
        
        Scene s=new Scene(sp,500,300);
        
        sp.setStyle("-fx-background-color: #EEFFDD; -fx-alignment: center;");
        Text cabecera=new Text("Hoy es un buen día para comenzar");
        cabecera.setStyle("-fx-font-size:30; -fx-fill: #555555");
        Text cuerpo=new Text("a ver las cosas de forma diferente.");
        cuerpo.setStyle("-fx-font-size:15; -fx-fill: #666666;");
        sp.getChildren().add(cabecera);
        sp.getChildren().add(cuerpo);
        
        return s;
    }       
    
    
}
