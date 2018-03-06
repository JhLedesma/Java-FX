package UI.InputAlternativo;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import org.controlsfx.control.textfield.CustomTextField;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public abstract class InputAlternativoView implements FxmlView<InputAlternativoViewModel>, Initializable
{

    public List<String> caracteresPermitidos = new ArrayList<String>();

    @InjectViewModel
    private InputAlternativoViewModel viewModel;

    @FXML
    CustomTextField textFieldRespuestas;

    @FXML
    Label lblNumeroPregunta;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblNumeroPregunta.textProperty().bind(viewModel.stringDePreguntaProperty());
        configurarEfectos();

    }


    private void configurarEfectos() {

        settearCaracteresPermitidos();
        configurarTextField();

    }

    private void settearCaracteresPermitidos() {
        caracteresPermitidos.add("0");
        caracteresPermitidos.add("1");
        caracteresPermitidos.add("2");
    }

    private void configurarTextField() {
        textFieldRespuestas.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textFieldRespuestas.getText().length() > 10) {
                    String s = textFieldRespuestas.getText().substring(0, 10);
                    textFieldRespuestas.setText(s);

                }
                else{

                    try{

                        if(!(caracteresPermitidos.contains(newValue.substring(newValue.length()-1)))){

                        String s = textFieldRespuestas.getText().substring(0,newValue.length()-1);
                        textFieldRespuestas.setText(s);

                        }

                    }

                    catch (StringIndexOutOfBoundsException exc){

                        //Simplemente catcheo esta excepcion para que no se lance en el uso del programa
                        //Se lanza cuando borro to do el texto, porque el string nuevo (newvalue) esta vacio, y
                        //length() -1 se va de un resultado posible (daria -1), esto no interrumpe la ejecucion
                        //ni causa inconsistencias

                    }

                }

            }
        });
    }

    private void mostrarAlerta(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Respuestas incompletas");
        alert.setHeaderText("Error en el ingreso de datos");
        alert.setContentText("Por favor ingrese las 10 respuestas indicadas para continuar");

        alert.showAndWait();

    }

    private void aumentarPreguntasActuales(){

        viewModel.setNumeroPreguntasActuales(viewModel.getNumeroPreguntasActuales() + 1);

    }

    private void aumentarPreguntasAContestar(){

        viewModel.setNumeroPreguntasAContestar(viewModel.getNumeroPreguntasAContestar() + 1);

    }

    private void mostrarSiguientePregunta() {

        textFieldRespuestas.setText("");
        viewModel.setStringDePregunta("Preguntas del " + viewModel.getListaNumeroPreguntas().get(viewModel.getNumeroPreguntasAContestar()));

    }

    public void confirmarRespuestas(){

        if(textFieldRespuestas.getLength() != 10){

            mostrarAlerta();

        }
        else{

            if(viewModel.getNumeroPreguntasActuales() == viewModel.getNumeroPreguntasAContestar())
            {

                aumentarPreguntasActuales();
                aumentarPreguntasAContestar();

                viewModel.getListaDeRespuestas().add(textFieldRespuestas.getText());

                mostrarSiguientePregunta();

                System.out.println(viewModel.getListaDeRespuestas());

            }

            else{

                viewModel.getListaDeRespuestas().set(viewModel.getNumeroPreguntasActuales(),textFieldRespuestas.getText());
                viewModel.setNumeroPreguntasActuales(viewModel.getNumeroPreguntasAContestar());

                mostrarSiguientePregunta();

                System.out.println(viewModel.getListaDeRespuestas());

            }

        }

    }

    public void cambiarPregunta(javafx.scene.input.MouseEvent event){

        int id = Integer.parseInt(((Pane) event.getSource()).getId());
        viewModel.setNumeroPreguntasActuales(id);

        viewModel.setStringDePregunta("Preguntas del " + viewModel.getListaNumeroPreguntas().get(id));
        textFieldRespuestas.setText(viewModel.getListaDeRespuestas().get(id));

    }

    public void onEnter(KeyEvent evt){

        if(evt.getCode() == KeyCode.ENTER) {

            confirmarRespuestas();

        }

    }

    public void onClick(javafx.scene.input.MouseEvent evt){
        confirmarRespuestas();
    }

    //Hacer un parser para las respuestas
    //Cuando presiona enter, valida que esten las 10 respuestas, la misma funcionalidad esta en el boton pregunta siguiente
    //Cuando se hace clic en en algunos de los item del ScrolPane, que se cargue la pantalla que le corresponde

    //Cada item (Pane) del ScrolPane tiene un ID, con ese ID se cargan las respuestas (String) correspondientes a si pantalla
    //No se van creando las respuestas, se van guardando los String en la lista de string, las respuestas del 1-10 representan un la posicion 1 de la lista de String
    //Al momento de crear las respuestas se pone un contador para generar el numero de respuestas


}

