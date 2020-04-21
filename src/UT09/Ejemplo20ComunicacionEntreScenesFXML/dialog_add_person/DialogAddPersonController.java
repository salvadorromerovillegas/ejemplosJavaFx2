/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT09.Ejemplo20ComunicacionEntreScenesFXML.dialog_add_person;

import UT09.Ejemplo20ComunicacionEntreScenesFXML.Persona;
import static UT09.Ejemplo20ComunicacionEntreScenesFXML.Main.mostrarError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controlador para dialog_add_persona.fxml
 * @author Salvador Romero Villegas
 */
public class DialogAddPersonController {

    /**
     * Referencia privada al dialog que incluye al panel de este FXML
     */
    private DialogAddPerson dialogAddPerson;
        
    /**
     * Método visibilidad de paquete (para que solo sea invocado por DialogAddPerson)
     * que permitirá establecer cual es el Stage que usará este panel.
     * @param dialogAddPerson Instancia de DialogAddPerson que usará este panel
     */
    void setDialogAddPerson(DialogAddPerson dialogAddPerson)
    {
        this.dialogAddPerson=dialogAddPerson;
    }
    
    
    @FXML
    private TextField nombre;

    @FXML
    private TextField edad;

    /**
     * Manejo del evento "añadir persona". Se leen los datos y
     * si el dialogAddPerson es distinto de null, se invocan los métodos
     * de dicha clase para retornar los valores.
     * @param event Evento JavaFX
     */
    @FXML
    private void handleAddPerson(ActionEvent event) {
        try {            
            String nombre = this.nombre.getText();
            int edad = Integer.parseInt(this.edad.getText());
            if (nombre.length() == 0) {
                mostrarError("El nombre debe ser mayor de 0");
            } else if (edad <= 0) {
                mostrarError("Edad incorrecta");
            } else {
                Persona p = new Persona();
                p.setEdad(edad);
                p.setNombre(nombre);
                //Comunicación con la clase "que contiene este panel"
                if (dialogAddPerson!=null) {
                    dialogAddPerson.setCancelado(false);
                    dialogAddPerson.setPersona(p);
                    dialogAddPerson.cerrar();
                }
                
            }
        } catch (NumberFormatException e) {
            mostrarError("La edad es incorrecta.");
            this.edad.setText("");
        }
    }
  
    /**
     * Método invocado para cancelar esta inserción de datos..
     * @param event 
     */
    @FXML
    private void handleCancel(ActionEvent event) {
        if (dialogAddPerson!=null)
        {
            dialogAddPerson.setCancelado(true);
            dialogAddPerson.cerrar();
        }
    }
}
