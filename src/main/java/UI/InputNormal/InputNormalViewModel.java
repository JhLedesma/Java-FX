package UI.InputNormal;

import BD.BufferRespuestas;
import BD.Excepciones.NoExisteObjetoConEseNombreException;
import Model.Respuesta;
import de.saxsys.mvvmfx.ViewModel;

public class InputNormalViewModel implements ViewModel
{
    public void crearRespuesta(int numeroDeRespueta, String textButton)
    {
        if(!existeRespuesta(numeroDeRespueta))
        {
            instanciarRespuesta(numeroDeRespueta, textButton);
        }
        else
        {
            remplazarRespuesta(numeroDeRespueta, textButton);
        }
    }



    private boolean existeRespuesta(int numeroRespuesta)
    {
        try{
            BufferRespuestas.getInstance().getRespuesta(numeroRespuesta);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    private void instanciarRespuesta(int numeroDeRespueta, String textButton)
    {
        Respuesta respuesta;

        switch (textButton)
        {
            case "Si":
                respuesta = new Respuesta(numeroDeRespueta, 1);
                break;
            case "No":
                respuesta = new Respuesta(numeroDeRespueta, 0);
                break;
            default:
                respuesta = new Respuesta(numeroDeRespueta, 0);
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
