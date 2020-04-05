/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo15LayoutTilePane;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Salvador Romero
 */
public class Ejemplos15LayoutTilePane extends Application {
    public static void main(String[] args) {
        Application.launch(Ejemplos15LayoutTilePane.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int filas=5;
        final int columnas=5;
        final double ancho=30;
        final double alto=30;        
        
        final double stepcolor=255f/(filas*columnas);        
                
                
        TilePane tilePane=new TilePane();
        
        tilePane.setTileAlignment(Pos.CENTER);        
     
        
        for (int i=0;i<columnas;i++){
            for (int j=0;j<filas;j++) {
                int c=(int)(stepcolor*columnas*i + j*stepcolor);
                Rectangle rb=new Rectangle(ancho, alto, Color.rgb( c, c , c));
                System.out.println(rb.toString());
                tilePane.getChildren().add(rb);
            }
        }       
                        
        Scene s=new Scene(tilePane,ancho*columnas,alto*filas);
        primaryStage.setScene(s);
        primaryStage.setTitle("Ejemplo de uso de TiledPane 8");
        primaryStage.show();
             
    }
}
