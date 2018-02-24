package UI.InputNormal;

import BD.BufferRespuestas;
import BD.Excepciones.NoExisteObjetoConEseNombreException;
import Model.Respuesta;
import de.saxsys.mvvmfx.ViewModel;

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



    private boolean existeRespuesta(int numeroRespuesta)
    {
        return BufferRespuestas.getInstance().existeRespuesta(numeroRespuesta);
    }


    private void instanciarRespuesta(int numeroRespuesta, String textButton)
    {
        Respuesta respuesta;

        switch (textButton)
        {
            case "Si":
                respuesta = new Respuesta(numeroRespuesta, 1);
                break;
            case "No":
                respuesta = new Respuesta(numeroRespuesta, 0);
                break;
            default:
                respuesta = new Respuesta(numeroRespuesta, 0);
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
        BufferRespuestas.getInstance().guardarRespuestas();
    }
}
