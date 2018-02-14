package UI.ListaAspirantes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


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

    @FXML
    protected FontAwesomeIconView plus;

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

        this.configPopup();
    }

    //----------------------Popup------------------------//
    @FXML
    protected void exec(MouseEvent mouseEvent) {

        if(!popupAbierto){

            listView.getItems().clear();
            this.loadDateListView();
            this.showPopup();
            popupAbierto = true;
            plus.setIcon(FontAwesomeIcon.MINUS);

        }else{

            popup.hide();
            popupAbierto = false;
            listView.getItems().clear();
            plus.setIcon(FontAwesomeIcon.PLUS);

        }

    }


    protected void loadDateListView()
    {

        createAndLoadLabel("Imprimir", new MaterialDesignIconView(MaterialDesignIcon.PRINTER));
        createAndLoadLabel("Enviar Resultados", new MaterialDesignIconView(MaterialDesignIcon.EMAIL_OUTLINE));
        createAndLoadLabel("Modificar Datos", new MaterialDesignIconView(MaterialDesignIcon.PENCIL));
        createAndLoadLabel("Eliminar Registro", new MaterialDesignIconView(MaterialDesignIcon.DELETE));

    }

    protected void createAndLoadLabel(String name, MaterialDesignIconView icon)
    {
        icon.setGlyphSize(getSizeIconLabel());
        Label label = new Label(name);
        label.setFont(Font.font("Arial",getSizeLabel()));
        label.setGraphic(icon);
        label.setGraphicTextGap(getGraphicTextGap());
        label.setPadding(new Insets(getLabelPadding()));

        listView.getItems().add(label);
    }




    protected void showPopup()
    {
        this.configListView();

        popup.setPopupContent(listView);
        popup.show(opcion, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, popupInitialPositionX(), popupInitialPositionY());
    }


    protected void configListView()
    {
        listView.depthProperty().set(1);
        listView.setExpanded(true);
        listView.setVisible(true);
        listView.setPrefHeight(getAlturaListView());
        listView.setVerticalGap(getVerticalGapListView());
        listView.setPrefWidth(getAnchoListView());


    }

    private void configPopup() {
//        popup.setOnAutoHide(event -> {
//            plus.setIcon(FontAwesomeIcon.PLUS);
//            popupAbierto = true;
//            listView.getItems().clear();
//        });
        popup.autoHideProperty().setValue(false);
        popup.setStyle("-fx-background-color: transparent;");
    }



    protected abstract Double getSizeLabel();

    protected abstract Double getSizeIconLabel();

    protected abstract Double getGraphicTextGap();

    protected abstract Double getLabelPadding();

    protected abstract Double getAlturaListView();

    protected abstract Double getVerticalGapListView();

    protected abstract Double getAnchoListView();

    protected abstract Double popupInitialPositionX();

    protected abstract Double popupInitialPositionY();



}
