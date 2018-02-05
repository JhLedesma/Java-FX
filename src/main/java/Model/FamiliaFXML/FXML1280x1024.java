package Model.FamiliaFXML;

import UI.Inicio.Inicio1280x1024.InicioView1280x1024;
import de.saxsys.mvvmfx.FluentViewLoader;

public class FXML1280x1024 extends FamilyFXML {

    public FXML1280x1024(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width) {
        super(maxHeight, maxWidth, minHeight, minWidth, height, width);
    }

    @Override
    public void showLogin()
    {
        this.show(FluentViewLoader.fxmlView(InicioView1280x1024.class).load());
    }

    @Override
    public void showListaAspirantes() {

    }

    @Override
    public void showInicio() {

    }


}
