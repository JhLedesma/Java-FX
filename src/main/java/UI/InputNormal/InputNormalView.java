package UI.InputNormal;

import BD.BufferRespuestas;
import BD.Excepciones.NoExisteObjetoConEsaQueryException;
import BD.Excepciones.NoExisteObjetoConEseNombreException;
import BD.Repositorios.RepoPreguntas;
import BD.Repositorios.RepoRespuestas;
import Model.Aspirante;
import Model.GestorScenas;
import Model.Pregunta;
import Model.Respuesta;
import UI.ListaAspirantes.ItemListViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.application.Platform;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public abstract class InputNormalView implements FxmlView<InputNormalViewModel>
{
    @InjectViewModel protected InputNormalViewModel viewModel;

    @FXML private ScrollPane scrollP;
    @FXML private AnchorPane anchorPaneDelScroll;
    @FXML StackPane stackPane;
    @FXML AnchorPane dialog;
    @FXML private Label lblNumeroPregunta;
    @FXML private Label lblPregunta;
    @FXML private JFXButton btnVerdadero;
    @FXML private JFXButton btnFalso;
    @FXML private JFXButton btnNoContesta;
    @FXML private JFXButton btnPreguntaAnterior;
    @FXML private JFXButton btnPreguntaSiguiente;

    RadioButton botonClickeado;

    public void initialize() throws NoExisteObjetoConEseNombreException {
        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        GestorScenas.getStageApp().setOnCloseRequest(event -> {
            showDialog();
            event.consume();
        });

            recuperar();

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
        noGuardar();
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

    //-----------------------Guardar y Recuperar-------------------------//

    private void recuperar() throws NoExisteObjetoConEseNombreException {

            if(GestorScenas.getPreferenciasDeUsuario().get("GUARDADO","1").equals("1"))
            {

            BufferRespuestas.getInstance().recuperarRespuestas();
            int numeroUltimaPregunta = BufferRespuestas.getInstance().getNumeroDeUltimaRespuesta();
            String textUltimaPregunta = RepoPreguntas.getInstance().buscarObjeto(numeroUltimaPregunta).getTextPregunta();

            recuperarPregunta(numeroUltimaPregunta, textUltimaPregunta);
            //Seteo al label de pregunta, el String de la ultima pregunta, para ello uso getNumeroDeUltimaRespuesta(), que me dice en que pregunta se quedo

            restaurarRadioButtons();
            //Seteo todos los radioButton con sus respuestas marcadas, para ello uso las respuestas del buffer

            }

    }

    private void recuperarPregunta(int numeroUltimaPregunta, String textUltimaPregunta) {
        lblNumeroPregunta.setText(Integer.toString(numeroUltimaPregunta));
        lblPregunta.setText(textUltimaPregunta);
    }

    private void restaurarRadioButtons()
    {
        try
        {
            for(Node item : anchorPaneDelScroll.getChildren())
            {
                if(item instanceof Pane)
                {
                    for(Node pane : ((Pane) item).getChildren())
                    {
                        if(pane instanceof Pane)
                        {
                            Respuesta respuesta = BufferRespuestas.getInstance().getRespuesta(Integer.parseInt(pane.getId()));

                            for(Node radio : ((Pane) pane).getChildren())
                            {
                                if(radio instanceof RadioButton)
                                {
                                    recuperarRadioButton((RadioButton) radio, respuesta);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (NoExisteObjetoConEseNombreException e)
        {

        }
    }

    private void recuperarRadioButton(RadioButton radioButton, Respuesta respuesta)
    {
        if(radioButton.getText().equals(respuesta.getTextButton()))
        {
            radioButton.setSelected(true);
        }
        else
        {
            radioButton.setSelected(false);
        }
    }

//    private void recuperarRadioButton(ObservableList<RadioButton> radioButtons, Respuesta respuesta)
//    {
//        RadioButton radioButton = radioButtons.stream().filter(x->x.getText().equals(respuesta.getTextButton())).findFirst().get();
//        radioButton.setSelected(true);
//        setEstado(radioButton);
//    }

    private void guardar()
    {
        viewModel.guardar();
    }

    private void noGuardar()
    {
        viewModel.noGuardar();
    }

}