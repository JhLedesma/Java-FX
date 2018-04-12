package UI.InputNormal;

import BD.BufferRespuestas;
import BD.Excepciones.NoExisteObjetoConEseNombreException;
import BD.Repositorios.RepoPreguntas;
import Model.GestorScenas;
import Model.Respuesta;
import Model.Escalas.ItemEscala;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public abstract class InputNormalView implements FxmlView<InputNormalViewModel>
{
    @InjectViewModel protected InputNormalViewModel viewModel;

    @FXML private ScrollPane scrollP;
    @FXML private AnchorPane anchorPaneDelScroll;
    @FXML StackPane stackPane;
    @FXML AnchorPane dialog;
    @FXML private Label lblNumeroPregunta;
    @FXML private Label lblPregunta;
    @FXML private JFXButton btnPreguntaAnterior;
    @FXML private JFXProgressBar progressBar;
    @FXML private Label labelProgressBar;

    RadioButton botonClickeado;
    ObservableList<Pane> panes = FXCollections.observableArrayList();
    int numeroLblPreguntaActual;


    public void initialize() throws NoExisteObjetoConEseNombreException
    {
        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        progressBar.progressProperty().setValue(0);

        cambiarConfiguracionDeCerrado();

        recuperar();

        generarListPane();

        ocultarBtnPreguntaAnteriorSiEsPrimerPregunta();

    }


    protected void generarListPane()
    {
        for(Node item : anchorPaneDelScroll.getChildren())
        {
            if(item instanceof Pane)
            {
                for(Node pane : ((Pane) item).getChildren())
                {
                    if(pane instanceof Pane)
                    {
                        panes.add((Pane) pane);
                    }
                }
            }
        }
    }

    protected void crearRespuesta(RadioButton radioButton)
    {
        if(radioButton.isSelected())
        {
            int numeroDeRespueta = Integer.parseInt(radioButton.getParent().getId());

            String textButton = radioButton.getText();

            viewModel.crearRespuesta(numeroDeRespueta, textButton);
        }
    }


    //-----------------------Botones-------------------------//

    @FXML
    protected void execKeyPressed(KeyEvent keyEvent)
    {
        if(keyEvent.getCode() == KeyCode.DIGIT1)
        {
            activarRaddioButton("Si");
        }
        else if (keyEvent.getCode() == KeyCode.NUMPAD1)
        {
            activarRaddioButton("Si");
        }
        else if (keyEvent.getCode() == KeyCode.DIGIT0)
        {
            activarRaddioButton("No");
        }
        else if (keyEvent.getCode() == KeyCode.NUMPAD0)
        {
            activarRaddioButton("No");
        }
        else if (keyEvent.getCode() == KeyCode.BACK_SPACE)
        {
            activarRaddioButton("N/C");
        }
    }

    @FXML
    protected void execBtnVerdadero(MouseEvent event)
    {
        activarRaddioButton("Si");
    }

    @FXML
    protected void execBtnFalso(MouseEvent event)
    {
        activarRaddioButton("No");
    }

    @FXML
    protected void execBtnNoContesta(MouseEvent event)
    {
        activarRaddioButton("N/C");
    }



    private void activarRaddioButton(String textDeRaddioBtton)
    {
        Pane pane = panes.filtered(x -> x.getId().equals(lblNumeroPregunta.getText())).get(0);

        for(Node radio : pane.getChildren())
        {
            if(radio instanceof RadioButton)
            {
                setEstadoRadioButton((RadioButton) radio, textDeRaddioBtton);
                crearRespuesta((RadioButton) radio);
            }
        }

        siguientePregunta();

        mostrarBtnPreguntaAnteriorSiNoEsPrimerPregunta();

        aumentarProgressBar();
    }


    @FXML
    protected void execBtnsiguientePregunta(MouseEvent event)
    {
        if(viewModel.existeRespuesta(Integer.parseInt(lblNumeroPregunta.getText())))
        {
            siguientePregunta();
        }
        else
        {
            alertarSiNoExistePregunta();
        }
    }

    @FXML
    protected void execBtnPreguntaAnterior(MouseEvent event)
    {
        preguntaAnterior();
        ocultarBtnPreguntaAnteriorSiEsPrimerPregunta();
    }

    protected void siguientePregunta()
    {
        try
        {
            int numeroSiguientePregunta = Integer.parseInt(lblNumeroPregunta.getText()) + 1;

            if(numeroSiguientePregunta < 568)
            {
                lblNumeroPregunta.setText(Integer.toString(numeroSiguientePregunta));
                lblPregunta.setText(RepoPreguntas.getInstance().buscarObjeto(numeroSiguientePregunta).getTextPregunta());
                numeroLblPreguntaActual = numeroSiguientePregunta;
            }
        }
        catch (NoExisteObjetoConEseNombreException e)
        {
            //No hace nada, ya que en el if hago la comprobacion
        }

    }

    protected void preguntaAnterior()
    {
        try
        {
            int numeroPreguntaAnterior = Integer.parseInt(lblNumeroPregunta.getText()) - 1;

            if(numeroPreguntaAnterior > 0)
            {
                lblNumeroPregunta.setText(Integer.toString(numeroPreguntaAnterior));
                lblPregunta.setText(RepoPreguntas.getInstance().buscarObjeto(numeroPreguntaAnterior).getTextPregunta());
                numeroLblPreguntaActual = numeroPreguntaAnterior;
            }
        }
        catch (NoExisteObjetoConEseNombreException e)
        {
            //No hace nada, ya que en el if hago la comprobacion
        }

    }

    protected void ocultarBtnPreguntaAnteriorSiEsPrimerPregunta()
    {
        if(lblNumeroPregunta.getText().equals("1"))
        {
            btnPreguntaAnterior.setVisible(false);
        }
    }

    protected void mostrarBtnPreguntaAnteriorSiNoEsPrimerPregunta()
    {
        if(!btnPreguntaAnterior.isVisible())
        {
            btnPreguntaAnterior.setVisible(true);
        }
    }

    protected void alertarSiNoExistePregunta()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alerta");
        alert.setHeaderText("No puede avanzar a la siguiente pregunta");
        alert.setContentText("Para avanzar a la siguiente pregunta, primero debe contestar la pregunta actual (Pregunta Numero: " + lblNumeroPregunta.getText() + ")");

        alert.showAndWait();
    }

    protected void aumentarProgressBar()
    {
        Double nuevoPorcentaje = progressBar.progressProperty().get() + 0.0017;

        if(nuevoPorcentaje < 567.0)
        {
            progressBar.progressProperty().setValue(nuevoPorcentaje);
            labelProgressBar.setText(nuevoPorcentaje.toString().substring(0, 4)+"%");
        }
        else
        {
            labelProgressBar.setText("100%");
        }
    }



    //-----------------------Dialog-------------------------//

    protected void cambiarConfiguracionDeCerrado() {
        GestorScenas.getStageApp().setOnCloseRequest(event -> {
            showDialog();
            event.consume();
        });
    }

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

        botonClickeado.getParent().getChildrenUnmodifiable().forEach(x -> setEstadoRadioButton((RadioButton) x));

        crearRespuesta(botonClickeado);
    }

    private void setEstadoRadioButton(RadioButton button)
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
            int numeroSiguienteUltimaPregunta = BufferRespuestas.getInstance().getNumeroDeUltimaRespuesta() + 1;
            String textSiguienteUltimaPregunta = RepoPreguntas.getInstance().buscarObjeto(numeroSiguienteUltimaPregunta + 1).getTextPregunta();

            recuperarPregunta(numeroSiguienteUltimaPregunta, textSiguienteUltimaPregunta);
            //Seteo al label de pregunta, el String de la ultima pregunta, para ello uso getNumeroDeUltimaRespuesta(), que me dice en que pregunta se quedo

            restaurarRadioButtons();
            //Seteo todos los radioButton con sus respuestas marcadas, para ello uso las respuestas del buffer

            }

    }

    private void recuperarPregunta(int numeroSiguienteUltimaPregunta, String textSiguienteUltimaPregunta) {
        lblNumeroPregunta.setText(Integer.toString(numeroSiguienteUltimaPregunta));
        lblPregunta.setText(textSiguienteUltimaPregunta);
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
                                    setEstadoRadioButton((RadioButton) radio, respuesta.getTextButton());
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

    private void setEstadoRadioButton(RadioButton radioButton, String text)
    {
        if(radioButton.getText().equals(text))
        {
            radioButton.setSelected(true);
        }
        else
        {
            radioButton.setSelected(false);
        }
    }

//    private void setEstadoRadioButton(ObservableList<RadioButton> radioButtons, Respuesta respuesta)
//    {
//        RadioButton radioButton = radioButtons.stream().filter(x->x.getText().equals(respuesta.getTextButton())).findFirst().get();
//        radioButton.setSelected(true);
//        setEstadoRadioButton(radioButton);
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