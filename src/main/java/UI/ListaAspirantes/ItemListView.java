package UI.ListaAspirantes;

import Model.GestorScenas;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;


public abstract class ItemListView implements FxmlView<ItemListViewModel>
{
    @InjectViewModel protected ItemListViewModel viewModel;

    @FXML protected AnchorPane anchorPrincipal;

    @FXML protected AnchorPane anchorMenuEditar;

    @FXML protected Label nombre;

    @FXML protected Label apellido;

    @FXML protected Label edad;

    @FXML protected Label sexo;

    @FXML protected Label estadoCivil;

    @FXML protected Label fecha;

    @FXML protected Label especialista;

    @FXML protected Label diagnostico;

    @FXML protected Label titulacion;

    @FXML protected JFXButton opcion;

    @FXML protected JFXListView<Label> listView;

    @FXML protected FontAwesomeIconView plus;

    @FXML private JFXButton btnGuardar;

    @FXML private JFXButton btnVolver;

    @FXML private Label fechaEdit;

    @FXML private Label diagnosticoEdit;

    @FXML private JFXTextField nombreEdit;

    @FXML private JFXTextField edadEdit;

    @FXML private JFXTextField estadoCivilEdit;

    @FXML private JFXTextField especialistaEdit;

    @FXML private JFXTextField titulacionEdit;

    @FXML private JFXTextField apellidoEdit;

    @FXML private JFXTextField sexoEdit;

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

        diagnosticoEdit.textProperty().bind(viewModel.diagnosticoEditProperty());
        fechaEdit.textProperty().bind(viewModel.fechaEditProperty());

        nombreEdit.textProperty().bindBidirectional(viewModel.nombreEditProperty());
        apellidoEdit.textProperty().bindBidirectional(viewModel.apellidoEditProperty());
        edadEdit.textProperty().bindBidirectional(viewModel.edadEditProperty());
        sexoEdit.textProperty().bindBidirectional(viewModel.sexoEditProperty());
        estadoCivilEdit.textProperty().bindBidirectional(viewModel.estadoCivilEditProperty());
        especialistaEdit.textProperty().bindBidirectional(viewModel.especialistaEditProperty());
        titulacionEdit.textProperty().bindBidirectional(viewModel.titulacionEditProperty());
    }




    @FXML
    protected void execBotonListView(MouseEvent mouseEvent)
    {
        if(listView.getSelectionModel().getSelectedItem() == listView.getItems().get(3))
        {
            popup.hide();
            viewModel.eliminarAspirante();
        }else if (listView.getSelectionModel().getSelectedItem() == listView.getItems().get(2))
        {
            popup.hide();
            showMenuEditarDatos();
            popupAbierto = false;
            plus.setIcon(FontAwesomeIcon.PLUS);
        }
    }


    //----------------------MenuEditarDatos------------------------//
    @FXML
    protected void showMenuEditarDatos()
    {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), anchorPrincipal);
        transition.setToX(-1300);
        transition.play();
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(1000), anchorMenuEditar);
        transition2.setToX(-1300);
        transition2.play();
    }

    @FXML
    protected void execBtnGuardar(MouseEvent event)
    {
        this.viewModel.validarEditText();
        execBtnVolver(event);
    }


    @FXML
    protected void execBtnVolver(MouseEvent event)
    {
        TranslateTransition transition = new TranslateTransition(Duration.millis(800), anchorPrincipal);
        transition.setToX(0);
        transition.play();
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(800), anchorMenuEditar);
        transition2.setToX(0);
        transition2.play();
    }


    //----------------------Popup------------------------//
    @FXML
    protected void execPopup(MouseEvent mouseEvent) {

        if(!popupAbierto){

            listView.getItems().clear();
            this.loadDateListView();
            this.showPopup();
            popupAbierto = true;
            this.rotarIcono();
            plus.setIcon(FontAwesomeIcon.MINUS);

        }else{

            popup.hide();
            popupAbierto = false;
            listView.getItems().clear();
            this.rotarIcono();
            plus.setIcon(FontAwesomeIcon.PLUS);
        }

    }

    protected void rotarIcono()
    {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(180), plus);
        rotateTransition.setByAngle(180);
        rotateTransition.setCycleCount(1);
        rotateTransition.play();
    }


    protected void loadDateListView()
    {
        Label imprimir = createLabel("Imprimir", new MaterialDesignIconView(MaterialDesignIcon.PRINTER));
        Label enviarResultados = createLabel("Enviar Resultados", new MaterialDesignIconView(MaterialDesignIcon.EMAIL_OUTLINE));
        Label modificarDatos = createLabel("Modificar Datos", new MaterialDesignIconView(MaterialDesignIcon.PENCIL));
        Label eliminar = createLabel("Eliminar Registro", new MaterialDesignIconView(MaterialDesignIcon.DELETE));

        listView.getItems().add(imprimir);
        listView.getItems().add(enviarResultados);
        listView.getItems().add(modificarDatos);
        listView.getItems().add(eliminar);
    }

    protected Label createLabel(String name, MaterialDesignIconView icon)
    {
        icon.setGlyphSize(getSizeIconLabel());
        Label label = new Label(name);
        label.setFont(Font.font("Arial",getSizeLabel()));
        label.setGraphic(icon);
        label.setGraphicTextGap(getGraphicTextGap());
        label.setPadding(new Insets(getLabelPadding()));

        return label;
    }



    protected void showPopup()
    {
        this.configListView();
        this.configPopup();

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
        listView.setOnMouseClicked(event -> execBotonListView(event));
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
