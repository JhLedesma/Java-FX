package UI.ListaAspirantes;

import com.jfoenix.controls.JFXListView;
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

    public void initialize() {
        this.loadListView();
    }

    private void loadListView() {
        listview.setItems(viewModel.getListaItems());
        ViewListCellFactory<ItemListViewModel> cell = crearCell();
        listview.setCellFactory(cell);
        listview.setSelectionModel(new NoSelectionModel<ItemListViewModel>());
    }

    protected abstract ViewListCellFactory<ItemListViewModel> crearCell();

}
