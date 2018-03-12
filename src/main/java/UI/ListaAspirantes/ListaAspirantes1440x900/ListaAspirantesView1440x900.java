package UI.ListaAspirantes.ListaAspirantes1440x900;

import UI.ListaAspirantes.ItemListViewModel;
import UI.ListaAspirantes.ListaAspirantes1360x765.ItemListView1360x765;
import UI.ListaAspirantes.ListaAspirantesView;
import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;

public class ListaAspirantesView1440x900 extends ListaAspirantesView
{
    @Override
    protected ViewListCellFactory<ItemListViewModel> crearCell()
    {
        return CachedViewModelCellFactory.createForFxmlView(ItemListView1440x900.class);
    }
}