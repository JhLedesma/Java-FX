package UI.ListaAspirantes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXPopup;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public abstract class ItemListView implements FxmlView<ItemListViewModel>
{
    @InjectViewModel
    private ItemListViewModel viewModel;

    @FXML
    private Label nombre;

    @FXML
    private Label apellido;

    @FXML
    private Label edad;

    @FXML
    private Label sexo;

    @FXML
    private Label estadoCivil;

    @FXML
    private Label fecha;

    @FXML
    private Label especialista;

    @FXML
    private Label diagnostico;

    @FXML
    private Label titulacion;

    @FXML
    private JFXButton opcion;

    @FXML
    private JFXListView<Label> listView;

    JFXPopup popup = new JFXPopup();

    boolean popupAbierto = false;


    public void initialize()
    {
        nombre.textProperty().bind(viewModel.nombreProperty());
        apellido.textProperty().bind(viewModel.apellidoProperty());
        edad.textProperty().bind(viewModel.edadProperty());
        sexo.textProperty().bind(viewModel.sexoProperty());
        estadoCivil.textProperty().bind(viewModel.estadoCivilProperty());
        fecha.textProperty().bind(viewModel.fechaProperty());
        especialista.textProperty().bind(viewModel.especialistaProperty());
        diagnostico.textProperty().bind(viewModel.diagnosticoProperty());
        titulacion.textProperty().bind(viewModel.titulacionProperty());
    }

//----------------------Popup------------------------//
    @FXML
    public void exec(MouseEvent mouseEvent) {

        if(!popupAbierto){

            this.loadDateListView();
            this.showPopup();
            popupAbierto = true;

        }else{

            popup.hide();
            popupAbierto = false;
            listView.getItems().clear();
        }

    }


    private void loadDateListView()
    {
        for(int i=0; i<4;i++)
        {
            Label lbl = new Label("item" +i);
            lbl.setGraphic(new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT_CIRCLE));
            listView.getItems().add(lbl);
        }
    }


    private void showPopup() {
        listView.setVerticalGap(10.0);
        listView.depthProperty().set(1);
        listView.setExpanded(true);

        popup.setPopupContent(listView);
        popup.setStyle("-fx-background-color: transparent;");
        popup.show(opcion, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, -190.0,10.0 );
        listView.setVisible(true);
    }


}
