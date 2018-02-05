package Model;

import Model.FamiliaFXML.FXML1280x1024;
import Model.FamiliaFXML.FXML1920x1080;
import Model.FamiliaFXML.FamilyFXML;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class GestorScenas
{
    private static FamilyFXML familyFXML;

    private static Stage stageApp;

    public static FamilyFXML getFamily()
    {
        if(familyFXML == null)
        {
            buscarFamily();
        }
        return familyFXML;
    }

    private static void buscarFamily()
    {
        Dimension screenSeize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSeize.getWidth();
        double height = screenSeize.getHeight();

        if (width == 1920.0 && height == 1080.0)
        {
            familyFXML = new FXML1920x1080(830, 1545, 450, 600, 830, 1545);
        }
        else
        {
            familyFXML = new FXML1280x1024(750, 1125, 450, 600, 750, 1125);
        }
    }

    public static Stage getStageApp() {
        return stageApp;
    }

    public static void setStageApp(Stage newStageApp) {
        stageApp = newStageApp;
    }

    public static void setSceneAppStage(ViewTuple viewTuple)
    {
        stageApp.setScene(new Scene(viewTuple.getView()));

    }

    public static Stage createStage(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width)
    {
        Stage stage = new Stage();

        stage.setMaxHeight(maxHeight);
        stage.setMaxWidth(maxWidth);
        stage.setMinHeight(minHeight);
        stage.setMinWidth(minWidth);
        stage.setHeight(height);
        stage.setWidth(width);

        return stage;
    }

    public static void configStageApp(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width)
    {
        Stage stage = GestorScenas.getStageApp();

        stage.setMaxHeight(maxHeight);
        stage.setMaxWidth(maxWidth);
        stage.setMinHeight(minHeight);
        stage.setMinWidth(minWidth);
        stage.setHeight(height);
        stage.setWidth(width);

        GestorScenas.setStageApp(stage);
    }
}
