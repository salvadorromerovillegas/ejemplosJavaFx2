package UT09;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como manejar eventos de un nodo (este caso, rectángulo),
 * usando un mismo manejador para todo. 
 * @author Salvador Romero
 */
public class Ejemplo6EventHandlerEnComun extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo6EventHandlerEnComun.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 6: Un event handler para varios nodos.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
      
    public Scene crearScenePrincipal ()
    {
        VBox sp=new VBox ();           
        
        sp.setPadding(new Insets(0,0,5,0));
        sp.setSpacing(5);
        
        insertarRectangulosHorizontales(sp);
        
        Scene s=new Scene(sp);        
        return s;
    }
    
    private EventHandler rellenarFormaAzul=new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {                    
                    if (event.getSource() instanceof Rectangle)
                    {
                        Rectangle r=(Rectangle)event.getSource();
                        r.fillProperty().setValue(Color.BLUE);
                    }
                }
            };
   
    private EventHandler rellenarFormaVerde=new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {                    
                    if (event.getSource() instanceof Shape)
                    {
                        Shape shape=(Shape)event.getSource();
                        shape.fillProperty().setValue(Color.GREEN);
                    }
                }
            };
    
    /**
     * Método que inserta contenedores dentro del VBox pasado como parámetro.
     * @param vBox VBox donde insertar las barras.
     */
    public void insertarRectangulosHorizontales(VBox vBox)
    {
        double ancho=0;        
        double alto=20;
                
        for (int i=10;i<=400;i+=40)
        {
               
            Text t=new Text(String.format("Ancho %d: ",i));            
            Rectangle r=new Rectangle(ancho+i,alto,Color.GREEN);            
            
            /*
             * 1º Añadimos un manejador para el evento "setOnMouseEntered"
             * es decir, para cuando entra el ratón en el área del rectángulo.
             */
            r.setOnMouseEntered(rellenarFormaAzul);
            
            /*
             * 2º Añadimos un manejador para el evento "setOnMouseExited"
             * es decir, para cuando sale el ratón en el área del rectángulo.
             */            
            r.setOnMouseExited(rellenarFormaVerde);
            
            HBox miHBox=new HBox();
            
            miHBox.getChildren().add(t);
            miHBox.getChildren().add(r);
            
            //5º Añadimos el contenedor creado al contenedor principal.
            vBox.getChildren().add(miHBox);
        }        
    }
    
    
    
}
