package UI.MenuEspecialista;

import Model.GestorScenas;
import de.saxsys.mvvmfx.ViewModel;

public class MenuEspecialistaViewModel implements ViewModel {

    public void guardarAlternativa1(){

        GestorScenas.getPreferenciasDeUsuario().put("ALTERNATIVA","1");

    }

    public void cancelarTestGuardado()
    {
       GestorScenas.getPreferenciasDeUsuario().put("GUARDADO","0");
    }

}
