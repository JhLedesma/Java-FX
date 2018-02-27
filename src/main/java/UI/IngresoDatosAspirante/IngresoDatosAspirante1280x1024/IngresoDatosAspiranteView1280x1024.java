package UI.IngresoDatosAspirante.IngresoDatosAspirante1280x1024;

import Model.GestorScenas;
import UI.IngresoDatosAspirante.IngresoDatosAspiranteViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import de.saxsys.mvvmfx.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class IngresoDatosAspiranteView1280x1024 implements FxmlView<IngresoDatosAspiranteViewModel>, Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        configurarEfectos();

    }

    final FileChooser fileChooser = new FileChooser();

    @FXML
    Circle circleImageView;

    @FXML
    JFXComboBox comboBoxEstadoCivil;

    @FXML
    JFXComboBox comboBoxSexo;

    @FXML
    JFXButton botonContinuar;


    public void cambiarImagen() {

        try {

        File file = fileChooser.showOpenDialog(GestorScenas.getStageApp());
        Image image = new Image(file.toURI().toString());
        if (file != null) {
            circleImageView.setFill(new ImagePattern(image));
            }

        }

        catch (NullPointerException e){

            System.out.println("No se selecciono imágen");

        }

    }

    public void configurarEfectos() {

        comboBoxEstadoCivil.getItems().add("Soltero/a");
        comboBoxEstadoCivil.getItems().add("Casado/a");
        comboBoxEstadoCivil.getItems().add("Divorciado/a");
        comboBoxEstadoCivil.getItems().add("Viudo/a");

        comboBoxSexo.getItems().add("Masculino");
        comboBoxSexo.getItems().add("Femenino");
        comboBoxSexo.getItems().add("Otro");

        botonContinuar.setOnMouseClicked(evt -> {

            String pantallaElegida = GestorScenas.getPreferenciasDeUsuario().get("ALTERNATIVA","");

            if(pantallaElegida.equals("1")){

                GestorScenas.getFamily().showInputNormal();

            }
            else {

                System.out.println(pantallaElegida);

            }

        });

    }

}



