package Model;

import Model.FamiliaFXML.FXML1280x1024;
import Model.FamiliaFXML.FXML1920x1080;
import Model.FamiliaFXML.FamilyFXML;

import java.awt.*;

public class GestorFXML
{

    public FamilyFXML getFamily()
    {
        Dimension screenSeize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSeize.getWidth();
        double height = screenSeize.getHeight();

        if (width == 1920.0 && height == 1080.0)
        {
            return new FXML1920x1080();
        }
        else
        {
            return new FXML1280x1024();
        }
    }

}
