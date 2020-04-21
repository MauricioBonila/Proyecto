/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaautos.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rentaautos.bl.Usuario;

/**
 *
 * @author dell
 */
public class RentaAutosFX extends Application {
    
    public static Boolean isSplashLoaded = false;
    static Stage stage;
    static Usuario usuario;
    
    public static Stage getStage(){
    
        return stage;
    }
    public static Usuario getUsuarioAutenticado()
    {
        return usuario;
    }
    public static void setUsuarioAutenticado(Usuario usuario)
    {
        RentaAutosFX.usuario=usuario;
    }
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        RentaAutosFX.stage= stage;
        Parent root = FXMLLoader.load(getClass()
        .getResource("/rentaautos/fx/FormLogin.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Renta de Autos");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
