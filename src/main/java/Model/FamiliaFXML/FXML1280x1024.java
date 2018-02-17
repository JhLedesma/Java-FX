package Model.FamiliaFXML;

import Model.GestorScenas;
import UI.Inicio.Inicio1280x1024.InicioView1280x1024;
import UI.InputNormal.InputNormal1280x1024.InputNormalView1280x1024;
import UI.Login.Login1280x1024.LoginView1280x1024;
import UI.MenuEspecialista.MenuEspecialista1280x1024.MenuEspecialistaView1280x1024;
import de.saxsys.mvvmfx.FluentViewLoader;

public class FXML1280x1024 extends FamilyFXML {

    public FXML1280x1024(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        super(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    @Override
    public void showLogin()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(LoginView1280x1024.class).load().getView());
    }

    @Override
    public void showListaAspirantes()
    {

    }

    @Override
    public void showInicio()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(InicioView1280x1024.class).load().getView());
    }

    @Override
    public void showMenuEspecialista()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(MenuEspecialistaView1280x1024.class).load().getView());
    }

    @Override
    public void showInputNormal()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(InputNormalView1280x1024.class).load().getView());
    }

    @Override
    public void showConfiguraciones()
    {

    }


}
