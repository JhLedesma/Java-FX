package Model;

import Model.FamiliaFXML.FXML1280x1024;
import Model.FamiliaFXML.FXML1920x1080;
import Model.FamiliaFXML.FamilyFXML;

import java.awt.*;

public class GestorFXML
{
    private static FamilyFXML instance;

    public FamilyFXML getFamily()
    {
        if(instance == null)
        {
            this.buscarFamily();
        }
        return instance;
    }

    public void buscarFamily()
    {
        Dimension screenSeize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSeize.getWidth();
        double height = screenSeize.getHeight();

        if (width == 1920.0 && height == 1080.0)
        {
            instance = new FXML1920x1080(830, 1545, 450, 600, 830, 1545);
        }
        else
        {
            instance = new FXML1280x1024(750, 1125, 450, 600, 750, 1125);
        }
    }

}
