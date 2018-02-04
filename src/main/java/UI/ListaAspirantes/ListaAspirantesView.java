package UI.ListaAspirantes;

import com.jfoenix.controls.JFXListView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;
import javafx.fxml.FXML;

public abstract class ListaAspirantesView implements FxmlView<ListaAspirantesViewModel>
{
    @InjectViewModel
    private ListaAspirantesViewModel viewModel;

    @FXML
    JFXListView<ItemListViewModel> listview;

    public void initialize()
    {
        this.loadListView();
    }

    private void loadListView()
    {
        listview.setItems(viewModel.getListaItems());
        ViewListCellFactory<ItemListViewModel> cell = crearCell();
        listview.setCellFactory(cell);
    }

    protected abstract ViewListCellFactory<ItemListViewModel> crearCell();
}
