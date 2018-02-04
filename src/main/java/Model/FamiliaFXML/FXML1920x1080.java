package Model.FamiliaFXML;

import UI.ListaAspirantes.ListaApirantes1920x1080.ListaAspirantesView1920x1080;
import UI.ListaAspirantes.ListaAspirantesViewModel;
import UI.Login.Login1920x1080.LoginView1920x1080;
import UI.Login.LoginViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXML1920x1080 extends FamilyFXML
{

    public FXML1920x1080(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        super(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    @Override
    public Stage loadLogin()
    {
        Stage stage = this.createStage();

        ViewTuple<LoginView1920x1080, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView1920x1080.class).load();

        stage.setScene(new Scene(viewTuple.getView()));

        return stage;
    }

    @Override
    public Stage loadListaAspirantes()
    {
        Stage stage = this.createStage();

        ViewTuple<ListaAspirantesView1920x1080, ListaAspirantesViewModel> viewTuple = FluentViewLoader.fxmlView(ListaAspirantesView1920x1080.class).load();

        stage.setScene(new Scene(viewTuple.getView()));

        return stage;
    }

}
