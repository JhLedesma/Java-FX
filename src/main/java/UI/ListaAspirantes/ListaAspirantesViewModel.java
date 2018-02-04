package UI.ListaAspirantes;

import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import de.saxsys.mvvmfx.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaAspirantesViewModel implements ViewModel
{
    ObservableList<ItemListViewModel> listaItems = FXCollections.observableArrayList();

    public ObservableList<ItemListViewModel> getListaItems()
    {
        this.buscarItems();
        return listaItems;
    }

    private void buscarItems()
    {
        listaItems.clear();
        final List<Aspirante> aspirantes = RepoAspirantes.getInstance().buscarListaDeObjetos();
        listaItems.addAll(aspirantes.stream().map(ItemListViewModel::new).collect(Collectors.toList()));
    }

}