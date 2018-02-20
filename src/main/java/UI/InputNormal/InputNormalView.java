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
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
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

    RadioButton botonClickeado;

    @FXML
    private StackPane stackPane;


    public void initialize()
    {
        scrollP.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollP.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        
    }


    private void mostrarDialog()
    {
        JFXDialog dialog = new JFXDialog(stackPane, crearDialogLayout(), JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }

    private JFXDialogLayout crearDialogLayout()
    {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("A"));
        content.setBody(new Text("¿Desea que sus respuestas se guarden para la proxima vez continuar con el test?"));
        content.setActions(crearBotonSi(), crearBotonNo());

        return content;
    }

    private JFXButton crearBotonSi()
    {
        JFXButton button = new JFXButton("Si");
        button.setOnMouseClicked(event -> {
            //Guardar
            Platform.exit();
            System.exit(0);
        });

        return button;
    }

    private JFXButton crearBotonNo()
    {
        JFXButton button = new JFXButton("No");
        button.setOnMouseClicked(event -> {
            Platform.exit();
            System.exit(0);
        });

        return button;
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