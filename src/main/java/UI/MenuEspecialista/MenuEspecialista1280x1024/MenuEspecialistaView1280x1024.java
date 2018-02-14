package UI.MenuEspecialista.MenuEspecialista1280x1024;

import Model.GestorScenas;
import UI.MenuEspecialista.MenuEspecialistaViewModel;
import com.jfoenix.controls.JFXButton;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuEspecialistaView1280x1024 implements FxmlView<MenuEspecialistaViewModel>, Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarEfectos();
    }

    @FXML private AnchorPane anchorpaneEvaluacion;

    @FXML private AnchorPane anchorpaneBotones;

    @FXML private JFXButton backButton;

    @FXML private JFXButton alternativa1Button;


    public void configurarEfectos() {

        TranslateTransition traslacionAnchorpaneEvaluacion = new TranslateTransition();

        traslacionAnchorpaneEvaluacion.setNode(anchorpaneEvaluacion);
        traslacionAnchorpaneEvaluacion.setDuration(Duration.millis(1000));
        traslacionAnchorpaneEvaluacion.setFromX(-460);
        traslacionAnchorpaneEvaluacion.setToX(0);

        anchorpaneEvaluacion.setOnMouseEntered(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(-1);
            traslacionAnchorpaneEvaluacion.play();
        });

        anchorpaneEvaluacion.setOnMouseExited(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(1);
            traslacionAnchorpaneEvaluacion.play();
        });

        anchorpaneBotones.setOnMouseEntered(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(-1);
            traslacionAnchorpaneEvaluacion.play();
        });

        anchorpaneBotones.setOnMouseExited(evt -> {
            traslacionAnchorpaneEvaluacion.setRate(1);
            traslacionAnchorpaneEvaluacion.play();
        });

        backButton.setOnMouseClicked(evt -> {

            GestorScenas.getFamily().showInicio();

        });

        alternativa1Button.setOnMouseClicked(evt -> {

            GestorScenas.getFamily().showInputNormal();

        });

    }
}