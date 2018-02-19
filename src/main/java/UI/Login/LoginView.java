package UI.Login;

import com.jfoenix.controls.JFXPasswordField;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;

public abstract class LoginView {

    @FXML
    private JFXPasswordField campoContraseña;

    @InjectViewModel
    private LoginViewModel viewModel;


    //Este metodo evita bindear los botones para hacer un onClick
    public void ingresar(){

        viewModel.comprobarContraseña(campoContraseña.getText());

    }

    public void chequearEnter (javafx.scene.input.KeyEvent keyEvent){

        if(keyEvent.getCode() == KeyCode.ENTER) {

            ingresar();

        }

    }




}
