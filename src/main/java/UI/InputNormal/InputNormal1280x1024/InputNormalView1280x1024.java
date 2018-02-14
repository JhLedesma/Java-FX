package UI.InputNormal.InputNormal1280x1024;


import UI.InputNormal.InputNormalViewModel;;
import com.jfoenix.controls.JFXRadioButton;
import de.saxsys.mvvmfx.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class InputNormalView1280x1024 implements FxmlView<InputNormalViewModel>, Initializable {


    RadioButton botonClickeado;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

    }


    @FXML private ScrollPane scrollP;


    public void onRadioButtonClick(MouseEvent event)
    {
        botonClickeado = (RadioButton)event.getSource();

        botonClickeado.getParent().getChildrenUnmodifiable().forEach(x -> setEstado((RadioButton) x));

    }

    private void setEstado(RadioButton button) {

        if(button != botonClickeado){

            button.setSelected(false);

        }

    }

}
