
package UT09.Ejemplo10OrganizandoVistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como se puede organizar el código para separar
 * una vista de información del resto... haciendo nuestro código mucho más 
 * claro.
 * @author Salvador Romero
 */
public class Ejemplo10OrganizandoVistas extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo10OrganizandoVistas.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 10: organizando vistas.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
      
    /* Al separar el código de la barra como una vista. */
    public Scene crearScenePrincipal ()
    {
        VBox sp=new VBox ();           
        
        sp.setPadding(new Insets(0,0,5,0));
        sp.setSpacing(5);
        
        for (int i=10;i<=400;i+=40)
        {
            BarraView bv=new BarraView(i, 20);            
            sp.getChildren().add(bv);            
        }
        
        Scene s=new Scene(sp,500,300);
        return s;
    }       
    
    
}
