package UI.ListaAspirantes.ListaAspirante1280x1024;

import UI.ListaAspirantes.ItemListViewModel;
import UI.ListaAspirantes.ListaAspirantesView;
import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;

public class ListaAspirantesView1280x1024 extends ListaAspirantesView /*implements FxmlView<ListaAspirantesViewModel>*/
{
    @Override
    protected ViewListCellFactory<ItemListViewModel> crearCell()
    {
        return CachedViewModelCellFactory.createForFxmlView(ItemListView1280x1024.class);
    }
}
