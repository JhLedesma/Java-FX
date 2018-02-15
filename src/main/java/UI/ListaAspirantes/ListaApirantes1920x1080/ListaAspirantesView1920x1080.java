package UI.ListaAspirantes.ListaApirantes1920x1080;

import UI.ListaAspirantes.ItemListViewModel;
import UI.ListaAspirantes.ListaAspirantesView;
import com.jfoenix.controls.JFXListView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import UI.ListaAspirantes.ListaAspirantesViewModel;
import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;

public class ListaAspirantesView1920x1080 extends ListaAspirantesView /*implements FxmlView<ListaAspirantesViewModel>*/ {

    @Override
    protected ViewListCellFactory<ItemListViewModel> crearCell() {
        return CachedViewModelCellFactory.createForFxmlView(ItemListView1920x1080.class);
    }


}