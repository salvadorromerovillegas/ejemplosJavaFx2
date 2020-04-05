/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra como crear un Scene, con un 
 * contenedor simple (VBox), que irá poniendo en una columna los
 * elementos añadidos (rectángulos en este caso).
 * @author Salvador Romero
 */
public class Ejemplo4ContenedorDentroDeContenedor extends Application {

    public static void main(String[] args) {
        
        Application.launch(Ejemplo4ContenedorDentroDeContenedor.class,args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo 4: Contenedores dentro de contenedores.");
                
        primaryStage.setScene(crearScenePrincipal());
        
        primaryStage.show();
    }         
      
    public Scene crearScenePrincipal ()
    {
        VBox sp=new VBox ();           
        
        //Establecemos un borde inferior de 5 
        sp.setPadding(new Insets(0,0,5,0));
        //Establecemos la separación entre un elemento y el siguiente de 5
        sp.setSpacing(5);
        
        insertarRectangulosHorizontales(sp);
        
        Scene s=new Scene(sp);        
        return s;
    }
    
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
            //1º Creamos un nodo hoja tipo "texto"
            Text t=new Text(String.format("Ancho %d: ",i));
            //2º Creamos un nodo hoja tipo "rectangulo"
            Rectangle r=new Rectangle(ancho+i,alto,Color.GREEN);
            
            //3º Creamos el contenedor donde vamos a meter los dos nodos hoja anteriores
            HBox miHBox=new HBox();

            //4º Añadimos los nodos hojas, al contenedor anterior (miHBox)
            miHBox.getChildren().add(t);
            miHBox.getChildren().add(r);
            
            //5º Añadimos el contenedor creado al contenedor principal.
            vBox.getChildren().add(miHBox);
        }
        
    }
    
}
