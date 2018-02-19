package UI.InputNormal;

import BD.Excepciones.NoExisteObjetoConEsaQueryException;
import BD.Repositorios.RepoRespuestas;
import Model.Aspirante;
import Model.Respuesta;
import UI.ListaAspirantes.ItemListViewModel;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class InputNormalView implements FxmlView<InputNormalViewModel>
{
    @InjectViewModel protected InputNormalViewModel viewModel;

    @FXML private ScrollPane scrollP;

    RadioButton botonClickeado;

    public void initialize()
    {
        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }


    public void onRadioButtonClick(MouseEvent event)
    {
        botonClickeado = (RadioButton)event.getSource();

        botonClickeado.getParent().getChildrenUnmodifiable().forEach(x -> setEstado((RadioButton) x));

        int numeroDeRespueta = Integer.parseInt(botonClickeado.getParent().getId());

        String textButton = botonClickeado.getText();

        viewModel.crearRespuesta(numeroDeRespueta, textButton);
    }

    private void setEstado(RadioButton button)
    {
        if(button != botonClickeado)
        {
            button.setSelected(false);
        }
    }

}