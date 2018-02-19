package UI.InputNormal;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class InputNormalView implements FxmlView<InputNormalViewModel> {

    RadioButton botonClickeado;

    public void initialize()
    {
        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }


    @FXML
    private ScrollPane scrollP;


    public void onRadioButtonClick(MouseEvent event)
    {
        botonClickeado = (RadioButton)event.getSource();

        botonClickeado.getParent().getChildrenUnmodifiable().forEach(x -> setEstado((RadioButton) x));

        crearRespuesta(botonClickeado);
    }

    private void setEstado(RadioButton button)
    {
        if(button != botonClickeado)
        {
            button.setSelected(false);
        }
    }

    private void crearRespuesta(RadioButton botonClickeado)
    {
        final String SI = "Si";
        final String NO = "No";
        final String NC = "N/C";

        switch (botonClickeado.getText())
        {
            case SI:
                //
                break;
            case NO:
                //
                break;
            default:
                //
                break;
        }

    }

}