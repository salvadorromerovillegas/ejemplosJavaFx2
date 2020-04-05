
package UT09;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como se puede asociar un manejador de eventos
 * también a un contenedor. En este caso, el evento se asocia a cada "HBox"
 * que contiene la dupla: "texto - barra".
 * En este ejemplo al hacer clic en cualquier parte del contenedor (texto, 
 * barra, o resto de la línea), la barra se incrementa de tamaño.
 * 
 * @author Salvador Romero
 */
public class Ejemplo8EventHandlerEnUnContenedor extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo8EventHandlerEnUnContenedor.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 8: manejar eventos en el contenedor.");
                
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
    
    private EventHandler rellenarFormaAzul=
            (event) -> {
                    if (event.getSource() instanceof Rectangle)
                    {
                        Rectangle r=(Rectangle)event.getSource();
                        r.fillProperty().setValue(Color.BLUE);
                    }
            };
   
    private EventHandler rellenarFormaVerde=
            (event) -> {
                    if (event.getSource() instanceof Shape)
                    {
                        Shape shape=(Rectangle)event.getSource();
                        shape.fillProperty().setValue(Color.GREEN);
                    }                
            };
    
    //1º Creamos un manejador común para el evento en el contenedor tipo HBox
    private EventHandler aumentarDeTamañoRectangulo = new EventHandler() {
        @Override
        public void handle(Event event) {
            if (event.getSource() instanceof HBox) { //Solo actuamos si el contenedor es un HBox
                HBox hBox = (HBox) event.getSource();

                if (hBox.getChildren().size() == 2) { // Y solo seguimos si tiene dos hijos
                    Node firstNode = hBox.getChildren().get(0);
                    Node secondNode = hBox.getChildren().get(1);
                    // Por último solo seguimos si los hijos son un rectangulo y un texto
                    if (firstNode instanceof Text && secondNode instanceof Rectangle) { 
                        Text t=(Text)firstNode;
                        Rectangle r=(Rectangle)secondNode;
                        double width=r.getWidth();
                        if (width<400) //Incrementamos el ancho si es menor de 400
                        {
                            width+=10;
                            //Modificamos la propiedad "Ancho" del rectangulo
                            r.widthProperty().setValue(width);
                            //Modificamos la propiedad "Texto" del rectangulo
                            t.textProperty().setValue(String.format("Ancho %d: ",(int)width));
                        }
                    }
                }
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
            
            r.setOnMouseEntered(rellenarFormaAzul);
            
            r.setOnMouseExited(rellenarFormaVerde);
            
            HBox miHBox=new HBox();
            
            miHBox.getChildren().add(t);
            miHBox.getChildren().add(r);
            
            //2º Establecemos el manejador de evento "click" para el contenedor.
            miHBox.setOnMouseClicked(aumentarDeTamañoRectangulo);
                        
            vBox.getChildren().add(miHBox);
        }        
    }
    
    
    
}
