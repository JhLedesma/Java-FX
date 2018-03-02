package Model.FamiliaFXML;

import Model.GestorScenas;
import UI.InputAlternativo.InputAlternativo1920x1080.InputAlternativoView1920x1080;
import UI.ListaAspirantes.ListaApirantes1920x1080.ListaAspirantesView1920x1080;
import UI.Login.Login1920x1080.LoginView1920x1080;
import de.saxsys.mvvmfx.FluentViewLoader;

public class FXML1920x1080 extends FamilyFXML
{

    public FXML1920x1080(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        super(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    @Override
    public void showLogin()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(LoginView1920x1080.class).load().getView());
    }


    @Override
    public void showListaAspirantes()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(ListaAspirantesView1920x1080.class).load().getView());
    }

    @Override
    public void showInputAlternativo() {
        GestorScenas.show(FluentViewLoader.fxmlView(InputAlternativoView1920x1080.class).load().getView());
    }

    @Override
    public void showInicio()
    {

    }

    @Override
    public void showMenuEspecialista()
    {

    }

    @Override
    public void showInputNormal()
    {

    }

    @Override
    public void showConfiguraciones()
    {

    }

    @Override
    public void showIngresoDatosAspirante() {

    }

}
