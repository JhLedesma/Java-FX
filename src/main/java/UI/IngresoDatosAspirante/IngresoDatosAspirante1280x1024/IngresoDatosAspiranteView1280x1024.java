package UI.IngresoDatosAspirante.IngresoDatosAspirante1280x1024;

import Model.GestorScenas;
import UI.IngresoDatosAspirante.IngresoDatosAspiranteViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import de.saxsys.mvvmfx.FxmlView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class IngresoDatosAspiranteView1280x1024 implements FxmlView<IngresoDatosAspiranteViewModel>, Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        configurarEfectos();

    }

    final FileChooser fileChooser = new FileChooser();

    final RequiredFieldValidator validator = new RequiredFieldValidator();

    private List<Integer> listaDeCampos = new ArrayList<>();

    @FXML
    Circle circleImageView;

    @FXML
    JFXComboBox comboBoxEstadoCivil;

    @FXML
    JFXComboBox comboBoxSexo;

    @FXML
    JFXButton botonContinuar;

    @FXML
    JFXTextField textFieldNombre;

    @FXML
    JFXTextField textFieldApellido;

    @FXML
    JFXTextField textFieldEdad;

    @FXML
    JFXTextField textFieldEspecialista;

    @FXML
    JFXTextField textFieldTitulacion;


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

    private void poblarComboBoxes() {

        comboBoxEstadoCivil.getItems().add("Soltero/a");
        comboBoxEstadoCivil.getItems().add("Casado/a");
        comboBoxEstadoCivil.getItems().add("Divorciado/a");
        comboBoxEstadoCivil.getItems().add("Viudo/a");

        comboBoxSexo.getItems().add("Masculino");
        comboBoxSexo.getItems().add("Femenino");
        comboBoxSexo.getItems().add("Otro");

    }

    private void chequearTextoNulo(String texto){

        if(texto.equals("")){

            listaDeCampos.add(0);

        }

    }

    private void generarAlerta(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Campos incompletos");
        alert.setHeaderText("Error en el ingreso de datos");
        alert.setContentText("Por favor complete todos los campos");

        alert.showAndWait();

        listaDeCampos = new ArrayList<>();

    }

    private void validarCampos(){

        chequearTextoNulo(textFieldNombre.getText());
        chequearTextoNulo(textFieldApellido.getText());
        chequearTextoNulo(textFieldEdad.getText());
        chequearTextoNulo(textFieldEspecialista.getText());
        chequearTextoNulo(textFieldTitulacion.getText());

    }

    public void configurarEfectos() {

        poblarComboBoxes();

        botonContinuar.setOnMouseClicked(evt -> {

            validarCampos();

            if(listaDeCampos.contains(0)){

                generarAlerta();

            }

            else{

                String pantallaElegida = GestorScenas.getPreferenciasDeUsuario().get("ALTERNATIVA","");

                if(pantallaElegida.equals("1")){

                    GestorScenas.getFamily().showInputNormal();

                }

                else {

                    System.out.println(pantallaElegida);

                }

            }

        });

    }

}