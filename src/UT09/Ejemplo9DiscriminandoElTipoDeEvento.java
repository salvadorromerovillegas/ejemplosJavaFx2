/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
 * Ejemplo que muestra como se puede asociar un manejador de eventos
 * también a un contenedor, discriminando el tipo de manejador.
 * En este caso, el evento se asocia a cada "HBox"
 * que contiene la dupla: "texto - barra".
 * 
 * En este ejemplo al hacer clic en cualquier parte del contenedor con el
 * botón primario (generalmente el izquierdo) la barra se incrementa,
 * y al hacer clic con el botón derecho, la barra se decrementa.
 * 
 * @author Salvador Romero
 */
public class Ejemplo9DiscriminandoElTipoDeEvento extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo9DiscriminandoElTipoDeEvento.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 9: discriminar el tipo de evento.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
      
    public Scene crearScenePrincipal ()
    {
        VBox sp=new VBox ();           
        
        sp.setPadding(new Insets(0,0,5,0));
        sp.setSpacing(5);
        
        insertarRectangulosHorizontales(sp);
        
        Scene s=new Scene(sp,500,300);
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
    
    //1º Indicamos usando un especificador de tipo ("<MouseEvent>")
    // que este manejador será concretamente solo para eventos de ratón.
    private EventHandler aumentarDeTamañoRectangulo = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {            
            if (event.getSource() instanceof HBox) {
                HBox hBox = (HBox) event.getSource();

                if (hBox.getChildren().size() == 2) { 
                    Node firstNode = hBox.getChildren().get(0);
                    Node secondNode = hBox.getChildren().get(1);
                    if (firstNode instanceof Text && secondNode instanceof Shape) { 
                        Text t=(Text)firstNode;
                        Rectangle r=(Rectangle)secondNode;
                        double width=r.getWidth();
                        double increment=0;
                        //2º Ya podemos acceder propiedades específicas del evento.
                        if (event.getButton() != null)                            
                            switch (event.getButton()) {
                                case PRIMARY:
                                    increment=10;
                                    break;
                                case SECONDARY:
                                    increment=-10;
                                    break;
                                default:
                                    increment=0;
                                    break;
                            };
                        //Incrementamos el ancho solo si no sobrepasamos [10,400]
                        if (width>10 && increment<0 || width<400 && increment>0) 
                        {
                            width+=increment;
                            
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
