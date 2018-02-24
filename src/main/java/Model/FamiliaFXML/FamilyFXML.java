package Model.FamiliaFXML;

import Model.GestorScenas;
import de.saxsys.mvvmfx.ViewTuple;

public abstract class FamilyFXML
{

    public FamilyFXML(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {

        GestorScenas.configStageApp(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    public abstract void showLogin();

    public abstract void showListaAspirantes();

    public abstract void showInicio();

    public abstract void showMenuEspecialista();

    public abstract void showInputNormal();

    public abstract void showConfiguraciones();

    public abstract void showIngresoDatosAspirante();

}
