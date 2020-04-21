package UT09.Ejemplo20ComunicacionEntreScenesFXML.dialog_add_person;

import UT09.Ejemplo20ComunicacionEntreScenesFXML.Main;
import UT09.Ejemplo20ComunicacionEntreScenesFXML.Persona;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Clase que encapsula la funcionalidad de un Dialog a medida
 * diseñado a través de FXML.
 * @author Salvador Romero Villegas
 */
public class DialogAddPerson extends Stage {
    
    private boolean cancelado=true;
    private Persona p;
         
    /**
     * Crea una instacia de este dialog personalizado.
     * @param parentStage 
     */
    public DialogAddPerson (Stage parentStage)
    {      
        //Cargamos el FXML y el controller del FXML.
        crearContenido();
        
        //Modalidad "MODAL": bloquear eventos para que no vayan a otras venanas
        initModality(Modality.APPLICATION_MODAL);
        //Establecemos que el propietario es la clase padre
        initOwner(parentStage.getOwner());        
        //No redimensionable
        resizableProperty().setValue(false);

    }
    
    /**
     * Cargamos el FXML y configuramos su controller
     * @return true si fue bien la carga y false en caso contrario
     */
    private boolean crearContenido()
    {
        boolean ok=false;
         //Obtenemos un recurso en el directorio de la clase actual.
        URL urlDelRecurso=getClass().getResource("dialog_add_persona.fxml");
        
        //Creamos una instancia de FXMLLoader para cargar el recurso dada su localización (URL)
        FXMLLoader loader=new FXMLLoader(urlDelRecurso);               
        
        try {
        //Cargamos (loader.load()) el recurso / nodo contenedor.
        Parent root=loader.load();
        
        /* Obtenemos el controlador (previamente indicado en el FXML)
         con fx:controller="..." */
        DialogAddPersonController rc=loader.getController();        
        
        //Le decimos al controlador cual es esta instancia
        rc.setDialogAddPerson(this);
        
        
        //Establecemos el nodo raiz de la escena como el contenedor anterior
        Scene scene= new Scene(root);                
        
        //Establecemos la escena de este escenario como la anterior.        
        setScene(scene);
        
        setTitle("Lectura datos de nueva persona.");
                
        ok=true;
        } 
        catch (IOException e)
        {
            Main.mostrarError("No se pudo cargar dialog_add_persona.fxml");
        }          
        return ok;
    }                 

    /**
     * Método cerrar que cerrará este dialog. 
     * Fíjate que es visibiliad "package" para que solo pueda ser invocado
     * por clases de este package, concretamente, por DialogAddPersonController.
     */
    void cerrar()
    {
        close();
    }
    
    /**
     * Método setCancelado, que permitirá a DialogAddPersonController 
     * indicar que si la operación fue cancelada o no. 
     * Fíjate que es visibiliad "package" para que solo pueda ser invocado
     * por clases de este package, concretamente, por DialogAddPersonController.
     */
    void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

     /**
     * Método setPersona, que permitirá a DialogAddPersonController 
     * comunicar una instancia de persona con los datos proporcionados por el
     * usuario. 
     * Fíjate que es visibilidad "package" para que solo pueda ser invocado
     * por clases de este package, concretamente, por DialogAddPersonController.
     */
    void setPersona(Persona p) {
        this.p = p;
    }   
    
    /**
     * Método esCancelado que permitirá saber si, después de cerrado el dialog
     * fue una operación cancelada o no.
     * Fíjate que es "public" para permitir que se use desde la clase Main.
     * @return true si fue cancelado y false en caso contrario.
     */
    public boolean esCancelado()
    {
        return cancelado;
    }
    
    /**
     * Método getPersona que permitirá obtener los datos de la persona creada
     * (solo si esCancelado retornase false).
     * Fíjate que es "public" para permitir que se use desde la clase Main.
     * @return instancia de Persona o null
     */
    public Persona getPersona()
    {
        return p;
    }
    
}
