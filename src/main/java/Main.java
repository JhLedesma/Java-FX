import Model.GestorFXML;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    private static Stage primaryStage;

    public static void main(String...args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = new GestorFXML().getFamily().loadLogin();
        primaryStage.show();

    }

    public static Stage getStage()
    {
        return primaryStage;
    }
}
