package UI.MenuEspecialista;

import Model.GestorScenas;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
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

    public Stage stage = GestorScenas.getStageApp();


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

            GestorScenas.getPreferenciasDeUsuario().put("ALTERNATIVA","1");
            GestorScenas.getFamily().showIngresoDatosAspirante();

        });


    }

}
