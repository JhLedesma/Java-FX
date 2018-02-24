package UI.ListaAspirantes;

import BD.Excepciones.NoExistenObjetosException;
import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import Model.GestorScenas;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

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


    //--------------------ListView----------------------//

    private void loadListView()
    {
        ViewListCellFactory<ItemListViewModel> cell = crearCell();
        listview.setCellFactory(cell);
        listview.setSelectionModel(new NoSelectionModel<ItemListViewModel>());
    }

    protected abstract ViewListCellFactory<ItemListViewModel> crearCell();


    //--------------------Eliminacion----------------------//

    private void escucharNotificaciones() {
        Model.NotificationCenter.getInstance().subscribe("AspiranteEliminado", (s, objects) -> {
            viewModel.buscarItems();
            loadListView();
            //Poner Toast y Memento
        });
    }

    //--------------------Filtrado----------------------//

    private void listenerTextField()
    {
//        try
//        {
            filtroTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                if(newValue == null || newValue.length() == 0) {

                    viewModel.buscarItems();
                }
            });
        //}
//        catch (NoExistenObjetosException e)
//        {
//           //No hago nada a proposito, aca quiero que la lista quede vacia
//        }

    }

    @FXML
    protected void filtrarAspirantesPorEnter(javafx.scene.input.KeyEvent keyEvent)
    {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            filtrarAspirante();
        }
    }

    @FXML
    protected void filtrarAspirantesPorClic(MouseEvent mouseEvent)
    {
        filtrarAspirante();
    }

    private void filtrarAspirante() {
        viewModel.filtrar();
        this.loadListView();
    }

    //-----------------Barra izquierda-------------------//

    @FXML protected void execBtnPantallaAnterior(MouseEvent mouseEvent)
    {
        GestorScenas.getFamily().showMenuEspecialista();
    }

    @FXML protected void execBtnHome(MouseEvent mouseEvent)
    {
        GestorScenas.getFamily().showInicio();
    }

    @FXML protected void execBtn(MouseEvent mouseEvent)
    {
        GestorScenas.getFamily().showConfiguraciones();
    }


}
