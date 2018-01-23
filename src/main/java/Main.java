import UI.Example.ExampleViewModel;
import UI.Example.ExampleView;
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

        //Obtengo el FXML
        ViewTuple<ExampleView, ExampleViewModel> viewTuple = FluentViewLoader.fxmlView(ExampleView.class).load();

        //Cargo la escena
        primaryStage.setScene(new Scene(viewTuple.getView()));
        primaryStage.show();

    }
}
