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
    //cuando presiona enter, valida que esten las 10 respuestas, la misma funcionalidad esta en el boton pregunta siguiente
    //Cuando se hace clic en en algunos de los item del ScrolPane, que se cargue la pantalla que le corresponde, para eso hay que recuperar las respuestas del buffer y tranajar con el repo de preguntas


    /*Cada item del ScrolPane tiene un id, que representa una posicion en la listaPantallainputAlternativo, cuando se toque en uno de estos items, se carga todo lo necesario para esa pantalla*/
    //Un objeto PantallainputAlternativo, debe contener String que represente lo que se mostrara en el label, una lista de int para buscar en el buffer respuesta por numero de respuesta

}