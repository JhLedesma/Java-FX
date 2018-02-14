package UI.ListaAspirantes;

import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ToolBar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaAspirantesViewModel implements ViewModel
{
    private ObservableList<ItemListViewModel> listaItems = FXCollections.observableArrayList();

    private StringProperty filtro = new SimpleStringProperty();


    public ObservableList<ItemListViewModel> getListaItems()
    {
        return listaItems;
    }

    public void buscarItems()
    {
        listaItems.clear();
        /*llamar al repo cuando exista el un proveedor BD*/
        Aspirante aspirante = new Aspirante("Jesus", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante1 = new Aspirante("Julian", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante2 = new Aspirante("Juan", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante3 = new Aspirante("Jeremerias", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante4 = new Aspirante("Gonza", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");

        List<Aspirante> aspirantes = new ArrayList<Aspirante>();
        aspirantes.add(aspirante);
        aspirantes.add(aspirante1);
        aspirantes.add(aspirante2);
        aspirantes.add(aspirante3);
        aspirantes.add(aspirante4);

        listaItems.addAll(aspirantes.stream().map(ItemListViewModel::new).collect(Collectors.toList()));
    }

    public void filtrar()
    {
//        FilteredList<ItemListViewModel> filteredData = new FilteredList<>(listaItems, i -> true);

        String nombreFiltro = filtro.get();

//        if(nombreFiltro == null || nombreFiltro.length() == 0) {
//            filteredData.setPredicate(i->true);
//            listaItems.clear();
//            listaItems.addAll(filteredData);
//
//            listaItems.setAll(listaItems.stream().filter(x->x.nombreProperty().get().contains(nombreFiltro)).collect(Collectors.toList()));
//
//            buscarItems();
//
//        }else {
//
//            filteredData.setPredicate(i -> i.nombreProperty().get().toUpperCase().contains(nombreFiltro));
//            listaItems.clear();
//            listaItems.addAll(filteredData);


            listaItems.setAll(listaItems.stream().filter(x->x.nombreProperty().get().contains(nombreFiltro)).collect(Collectors.toList()));
//        }


    }


    public StringProperty filtroProperty() {
        return filtro;
    }

    public ReadOnlyObjectProperty<ObservableList<ItemListViewModel>> itemsProperty() {
        return new SimpleObjectProperty<>(listaItems);
    }



}