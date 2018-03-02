package UI.InputAlternativo;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public abstract class InputAlternativoView implements FxmlView<InputAlternativoViewModel>
{

    @InjectViewModel
    private InputAlternativoViewModel viewModel;

    public void initialize()
    {

    }

    //Hacer un parser para las respuestas
    //Cuando presiona enter, valida que esten las 10 respuestas, la misma funcionalidad esta en el boton pregunta siguiente
    //Cuando se hace clic en en algunos de los item del ScrolPane, que se cargue la pantalla que le corresponde

    //Cada item (Pane) del ScrolPane tiene un ID, con ese ID se cargan las respuestas (String) correspondientes a si pantalla
    //No se van creando las respuestas, se van guardando los String en la lista de string, las respuestas del 1-10 representan un la posicion 1 de la lista de String
    //Al momento de crear las respuestas se pone un contador para generar el numero de respuestas

}