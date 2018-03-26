package UI.InputAlternativo;

import com.jfoenix.controls.JFXButton;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public abstract class InputAlternativoView implements FxmlView<InputAlternativoViewModel>, Initializable
{

    public List<String> caracteresPermitidos = new ArrayList<String>();

    private int cantidadCaracteresDeRespuesta = 10;

    private ChangeListener<String> listenerActualDeTextField;

    @InjectViewModel
    private InputAlternativoViewModel viewModel;

    @FXML
    CustomTextField textFieldRespuestas;

    @FXML
    Label lblNumeroPregunta;

    @FXML
    JFXButton btnPreguntaSiguiente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblNumeroPregunta.textProperty().bind(viewModel.stringDePreguntaProperty());
        configurarEfectos();

    }


    private void configurarEfectos() {

        settearCaracteresPermitidos();
        configurarTextField(cantidadCaracteresDeRespuesta);

    }

    private void settearCaracteresPermitidos() {
        caracteresPermitidos.add("0");
        caracteresPermitidos.add("1");
        caracteresPermitidos.add("2");
    }

    private void configurarTextField(int cantidadCaracteresInput) {

        listenerActualDeTextField = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (textFieldRespuestas.getText().length() > cantidadCaracteresInput) {
                    String s = textFieldRespuestas.getText().substring(0, cantidadCaracteresInput);
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
        };

        textFieldRespuestas.textProperty().addListener(listenerActualDeTextField);

    }

    private void mostrarAlerta(int cantidadDeCaracteresNecesarios){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Respuestas incompletas");
        alert.setHeaderText("Error en el ingreso de datos");
        alert.setContentText("Por favor ingrese las " + cantidadDeCaracteresNecesarios + " respuestas indicadas para continuar");

        alert.showAndWait();


    }

    private void chequearPorUltimaRespuesta(){ //Podría crear un metodo para cuando avanzo de pregunta pra que solo chequee si es la última pero prefiero dejar menos codigo y hacer 2 if mas

        if(viewModel.getNumeroPreguntasActuales() != 56){

            if(cantidadCaracteresDeRespuesta != 10){

                cantidadCaracteresDeRespuesta = 10;

                btnPreguntaSiguiente.setText("Pregunta Siguiente");

                reconfigurarElementosVista();

            }

        }
        else{

            cantidadCaracteresDeRespuesta = 7;

            btnPreguntaSiguiente.setText("Terminar");

            reconfigurarElementosVista();

        }

    }

    private void reconfigurarElementosVista() {

        textFieldRespuestas.textProperty().removeListener(listenerActualDeTextField);
        configurarTextField(cantidadCaracteresDeRespuesta);

    }

    private void aumentarPreguntasActuales(){

        viewModel.setNumeroPreguntasActuales(viewModel.getNumeroPreguntasActuales() + 1);

    }

    private void decrementarPreguntasActuales(){

        viewModel.setNumeroPreguntasActuales(viewModel.getNumeroPreguntasActuales() - 1);

    }

    private void aumentarPreguntasAContestar(){

        viewModel.setNumeroPreguntasAContestar(viewModel.getNumeroPreguntasAContestar() + 1);

    }

    private void mostrarSiguientePregunta() {

        textFieldRespuestas.setText("");
        viewModel.setStringDePregunta("Preguntas del " + viewModel.getListaNumeroPreguntas().get(viewModel.getNumeroPreguntasAContestar()));

    }

    public void confirmarRespuestas(){

        if(textFieldRespuestas.getLength() != cantidadCaracteresDeRespuesta){

            mostrarAlerta(cantidadCaracteresDeRespuesta);

        }
        else{

            if(viewModel.getNumeroPreguntasActuales() == viewModel.getNumeroPreguntasAContestar())
            {

                aumentarPreguntasActuales();
                aumentarPreguntasAContestar();

                viewModel.getListaDeRespuestas().add(textFieldRespuestas.getText());

                chequearPorUltimaRespuesta();

                mostrarSiguientePregunta();

                System.out.println(viewModel.getNumeroPreguntasActuales());

            }

            else{

                viewModel.getListaDeRespuestas().set(viewModel.getNumeroPreguntasActuales(),textFieldRespuestas.getText());
                viewModel.setNumeroPreguntasActuales(viewModel.getNumeroPreguntasAContestar());

                mostrarSiguientePregunta();

            }

        }

    }

    public void cambiarPregunta(javafx.scene.input.MouseEvent event){

        int id = Integer.parseInt(((Pane) event.getSource()).getId());
        viewModel.setNumeroPreguntasActuales(id);

        chequearPorUltimaRespuesta();

        viewModel.setStringDePregunta("Preguntas del " + viewModel.getListaNumeroPreguntas().get(id));
        textFieldRespuestas.setText(viewModel.getListaDeRespuestas().get(id));

    }

    public void onEnter(KeyEvent evt){

        if(evt.getCode() == KeyCode.ENTER) {

            confirmarRespuestas();

        }

    }

    public void onClickPreguntaSiguiente(javafx.scene.input.MouseEvent evt){
        confirmarRespuestas();
    }

    public void onClickPreguntaAnterior(javafx.scene.input.MouseEvent evt){

        decrementarPreguntasActuales();

        int id = viewModel.getNumeroPreguntasActuales();

        viewModel.setStringDePregunta("Preguntas del " + viewModel.getListaNumeroPreguntas().get(id));
        textFieldRespuestas.setText(viewModel.getListaDeRespuestas().get(id));

    } //Falta manejar que pasa cuando toco este boton y estoy en la primer pregunta, ahora tira excepcion

}