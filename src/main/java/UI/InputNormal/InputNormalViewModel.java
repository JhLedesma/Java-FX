package UI.InputNormal;

import BD.BufferRespuestas;
import BD.Excepciones.NoExisteObjetoConEseNombreException;
import Model.GestorScenas;
import Model.Respuesta;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.IntegerProperty;

public class InputNormalViewModel implements ViewModel
{

    public void crearRespuesta(int numeroRespuesta, String textButton)
    {
        if(!existeRespuesta(numeroRespuesta))
        {
            instanciarRespuesta(numeroRespuesta, textButton);
        }
        else
        {
            remplazarRespuesta(numeroRespuesta, textButton);
        }
    }



    public boolean existeRespuesta(int numeroRespuesta)
    {
        return BufferRespuestas.getInstance().existeRespuesta(numeroRespuesta);
    }


    private void instanciarRespuesta(int numeroRespuesta, String textButton)
    {
        Respuesta respuesta;

        switch (textButton)
        {
            case "Si":
                respuesta = new Respuesta(numeroRespuesta, 1, "Si");
                break;
            case "No":
                respuesta = new Respuesta(numeroRespuesta, 0, "No");
                break;
            default:
                respuesta = new Respuesta(numeroRespuesta, 2, "N/C");
                break;
        }

        BufferRespuestas.getInstance().agregar(respuesta);
    }


    private void remplazarRespuesta(int numeroRespuesta, String textButton)
    {
        BufferRespuestas.getInstance().eliminar(numeroRespuesta);
        instanciarRespuesta(numeroRespuesta, textButton);
    }


    public void guardar()
    {
        GestorScenas.getPreferenciasDeUsuario().put("GUARDADO","1");
        BufferRespuestas.getInstance().guardarRespuestas();
    }

    public void noGuardar()
    {
        GestorScenas.getPreferenciasDeUsuario().put("GUARDADO","0");
    }

}
