package UI.ListaAspirantes.ListaAspirantes1360x765;

import UI.ListaAspirantes.ItemListViewModel;
import UI.ListaAspirantes.ListaAspirante1280x1024.ItemListView1280x1024;
import UI.ListaAspirantes.ListaAspirantesView;
import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;

public class ListaAspirantesView1360x765 extends ListaAspirantesView
{
    @Override
    protected ViewListCellFactory<ItemListViewModel> crearCell()
    {
        return CachedViewModelCellFactory.createForFxmlView(ItemListView1360x765.class);
    }
}