package UI.InputAlternativo;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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


    //Hacer un parser para las respuestas
    //Cuando presiona enter, valida que esten las 10 respuestas, la misma funcionalidad esta en el boton pregunta siguiente
    //Cuando se hace clic en en algunos de los item del ScrolPane, que se cargue la pantalla que le corresponde

    //Cada item (Pane) del ScrolPane tiene un ID, con ese ID se cargan las respuestas (String) correspondientes a si pantalla
    //No se van creando las respuestas, se van guardando los String en la lista de string, las respuestas del 1-10 representan un la posicion 1 de la lista de String
    //Al momento de crear las respuestas se pone un contador para generar el numero de respuestas


}

