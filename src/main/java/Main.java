import Model.GestorFXML;
import javafx.application.Application;
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

       primaryStage = new GestorFXML().getFamily().loadLogin();
       primaryStage.show();

    }
}
