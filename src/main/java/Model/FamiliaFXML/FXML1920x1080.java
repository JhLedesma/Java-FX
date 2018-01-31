package Model.FamiliaFXML;

import UI.Login.Login1920x1080.LoginView1920x1080;
import UI.Login.LoginViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXML1920x1080 extends FamilyFXML
{

    @Override
    public Stage loadLogin()
    {
        Stage stage = this.createStage(1545, 830, 600, 450, 1545, 830);

        ViewTuple<LoginView1920x1080, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView1920x1080.class).load();

        stage.setScene(new Scene(viewTuple.getView()));

        return stage;
    }

}
