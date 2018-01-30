import Model.GestorFXML;
import UI.Login.View1920x1080.LoginView1920x1080;
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

       primaryStage = new GestorFXML().getFamily().loadLogin();
       primaryStage.show();

    }
}
