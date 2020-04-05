package UT09.Ejemplo14UsandoClasesCSS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como usar un archivo CSS para formatear elementos, pero
 * no usando un identificador, sino una clase, que permite aplicar un mismo
 * formato a más de un elemento.
 * 
 * Consulta <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html" target="_blank">
 * la referencia de css</a>.
 * 
 * 
 * @author Salvador Romero Villegas
 */
public class Ejemplo14UsandoClasesCSS extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo14UsandoClasesCSS.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 14: Usando clases CSS.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
        
    
    public Scene crearScenePrincipal ()
    {
        VBox contenedorPrincipal=new VBox ();           
        
        
        Scene s=new Scene(contenedorPrincipal,500,300);

        String urlDelRecurso=getClass().getResource("archivo.css").toExternalForm();
        s.getStylesheets().add(urlDelRecurso);
        
        /* 1º Asociamos una clase al elemento. */
        contenedorPrincipal.setId("contenedorPrincipal");
        
        Text cabecera=new Text("Hoy es un buen día para comenzar");
        /* 2º Establecemos la clase de la cabecera (titulo en este caso)*/
        cabecera.getStyleClass().add("titulo");
        Text cuerpo1=new Text("a ver las cosas de forma diferente.");
        Text cuerpo2=new Text("¡¡Todo puede ir a mejor!!");
        
        
        /* 3º Establecemos la clase del texto normal. */
        cuerpo1.getStyleClass().add("textonormal");
        cuerpo2.getStyleClass().add("textonormal");
        contenedorPrincipal.getChildren().add(cabecera);
        contenedorPrincipal.getChildren().add(cuerpo1);
        contenedorPrincipal.getChildren().add(cuerpo2);
               
        return s;
    }       
    
    
}
