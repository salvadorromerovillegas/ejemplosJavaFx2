package UT09.Ejemplo16LayoutGridPane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Ejemplo que inserta 25 rectángulos de diferente color (escala de grises) en
 * una tabla de 5x5. Cada rectángulo queda centrado y distribuido tanto
 * horizontal como verticalmente.
 *
 * @author Salvador Romero
 */
public class Ejemplo16BLayoutGridPane extends Application {
    
    public static void main(String[] args) {
        Application.launch(Ejemplo16BLayoutGridPane.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int filas=5;
        final int columnas=5;
        final double ancho=30;
        final double alto=30;        
        
        final double stepcolor=255f/(filas*columnas);                        
                
        GridPane gridPane=new GridPane();
        
        /* Hacemos cada columna de tamaño dinámico */
        for (int i=0;i<columnas;i++){            
            ColumnConstraints columnConstraint=new ColumnConstraints();            
            columnConstraint.setHgrow(Priority.ALWAYS);
            columnConstraint.setHalignment(HPos.CENTER);
            gridPane.getColumnConstraints().add(columnConstraint);            
        }
        
        /* Hacemos cada fila de tamaño dinámico */
        for (int i=0;i<filas;i++){            
            RowConstraints rowConstraint=new RowConstraints();            
            rowConstraint.setVgrow(Priority.ALWAYS);
            rowConstraint.setValignment(VPos.CENTER);
            gridPane.getRowConstraints().add(rowConstraint);            
        }
        
        /* Vamos insertando un rectángulo en cada posición del grid 5x5*/
        for (int i=0;i<columnas;i++){            
            for (int j=0;j<filas;j++) {
                int c=(int)(stepcolor*columnas*i + j*stepcolor);
                Rectangle rb=new Rectangle(ancho, alto, Color.rgb( c, c , c));
                gridPane.add(rb,i,j);
            }
        }       
                        
        /* Creamos un Scene y la añadimos al Stage. */
        Scene s=new Scene(gridPane,ancho*columnas+100,alto*filas+100);
        primaryStage.setScene(s);
        primaryStage.setTitle("Ejemplo de uso de GridPane con Constraints");
        primaryStage.show();
             
    }
}
