package UI.ListaAspirantes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXPopup;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import javafx.scene.text.Font;

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
    private JFXNodesList node;

    @FXML
    private JFXButton opcion;

    @FXML
    private JFXListView<Label> listView;


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

        JFXButton a = new JFXButton("Opciones");
        a.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS));
        a.setButtonType(JFXButton.ButtonType.RAISED);
        JFXButton b = new JFXButton("R2");
        b.setGraphic(new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT_CIRCLE));
        b.setButtonType(JFXButton.ButtonType.RAISED);
        JFXButton c = new JFXButton("R3");
        c.setGraphic(new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT_CIRCLE));
        c.setButtonType(JFXButton.ButtonType.RAISED);


        node.addAnimatedNode(a);
        node.addAnimatedNode(b);
        node.addAnimatedNode(c);
        node.setRotate(90);
        node.setSpacing(50);
    }

    @FXML
    public void exec(MouseEvent mouseEvent) {
        JFXButton b = new JFXButton("hola");
        JFXButton c = new JFXButton("h");
        JFXButton a = new JFXButton("hol");
        VBox vBox = new VBox(a, b, c);

        this.init(listView);
        listView.setVerticalGap(10.0);
        listView.depthProperty().set(1);
        listView.setExpanded(true);

        JFXPopup p = new JFXPopup(listView);
        p.show(opcion, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, -190.0,10.0 );
        listView.setVisible(true);




    }

    private void init(JFXListView list)
    {


        for(int i=0; i<4;i++)
        {
            Label lbl = new Label("item" +i);
            lbl.setGraphic(new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT_CIRCLE));
            list.getItems().add(lbl);
        }
    }


}
