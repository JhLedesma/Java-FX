package UI.ListaAspirantes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXPopup;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;


public abstract class ItemListView implements FxmlView<ItemListViewModel>
{
    @InjectViewModel
    protected ItemListViewModel viewModel;

    @FXML
    protected Label nombre;

    @FXML
    protected Label apellido;

    @FXML
    protected Label edad;

    @FXML
    protected Label sexo;

    @FXML
    protected Label estadoCivil;

    @FXML
    protected Label fecha;

    @FXML
    protected Label especialista;

    @FXML
    protected Label diagnostico;

    @FXML
    protected Label titulacion;

    @FXML
    protected JFXButton opcion;

    @FXML
    protected JFXListView<Label> listView;

    protected JFXPopup popup = new JFXPopup();

    protected boolean popupAbierto = false;


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
    protected void exec(MouseEvent mouseEvent) {

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


    protected void loadDateListView()
    {
        for(int i=0; i<4;i++)
        {
            Label lbl = new Label("item" +i);
            this.configSizeLabel(lbl);
            lbl.setGraphic(new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT_CIRCLE));
            listView.getItems().add(lbl);
        }
    }


    protected void showPopup()
    {
        this.configListView();

        popup.setPopupContent(listView);
        popup.setStyle("-fx-background-color: transparent;");
        popup.show(opcion, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, -190.0,10.0 );
    }

    protected abstract void configListView();

    protected abstract void configSizeLabel(Label lbl);


}
