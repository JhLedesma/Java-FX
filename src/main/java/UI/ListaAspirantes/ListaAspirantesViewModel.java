package UI.ListaAspirantes;

import BD.Excepciones.NoExistenObjetosException;
import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.DefaultNotificationCenter;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenterFactory;
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

    private Aspirante mementoAspirante;
    private int numeroIndiceMemento;

    public void buscarItems()
    {
        listaItems.clear();

        try {
            listaItems.addAll(RepoAspirantes.getInstance().buscarListaDeObjetos().stream().map(ItemListViewModel::new).collect(Collectors.toList()));
        }
        catch (NoExistenObjetosException e){
            RepoAspirantes.getInstance().agregarObjeto(
                    new Aspirante("Ejemplo", "Ejemplo", "21", "M", "Soltero", "09/04/1996", "EspecialistaEjemplo", "M", "Ingenieria en Sistemas")
            );
        }

    }

    public void filtrar()
    {
        String nombreFiltro = filtro.get().toUpperCase();

        listaItems.setAll(listaItems.stream().filter(x-> coincideConNombre(nombreFiltro, x) || coincideConApellido(nombreFiltro, x)).collect(Collectors.toList()));
    }



    private boolean coincideConApellido(String nombreFiltro, ItemListViewModel x) {
        return x.apellidoProperty().get().toUpperCase().contains(nombreFiltro);
    }

    private boolean coincideConNombre(String nombreFiltro, ItemListViewModel x) {
        return x.nombreProperty().get().toUpperCase().contains(nombreFiltro);
    }



    public void crearMementoAspirante(Aspirante aspirante, int numeroIndiceAspirante)
    {
        this.mementoAspirante = aspirante;
        this.numeroIndiceMemento = numeroIndiceAspirante;
    }

    public void deshacerEliminacionAspirante()
    {
        try {
            RepoAspirantes.getInstance().buscarListaDeObjetos().add(numeroIndiceMemento, mementoAspirante);
        } catch (NoExistenObjetosException e) {
            e.printStackTrace();
        }
    }


    public StringProperty filtroProperty() {
        return filtro;
    }

    public ReadOnlyObjectProperty<ObservableList<ItemListViewModel>> itemsProperty() {
        return new SimpleObjectProperty<>(listaItems);
    }

    public ObservableList<ItemListViewModel> getListaItems()
    {
        return listaItems;
    }


}