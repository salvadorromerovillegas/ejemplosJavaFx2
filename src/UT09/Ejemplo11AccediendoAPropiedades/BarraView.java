/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo11AccediendoAPropiedades;

import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 * Creamos una vista (contenedor con más objetos). 
 * Esta vista será final para que no se puedan crear hijas de ella.
 * @author Salvador Romero
 */
public final class BarraView extends HBox {
        
    private Text t;
    private Rectangle r;
    
    /* Al ser una clase aparte podemos simplifificar este manejador, 
    dado que es private y estamos asegurando que no se usará en un lugar 
    incorrecto. Quitamos "verificaciones". */
    private static EventHandler rellenarFormaAzul=
            (event) -> {
                        Rectangle r=(Rectangle)event.getSource();
                        r.fillProperty().setValue(Color.BLUE);                    
            };
   
    /* En este manejador hacemos lo mismo, lo simplificamos. */
    private static EventHandler rellenarFormaVerde=
            (event) -> {
                        Shape shape=(Rectangle)event.getSource();
                        shape.fillProperty().setValue(Color.GREEN);                    
            };
    

    private static EventHandler aumentarDeTamañoRectangulo = new EventHandler<MouseEvent>() {
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
    
    public BarraView (double ancho, double alto)
    {         
         super();         
         t=new Text(String.format("Ancho %d: ",(int)ancho));                     
         r=new Rectangle(ancho,alto,Color.GREEN);         
         r.setOnMouseEntered(rellenarFormaAzul);                     
         r.setOnMouseExited(rellenarFormaVerde);         
         this.setOnMouseClicked(aumentarDeTamañoRectangulo);         
         getChildren().addAll(t,r);
    }
    
    
    /* 4º Creamos un método para acceder a la propiedad "width" de 
    cada barra. */
    public DoubleProperty getAnchoBarra ()
    {
        return r.widthProperty();
    }
    
}
