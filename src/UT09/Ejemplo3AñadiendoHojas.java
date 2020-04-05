
package UT09;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como crear un Scene, con un 
 * contenedor simple (VBox). El VBox irá poniendo uno encima de otro los
 * elementos añadidos (rectángulos en este caso).
 * @author Salvador Romero
 */
public class Ejemplo3AñadiendoHojas extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo3AñadiendoHojas.class,args);
    }
    
    BooleanProperty resizable;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 3: añadiendo hojas a un contenedor VBox.");
                
        resizable=primaryStage.resizableProperty();
        
        primaryStage.setScene(crearScenePrincipal());        
        
        primaryStage.show();
    }         
      
    public Scene crearScenePrincipal ()
    {
        VBox vBox=new VBox ();           
        
        //Establecemos un borde inferior del contenedor a 5 
        vBox.setPadding(new Insets(0,0,5,0));
        //Establecemos la separación entre un elemento y el siguiente de 5
        vBox.setSpacing(5);
        
        vBox.setAlignment(Pos.CENTER);
        
        resizable.setValue(false);
        
        insertarRectangulosHorizontales(vBox);
        
        Scene s=new Scene(vBox);        
        return s;
    }
    
    /**
     * Método que inserta 10 rectángulos en el VBox pasado como parámetro.
     * @param sp VBox donde insertar las barras.
     */
    public void insertarRectangulosHorizontales(VBox sp)
    {
        double ancho=0;        
        double alto=20;
                
        for (int i=10;i<=440;i+=40)
        {
            Rectangle r=new Rectangle(ancho+i,alto,Color.GREEN);
            sp.getChildren().add(r);
        }
        
    }
    
}
