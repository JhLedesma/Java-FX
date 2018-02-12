package UI.Inicio.Inicio1280x1024;

import UI.Inicio.InicioViewModel;
import UI.Login.LoginViewModel;
import de.saxsys.mvvmfx.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioView1280x1024 implements FxmlView<InicioViewModel>, Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarEfectos();
    }

    @FXML private javafx.scene.image.ImageView imagenEspecialista;

    @FXML private javafx.scene.image.ImageView imagenAspirante;

    private void configurarEfectos() {

        imagenEspecialista.setOnMouseEntered(evt -> {

            imagenEspecialista.setEffect(new DropShadow(20, Color.BLACK));

        });

        imagenEspecialista.setOnMouseExited(evt -> {

            imagenEspecialista.setEffect(new DropShadow(0, Color.BLACK));

        });

        imagenAspirante.setOnMouseEntered(evt -> {

            imagenAspirante.setEffect(new DropShadow(20, Color.BLACK));

        });

        imagenAspirante.setOnMouseExited(evt -> {

            imagenAspirante.setEffect(new DropShadow(0, Color.BLACK));

        });

    }


}
