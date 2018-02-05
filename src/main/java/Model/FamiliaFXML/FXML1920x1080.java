package Model.FamiliaFXML;

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
        this.show(FluentViewLoader.fxmlView(LoginView1920x1080.class).load());
    }


    @Override
    public void showListaAspirantes()
    {
        this.show(FluentViewLoader.fxmlView(ListaAspirantesView1920x1080.class).load());

    }

    @Override
    public void showInicio() {

    }

}
