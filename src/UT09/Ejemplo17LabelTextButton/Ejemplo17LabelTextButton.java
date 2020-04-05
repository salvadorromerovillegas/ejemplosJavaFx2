package UT09.Ejemplo17LabelTextButton;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Ejemplo de uso de etiquetas y diferentes tipo de botones.
 * @author Salvador Romero
 */
public class Ejemplo17LabelTextButton extends Application {

    public static void main (String ... args)
    {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene myScene=new Scene(contentBuilder());
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    private Parent contentBuilder() {
        
        //Configuración de etiqueta
        Label miLabel = new Label () 
        {{
            setLayoutX(10);
            setLayoutY(10);
            setText("Etiqueta de ejemplo.");                 
        }};
        
        //Configuración de botón cancelar
        Button b1=new Button("_Cancelar") 
        {{ 
            setLayoutX(10);
            setLayoutY(100);
            setCancelButton(true);
            setOnAction((e)->miLabel.setText("Boton Cancelar."));
        }};
        
        //Configuración de botón aceptar
        Button b2=new Button("_Aceptar") 
        {{ 
            setLayoutX(150);
            setLayoutY(100);
            setDefaultButton(true);
            setOnAction((e)->miLabel.setText("Boton Aceptar."));
        }};
                
        //Configuración de imagen
        ImageView iv1 = new ImageView(new Image(getClass().getResource("exit.png").toExternalForm())) {{                        
            preserveRatioProperty().set(true);
            fitHeightProperty().set(30);            
        }};
        
        //Configuración de botón salir
        Button b3=new Button("_Salir") {{
            setGraphic(iv1);
            setContentDisplay(ContentDisplay.TOP);
            setLayoutX(300);
            setLayoutY(100);            
            setOnAction((__)->Platform.exit());
        }};
        
        //Configuración de panel retornado.
        return new Pane() {{           
            getChildren().addAll(b1,b2,b3,miLabel);    
            setMinWidth(400);
            setMinHeight(180);
        }};
    }
    
}
