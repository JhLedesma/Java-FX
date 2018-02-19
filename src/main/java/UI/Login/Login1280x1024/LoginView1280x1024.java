package UI.Login.Login1280x1024;

import Model.GestorScenas;
import UI.Login.LoginViewModel;
import com.jfoenix.controls.JFXPasswordField;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginView1280x1024 implements FxmlView<LoginViewModel> {

    @FXML private JFXPasswordField campoContraseña;

    @InjectViewModel
    private LoginViewModel viewModel;

    public void initialize() {

    }

    //Este metodo evita bindear los botones para hacer un onClick
    public void ingresar(){

        viewModel.comprobarContraseña(campoContraseña.getText());

    }

}