package UI.ListaAspirantes.ListaApirantes1920x1080;

import UI.ListaAspirantes.ItemListViewModel;
import com.jfoenix.controls.JFXListView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import UI.ListaAspirantes.ListaAspirantesViewModel;
import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;
import javafx.fxml.FXML;

public class ListaAspirantesView1920x1080 implements FxmlView<ListaAspirantesViewModel> {

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

    private ViewListCellFactory<ItemListViewModel> crearCell()
    {
        return CachedViewModelCellFactory.createForFxmlView(ItemListView1920x1080.class);
    }
}