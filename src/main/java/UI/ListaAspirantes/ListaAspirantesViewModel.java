package UI.ListaAspirantes;

import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import de.saxsys.mvvmfx.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
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
        /*llamar al repo cuando exista el un proveedor BD*/
        Aspirante aspirante = new Aspirante("Jesus", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        List<Aspirante> aspirantes = new ArrayList<Aspirante>();
        aspirantes.add(aspirante);

        listaItems.addAll(aspirantes.stream().map(ItemListViewModel::new).collect(Collectors.toList()));
    }

}