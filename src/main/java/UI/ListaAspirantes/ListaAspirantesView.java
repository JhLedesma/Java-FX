package UI.ListaAspirantes;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MultipleSelectionModel;

public abstract class ListaAspirantesView implements FxmlView<ListaAspirantesViewModel>
{
    @InjectViewModel
    private ListaAspirantesViewModel viewModel;

    @FXML
    protected JFXListView<ItemListViewModel> listview;

    @FXML
    private JFXTextField filtroTextField;


    public void initialize()
    {
        viewModel.buscarItems();

        filtroTextField.textProperty().bindBidirectional(viewModel.filtroProperty());
        listview.itemsProperty().bind(viewModel.itemsProperty());

        this.loadListView();
        this.listenerTextField();
    }


    private void loadListView()
    {
        ViewListCellFactory<ItemListViewModel> cell = crearCell();
        listview.setCellFactory(cell);
        listview.setSelectionModel(new NoSelectionModel<ItemListViewModel>());
    }

    private void listenerTextField() {
        filtroTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null || newValue.length() == 0) {

                viewModel.buscarItems();
            }
            else {

                viewModel.buscarItems();
                viewModel.filtrar();
                this.loadListView();
            }
        });
    }

    protected abstract ViewListCellFactory<ItemListViewModel> crearCell();

}
