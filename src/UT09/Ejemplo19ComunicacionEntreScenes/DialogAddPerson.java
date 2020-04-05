/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo19ComunicacionEntreScenes;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Salvador Romero
 */
public class DialogAddPerson extends Stage {
    
    private TextField input1=new TextField();
    private TextField input2=new TextField();
    boolean cancelado=true;
    Persona p;
    
    
    public DialogAddPerson (Stage parentStage)
    {        
        crearContenido();
        
        //Modalidad "MODAL": bloquear eventos para que no vayan a otras venanas
        initModality(Modality.APPLICATION_MODAL);
        //Establecemos que el propietario es la clase padre
        initOwner(parentStage.getOwner());        
        //No redimensionable
        resizableProperty().setValue(false);

    }
    
    private void crearContenido()
    {
        GridPane gp=new GridPane();        
        gp.setVgap(10);
        gp.setHgap(10);
        gp.add(new Label("Nombre:"),0,0);
        gp.add(input1, 0, 1);
        gp.add(new Label("Edad:"),1,0);
        gp.add(input2, 1, 1);
     
        Button accept=new Button("_Aceptar"); 
        accept.setDefaultButton(true);
        accept.setOnAction(a->this.aceptar());
        
        Button cancel=new Button("_Cancelar");        
        cancel.setCancelButton(true);        
        cancel.setOnAction(a->this.close());
        
        gp.add(accept, 0, 2);
        gp.add(cancel, 1, 2);
                
        Scene s=new Scene(gp);               
        setScene(s);
    }
    
    private void aceptar()
    {
        try {
            String nombre=input1.getText();
            int edad=Integer.parseInt(input2.getText());
            if (nombre.length()==0)
            {
                mostrarError("El nombre debe ser mayor de 0");
            }
            else if (edad<=0)
            {
                mostrarError("Edad incorrecta");
            }
            else
            {
                p=new Persona();
                p.setEdad(edad);
                p.setNombre(nombre);
                cancelado=false;
                close();
            }
        }
        catch (NumberFormatException e) {
            mostrarError("La edad es incorrecta.");
            input2.setText("");
        }
    }                
    
    private void mostrarError(String error)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error en los datos.");        
        alert.setContentText(error);
        alert.showAndWait();
    }
        
    public boolean esCancelado()
    {
        return cancelado;
    }
    
    public Persona getPersona()
    {
        return p;
    }
    
}
