package Model.FamiliaFXML;

import Model.FamiliaFXML.FamilyFXML;
import UI.Login.LoginViewModel;
import UI.Login.View1280x1024.LoginView1280x1024;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXML1280x1024 extends FamilyFXML {

    @Override
    public Stage loadLogin() {
        Stage stage = this.createStage(1125, 700, 600, 450, 1125, 700);

        ViewTuple<LoginView1280x1024, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView1280x1024.class).load();

        stage.setScene(new Scene(viewTuple.getView()));

        return stage;
    }

}
