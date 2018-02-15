package UI.ListaAspirantes;

import BD.Excepciones.NoExistenObjetosException;
import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.MvvmFX;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import de.saxsys.mvvmfx.utils.notifications.NotificationObserver;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MultipleSelectionModel;

import java.util.Arrays;

public abstract class ListaAspirantesView implements FxmlView<ListaAspirantesViewModel>
{
    @InjectViewModel private ListaAspirantesViewModel viewModel;

    @FXML protected JFXListView<ItemListViewModel> listview;

    @FXML private JFXTextField filtroTextField;


    public void initialize()
    {
        viewModel.buscarItems();

        filtroTextField.textProperty().bindBidirectional(viewModel.filtroProperty());
        listview.itemsProperty().bind(viewModel.itemsProperty());

        this.loadListView();
        this.listenerTextField();

        this.escucharNotificaciones();
    }

    private void escucharNotificaciones() {
        Model.NotificationCenter.getInstance().subscribe("AspiranteEliminado", (s, objects) -> {
            viewModel.buscarItems();
            loadListView();
        });
    }


    private void loadListView()
    {
        ViewListCellFactory<ItemListViewModel> cell = crearCell();
        listview.setCellFactory(cell);
        listview.setSelectionModel(new NoSelectionModel<ItemListViewModel>());
    }


    private void listenerTextField()
    {
        try
        {
            filtroTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                if(newValue == null || newValue.length() == 0) {

                    viewModel.buscarItems();
                }
                else {

                    viewModel.buscarItems();
                    viewModel.filtrar();
                    this.loadListView();
                }
            });
        }
        catch (NoExistenObjetosException e)
        {
           //No hago nada a proposito, aca quiero que la lista quede vacia
        }

    }

    protected abstract ViewListCellFactory<ItemListViewModel> crearCell();

}
