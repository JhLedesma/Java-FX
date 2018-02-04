package UI.ListaAspirantes.ListaApirantes1920x1080;

import UI.ListaAspirantes.ItemListViewModel;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemListView1920x1080 implements FxmlView<ItemListViewModel> {

    @InjectViewModel
    private ItemListViewModel viewModel;

    @FXML
    private Label nombre;

    @FXML
    private Label apellido;

    @FXML
    private Label edad;

    @FXML
    private Label sexo;

    @FXML
    private Label estadoCivil;

    @FXML
    private Label fecha;

    @FXML
    private Label especialista;

    @FXML
    private Label diagnostico;

    @FXML
    private Label titulacion;


    public void initialize()
    {
        nombre.textProperty().bind(viewModel.nombreProperty());
        apellido.textProperty().bind(viewModel.apellidoProperty());
        edad.textProperty().bind(viewModel.edadProperty());
        sexo.textProperty().bind(viewModel.sexoProperty());
        estadoCivil.textProperty().bind(viewModel.estadoCivilProperty());
        fecha.textProperty().bind(viewModel.fechaProperty());
        especialista.textProperty().bind(viewModel.especialistaProperty());
        diagnostico.textProperty().bind(viewModel.diagnosticoProperty());
        titulacion.textProperty().bind(viewModel.titulacionProperty());
    }


}