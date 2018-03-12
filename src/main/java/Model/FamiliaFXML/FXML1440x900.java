package Model.FamiliaFXML;

import Model.GestorScenas;
import UI.ListaAspirantes.ListaApirantes1920x1080.ListaAspirantesView1920x1080;
import UI.ListaAspirantes.ListaAspirantes1440x900.ListaAspirantesView1440x900;
import de.saxsys.mvvmfx.FluentViewLoader;

public class FXML1440x900 extends FamilyFXML
{
    public FXML1440x900(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        super(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    @Override
    public void showLogin() {

    }

    @Override
    public void showListaAspirantes()
    {
        GestorScenas.show(FluentViewLoader.fxmlView(ListaAspirantesView1440x900.class).load().getView());
    }

    @Override
    public void showInicio() {

    }

    @Override
    public void showMenuEspecialista() {

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
