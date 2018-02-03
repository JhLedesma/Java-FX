package UI.ListaAspirantes;

import Model.Aspirante;
import com.jfoenix.controls.JFXListView;
import de.saxsys.mvvmfx.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListaAspirantesViewModel implements ViewModel
{
    ObservableList<ItemListViewModel> listaItems = FXCollections.observableArrayList();

    public void buscarItems()
    {
        /*Limpiar listaItems*/
        List<Aspirante> aspirantes = new ArrayList<Aspirante>() /*Repo*/;
        listaItems.addAll(aspirantes.stream().map(ItemListViewModel::new).collect(Collectors.toList()));
    }

    public ObservableList<ItemListViewModel> getListaItems() {
        return listaItems;
    }

}