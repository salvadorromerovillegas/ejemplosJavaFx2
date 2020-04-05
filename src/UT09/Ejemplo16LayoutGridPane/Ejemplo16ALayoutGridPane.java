package UT09.Ejemplo16LayoutGridPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Ejemplo que inserta 25 rectángulos de diferente color (escala de grises)
 * en una tabla de 5x5.
 * @author Salvador Romero
 */
public class Ejemplo16ALayoutGridPane extends Application {
    public static void main(String[] args) {
        Application.launch(Ejemplo16ALayoutGridPane.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int filas=5;
        final int columnas=5;
        final double ancho=30;
        final double alto=30;        
        
        final double stepcolor=255f/(filas*columnas);                        
        
        /* Creamos el GridPane donde vamos a insertar los rectángulos */
        GridPane gridPane=new GridPane();              
        
        /* Vamos insertando un rectángulo en cada posición del grid 5x5*/
        for (int i=0;i<columnas;i++){            
            for (int j=0;j<filas;j++) {
                int c=(int)(stepcolor*columnas*i + j*stepcolor);
                Rectangle rb=new Rectangle(ancho, alto, Color.rgb( c, c , c));
                gridPane.add(rb,i,j);
            }
        }       
               
        /* Creamos un Scene y la añadimos al Stage. */
        Scene s=new Scene(gridPane,ancho*columnas + 100,alto*filas + 100);
        primaryStage.setScene(s);
        primaryStage.setTitle("Ejemplo de uso de GridPane (sin constraints)");
        primaryStage.show();
             
    }
}
