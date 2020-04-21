/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaautos.fx;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import rentaautos.bl.SeguridadServicio;
import rentaautos.bl.Usuario;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FormLoginController implements Initializable {

    @FXML
    JFXTextField txtUsuario;
    
    @FXML
    JFXPasswordField txtContrasena;
    
    SeguridadServicio seguridadservicio;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seguridadservicio=new SeguridadServicio();
    } 
    public void ingresar() throws IOException
    {
        String usuario=txtUsuario.getText();
        String contrasena=txtContrasena.getText();
        
        Usuario usuarioExistente=seguridadservicio.autenticar(usuario, contrasena);
        
        if(usuarioExistente!=null)
        {
           RentaAutosFX.setUsuarioAutenticado(usuarioExistente);
            
            
            Stage stage=RentaAutosFX.getStage();
         RentaAutosFX.stage= stage;
        Parent root = FXMLLoader.load(getClass()
                .getResource("/rentaautos/fx/Menu/main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Entrada al proyecto");
        stage.show();
        }else{
             Alert alert = new Alert(Alert.AlertType.ERROR, 
                    "Usuario o Contraseña incorrectas");
            alert.showAndWait();      
            
            txtUsuario.clear();
            txtContrasena.clear();
            txtUsuario.requestFocus();
        }
        
        
        
        //hasta aqui todo ok video 81 el que sigue es el 82
    }
    
}
