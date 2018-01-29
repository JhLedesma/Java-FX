import UI.ExampleViewModel;
import UI.ExampleView;
import UI.Login.LoginView;
import UI.Login.LoginViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application
{
    public static void main(String...args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Nombre del escenario
        primaryStage.setTitle("Test MMPI 2");

        //primaryStage.setResizable(false);

        Dimension screenSeize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSeize.getWidth();
        double height = screenSeize.getHeight();

        if(width == 1280.0 && height == 1024.0) {

        primaryStage.setMaxHeight(700);
        primaryStage.setMaxWidth(1125);
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(600);
        primaryStage.setHeight(700);
        primaryStage.setWidth(1125);

        }

        else {

            if (width == 1920.0 && height == 1080.0){

                primaryStage.setMaxHeight(830);
                primaryStage.setMaxWidth(1545);
                primaryStage.setMinHeight(450);
                primaryStage.setMinWidth(600);
                primaryStage.setHeight(830);
                primaryStage.setWidth(1545);

            }

        }


        System.out.println(width);
        System.out.println(height);

        //Obtengo el FXML
        ViewTuple<LoginView, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView.class).load();

        //Cargo la escena
        primaryStage.setScene(new Scene(viewTuple.getView()));
        primaryStage.show();

    }
}
