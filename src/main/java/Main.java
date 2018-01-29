import UI.ExampleViewModel;
import UI.ExampleView;
import UI.Login.LoginView;
import UI.Login.LoginViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String...args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Nombre del escenario
        primaryStage.setTitle("Test MMPI 2");
        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(700);
        primaryStage.setMaxWidth(1125);
        primaryStage.setHeight(700);
        primaryStage.setWidth(1125);

        //Obtengo el FXML
        ViewTuple<LoginView, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView.class).load();

        //Cargo la escena
        primaryStage.setScene(new Scene(viewTuple.getView()));
        primaryStage.show();

    }
}
