package UI.ListaAspirantes.ListaApirantes1920x1080;

import UI.ListaAspirantes.ItemListViewModel;
import com.jfoenix.controls.JFXListView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import UI.ListaAspirantes.ListaAspirantesViewModel;
import javafx.fxml.FXML;

public class ListaAspirantesView1920x1080 implements FxmlView<ListaAspirantesViewModel> {

    @InjectViewModel
    private ListaAspirantesViewModel viewModel;

    @FXML
    JFXListView<ItemListViewModel> listview; /*= new JFXListView<ItemListViewModel>()*/

    public void initialize()
    {

    }

    private void loadListView()
    {
        listview.getItems().addAll(viewModel.getListaItems());
    }
}