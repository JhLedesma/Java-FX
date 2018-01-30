package Model;

import java.awt.*;

public class GestorFXML
{

    public FamilyFXML getFamily()
    {
        Dimension screenSeize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSeize.getWidth();
        double height = screenSeize.getHeight();

        if(width >= 1920 && height >= 1080)
        {
            return new FXML1920x1080();
        }
        else
        {
            return new FXML1280x1024();
        }
    }

}
