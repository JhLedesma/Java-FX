package UI.Inicio;

import Model.GestorScenas;
import de.saxsys.mvvmfx.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class InicioView implements FxmlView<InicioViewModel>, Initializable
{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarEfectos();
    }

    @FXML
    private javafx.scene.image.ImageView imagenEspecialista;

    @FXML private javafx.scene.image.ImageView imagenAspirante;

    public void configurarEfectos() {

        imagenEspecialista.setOnMouseEntered(evt -> {

            imagenEspecialista.setEffect(new DropShadow(20, Color.BLACK));

        });

        imagenEspecialista.setOnMouseExited(evt -> {

            imagenEspecialista.setEffect(new DropShadow(0, Color.BLACK));

        });

        imagenEspecialista.setOnMouseClicked(evt -> {

            getLogin();

        });

        imagenAspirante.setOnMouseEntered(evt -> {

            imagenAspirante.setEffect(new DropShadow(20, Color.BLACK));

        });

        imagenAspirante.setOnMouseExited(evt -> {

            imagenAspirante.setEffect(new DropShadow(0, Color.BLACK));

        });

    }

    private void getLogin() {

        GestorScenas.getFamily().showLogin();

    }


}
