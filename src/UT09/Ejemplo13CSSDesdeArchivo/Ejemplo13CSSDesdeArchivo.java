package UT09.Ejemplo13CSSDesdeArchivo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como usar un archivo CSS para formatear elementos.
 * 
 * Consulta <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html" target="_blank">
 * la referencia de css</a>.
 * 
 * 
 * @author Salvador Romero Villegas
 */
public class Ejemplo13CSSDesdeArchivo extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo13CSSDesdeArchivo.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 13: Ejemplo de uso de un archivo CSS.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
        
    
    public Scene crearScenePrincipal ()
    {
        VBox contenedorPrincipal=new VBox ();           
        
        
        Scene s=new Scene(contenedorPrincipal,500,300);
        /*
        * 1º Obtenemos una URL del recurso que podremos usar más adelante
        * Esto es especialmente útil cuando el archivo css está en 
        * el mismo paquete, o una ruta relativa al paquete. 
        */
        String urlDelRecurso=getClass().getResource("archivo.css").toExternalForm();
        /*
        * 2º Añadimos la hoja de estilos.
        */
        s.getStylesheets().add(urlDelRecurso);
        
        /* 3º Establecemos un ID al contenedor principal */
        contenedorPrincipal.setId("contenedorPrincipal");
        Text cabecera=new Text("Hoy es un buen día para comenzar");
        /* 4º Establecemos un ID a la cabecera*/
        cabecera.setId("cabecera");
        Text cuerpo=new Text("a ver las cosas de forma diferente.");
        /* 5º Establecemos un ID al cuerpo*/
        cuerpo.setId("cuerpo");
        contenedorPrincipal.getChildren().add(cabecera);
        contenedorPrincipal.getChildren().add(cuerpo);
               
        return s;
    }       
    
    
}
