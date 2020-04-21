package rentaautos.fx.Menu;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rentaautos.bl.Usuario;
import rentaautos.fx.RentaAutosFX;

public class SidePanelController implements Initializable {

    @FXML
    JFXListView listView;
    
    private AbrirFormularioCallback callback;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usuarioAutenticado=RentaAutosFX.getUsuarioAutenticado();
        String role=usuarioAutenticado.getRole();
        
        switch(role){
            case "administrador":{
        listView.getItems().add(new Label("Automoviles"));
        listView.getItems().add(new Label("Facturas"));
        listView.getItems().add(new Label("Reporte de Automoviles"));   
        listView.getItems().add(new Label("Reporte de Facturas"));
                break;
            }
            case "cajero":{
                listView.getItems().add(new Label("Facturas"));
                listView.getItems().add(new Label("Reporte de Facturas"));
                break;
            }
            case "inventario":{
                listView.getItems().add(new Label("Automoviles"));
                listView.getItems().add(new Label("Reporte de Automoviles"));
                break;
            }
        }
        
        
        listView.getItems().add(new Label("Cerrar Sesión"));
        listView.getItems().add(new Label("Salir"));   
        
        listView.setOnMouseClicked(event -> {
            Label label = (Label) listView.getSelectionModel().getSelectedItem();
            
            if (label.getText().equals("Salir")) {
                System.exit(0);
            } else {
                callback.abrirFormulario(label.getText());    
            }           
        });
    }

    public void setCallback(AbrirFormularioCallback callback) {
        this.callback = callback;
    }
}
