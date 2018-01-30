package Model;

import UI.Login.LoginViewModel;
import UI.Login.LoginView1920x1080View;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXML1920x1080 extends FamilyFXML {

    @Override
    public Stage loadLogin() {
        ViewTuple<LoginView1920x1080View, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView1920x1080View.class).load();

        Stage stage = this.createStage();
        stage.setScene(new Scene(viewTuple.getView()));

        return stage;
    }

    @Override
    protected Stage createStage() {
        Stage stage = new Stage();

        stage.setMaxHeight(830);
        stage.setMaxWidth(1545);
        stage.setMinHeight(450);
        stage.setMinWidth(600);
        stage.setHeight(830);
        stage.setWidth(1545);

        return stage;
    }
}
