package UI.MenuEspecialista;

import Model.GestorScenas;
import UI.InputNormal.InputNormalView;
import UI.Login.LoginViewModel;
import com.jfoenix.controls.JFXButton;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public abstract class MenuEspecialistaView implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarEfectos();
    }

    @FXML
    private AnchorPane anchorpaneEvaluacion;

    @FXML private AnchorPane anchorpaneBotones;

    @FXML private JFXButton backButton;

    @FXML private JFXButton alternativa1Button;

    @FXML private StackPane stackPane;

    @FXML private AnchorPane dialog;

    @InjectViewModel
    private MenuEspecialistaViewModel viewModel;

    public Stage stage = GestorScenas.getStageApp();


    protected void showDialog()
    {
        stackPane.setVisible(true);
        dialog.setVisible(true);
    }

    public void noContinuarLoGuardado(MouseEvent evt)
    {
        viewModel.cancelarTestGuardado();
        GestorScenas.getFamily().showIngresoDatosAspirante();
    }

    public void continuarLoGuardado(MouseEvent evt)
    {
        //Aca debería chequear la variable del preferences para saber que input eligio
        //y en base a eso abrir el input correspondiente, lo dejo en el normal por ahora

        GestorScenas.getFamily().showInputNormal();
    }

    public void cancelar(MouseEvent evt)
    {
        stackPane.setVisible(false);
        dialog.setVisible(false);
    }

    public void configurarEfectos() {

        TranslateTransition traslacionAnchorpaneEvaluacion = new TranslateTransition();

        traslacionAnchorpaneEvaluacion.setNode(anchorpaneEvaluacion);
        traslacionAnchorpaneEvaluacion.setDuration(Duration.millis(1000));
        traslacionAnchorpaneEvaluacion.setFromX(0);
        traslacionAnchorpaneEvaluacion.setToX(-460);

        anchorpaneEvaluacion.setOnMouseEntered(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(1);
            traslacionAnchorpaneEvaluacion.play();
        });

        anchorpaneEvaluacion.setOnMouseExited(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(-1);
            traslacionAnchorpaneEvaluacion.play();
        });

        anchorpaneBotones.setOnMouseEntered(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(1);
            traslacionAnchorpaneEvaluacion.play();
        });

        anchorpaneBotones.setOnMouseExited(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(-1);
            traslacionAnchorpaneEvaluacion.play();
        });

        backButton.setOnMouseClicked(evt -> {

            GestorScenas.getFamily().showInicio();

        });

        alternativa1Button.setOnMouseClicked(evt -> {

            viewModel.guardarAlternativa1();

            if(GestorScenas.getPreferenciasDeUsuario().get("GUARDADO","").equals("1"))
            {
                showDialog();
            }

            else
            {
            GestorScenas.getFamily().showIngresoDatosAspirante();
            }

        });

    }

}
