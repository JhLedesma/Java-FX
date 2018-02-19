package UI.Login;

import Model.GestorScenas;
import de.saxsys.mvvmfx.ViewModel;
import org.apache.commons.codec.digest.DigestUtils;


public class LoginViewModel implements ViewModel {

    private String contraseña = "edf9cf90718610ee7de53c0dcc250739239044de9ba115bb0ca6026c3e4958a5";

    public String getContraseña(){

        return contraseña;

    }

    public void comprobarContraseña(String contraseñaIngresada) {

        String contraseñaHasheada = DigestUtils.sha256Hex(contraseñaIngresada);

        if(contraseñaHasheada.equals(getContraseña())){

            GestorScenas.getFamily().showMenuEspecialista();

        }
        else {



            System.out.println("Incorrecto");
            System.out.println(contraseñaHasheada);
            System.out.println(getContraseña());

        }

    }


}
