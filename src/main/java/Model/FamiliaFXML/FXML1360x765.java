package Model.FamiliaFXML;

import Model.GestorScenas;
import UI.Inicio.Inicio1280x1024.InicioView1280x1024;
import UI.Inicio.Inicio1360x765.InicioView1360x765;
import UI.Login.Login1280x1024.LoginView1280x1024;
import UI.Login.Login1360x765.LoginView1360x765;
import UI.MenuEspecialista.MenuEspecialista1280x1024.MenuEspecialistaView1280x1024;
import UI.MenuEspecialista.MenuEspecialista1360x765.MenuEspecialistaView1360x765;
import de.saxsys.mvvmfx.FluentViewLoader;

public class FXML1360x765 extends FamilyFXML {


    public FXML1360x765(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        super(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    @Override
    public void showLogin() {

        GestorScenas.show(FluentViewLoader.fxmlView(LoginView1360x765.class).load().getView());

    }

    @Override
    public void showListaAspirantes() {

    }

    @Override
    public void showInicio() {

        GestorScenas.show(FluentViewLoader.fxmlView(InicioView1360x765.class).load().getView());

    }

    @Override
    public void showMenuEspecialista() {

        GestorScenas.show(FluentViewLoader.fxmlView(MenuEspecialistaView1360x765.class).load().getView());

    }

    @Override
    public void showInputNormal() {

    }

    @Override
    public void showConfiguraciones() {

    }

    @Override
    public void showIngresoDatosAspirante() {

    }

    @Override
    public void showInputAlternativo() {

    }
}
