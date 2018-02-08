package Model.FamiliaFXML;

import Model.GestorScenas;
import UI.Inicio.Inicio1280x1024.InicioView1280x1024;
import UI.ListaAspirantes.ListaApirantes1920x1080.ListaAspirantesView1920x1080;
import de.saxsys.mvvmfx.FluentViewLoader;

public class FXML1280x1024 extends FamilyFXML {

    public FXML1280x1024(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        super(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    @Override
    public void showLogin()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(InicioView1280x1024.class).load().getView());
    }

    @Override
    public void showListaAspirantes()
    {

    }

    @Override
    public void showInicio()
    {

    }


}
