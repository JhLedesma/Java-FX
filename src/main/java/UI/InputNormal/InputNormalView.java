package UI.InputNormal;

import BD.BufferRespuestas;
import BD.Excepciones.NoExisteObjetoConEsaQueryException;
import BD.Repositorios.RepoRespuestas;
import Model.Aspirante;
import Model.GestorScenas;
import Model.Respuesta;
import UI.ListaAspirantes.ItemListViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class InputNormalView implements FxmlView<InputNormalViewModel>
{
    @InjectViewModel protected InputNormalViewModel viewModel;

    @FXML private ScrollPane scrollP;
    @FXML StackPane stackPane;
    @FXML AnchorPane dialog;
    RadioButton botonClickeado;

    public void initialize()
    {
        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        GestorScenas.getStageApp().setOnCloseRequest(event -> {
            showDialog();
            event.consume();
        });
    }


    //-----------------------Dialog-------------------------//

    protected void showDialog()
    {
        stackPane.setVisible(true);
        dialog.setVisible(true);
    }

    @FXML protected void execBtnSi(MouseEvent mouseEvent)
    {
        guardar();
        Platform.exit();
        System.exit(0);
    }

    @FXML protected void execBtnNo(MouseEvent mouseEvent)
    {
        Platform.exit();
        System.exit(0);
    }


    //-----------------------RadioButton-------------------------//

    @FXML protected void onRadioButtonClick(MouseEvent event)
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

    private void recuperar()
    {
        BufferRespuestas.getInstance().recuperarRespuestas();
        BufferRespuestas.getInstance().getNumeroDeUltimaRespuesta();
        //Seteo al label de pregunta, el String de la ultima pregunta, para ello uso getNumeroDeUltimaRespuesta(), que me dice en que pregunta se quedo
        //Seteo todos los radioButton con sus respuestas marcadas, para ello uso las respuestas del buffer
    }

    private void guardar()
    {
        viewModel.guardar();
    }

}