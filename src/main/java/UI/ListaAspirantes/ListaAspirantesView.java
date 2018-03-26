package UI.ListaAspirantes;

import Model.Aspirante;
import Model.GestorScenas;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.viewlist.ViewListCellFactory;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public abstract class ListaAspirantesView implements FxmlView<ListaAspirantesViewModel>
{
    @InjectViewModel private ListaAspirantesViewModel viewModel;

    @FXML protected JFXListView<ItemListViewModel> listview;

    @FXML protected JFXTextField filtroTextField;

    @FXML protected AnchorPane rootPane;

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

    protected void loadListView()
    {
        ViewListCellFactory<ItemListViewModel> cell = crearCell();
        listview.setCellFactory(cell);
        listview.setSelectionModel(new NoSelectionModel<ItemListViewModel>());
    }

    protected abstract ViewListCellFactory<ItemListViewModel> crearCell();


    //--------------------Eliminacion----------------------//

    protected void escucharNotificaciones() {
        Model.NotificationCenter.getInstance().subscribe("AspiranteEliminado", (s, objects) -> {
            viewModel.crearMementoAspirante((Aspirante) objects[0], (int) objects[1]);
            viewModel.buscarItems();
            //loadListView();
            showSnackBar();
        });
    }

    protected void showSnackBar()
    {
        JFXSnackbar newsSnackBar = new JFXSnackbar(rootPane);
        newsSnackBar.setCursor(Cursor.HAND);

        newsSnackBar.show("Registro eliminado", "Deshacer", 10000, event -> {
            deshacerAspiranteEliminado();
            newsSnackBar.unregisterSnackbarContainer(rootPane);
            event.consume();
        });
    }

    protected void deshacerAspiranteEliminado()
    {
        viewModel.deshacerEliminacionAspirante();
        viewModel.buscarItems();
      //  loadListView();
    }

    //--------------------Filtrado----------------------//

    protected void listenerTextField()
    {
            filtroTextField.textProperty().addListener((observable, oldValue, newValue) -> {

                if(newValue == null || newValue.length() == 0)
                {
                    viewModel.buscarItems();
                }
            });
    }

    @FXML
    public void filtrarAspirantesPorEnter(javafx.scene.input.KeyEvent keyEvent)
    {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            filtrarAspirante();
        }
    }

    @FXML
    public void filtrarAspirantesPorClic(MouseEvent mouseEvent)
    {
        filtrarAspirante();
    }


    private void filtrarAspirante()
    {
        viewModel.buscarItems();
        viewModel.filtrar();
       // this.loadListView();
    }

    //-----------------Barra izquierda-------------------//

    @FXML public void execBtnPantallaAnterior(MouseEvent mouseEvent)
    {
        GestorScenas.getFamily().showMenuEspecialista();
    }

    @FXML public void execBtnHome(MouseEvent mouseEvent)
    {
        GestorScenas.getFamily().showInicio();
    }

    @FXML public void execBtn(MouseEvent mouseEvent)
    {
        GestorScenas.getFamily().showConfiguraciones();
    }


}
