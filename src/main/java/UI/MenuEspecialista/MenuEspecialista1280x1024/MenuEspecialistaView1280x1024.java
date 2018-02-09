package UI.MenuEspecialista.MenuEspecialista1280x1024;

import UI.MenuEspecialista.MenuEspecialistaViewModel;
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
        configurarTraslacion();
    }

    @FXML private AnchorPane anchorpane;

    @InjectViewModel
    private MenuEspecialistaViewModel viewModel;


    public void configurarTraslacion() {

        TranslateTransition traslacion = new TranslateTransition();

        anchorpane.setTranslateX(-250);

        traslacion.setNode(anchorpane);
        traslacion.setDuration(Duration.millis(1000));
        traslacion.setFromX(250);
        traslacion.setToX(0);

        anchorpane.setOnMouseEntered(evt -> {
            traslacion.setRate(1);
            traslacion.play();
        });

    }
}
