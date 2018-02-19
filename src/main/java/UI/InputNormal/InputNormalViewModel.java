package UI.InputNormal;

import BD.Excepciones.NoExisteObjetoConEsaQueryException;
import BD.Repositorios.RepoRespuestas;
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
            RepoRespuestas.getInstance().buscarObjetoPorQuery("Aca buscaria por numero de respuesta" + Integer.toString(numeroRespuesta));
            return true;
        }catch (NoExisteObjetoConEsaQueryException e){
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

        RepoRespuestas.getInstance().agregarObjeto(respuesta);
    }


    private void remplazarRespuesta(int numeroRespuesta, String textButton)
    {
        RepoRespuestas.getInstance().deteleByQuery("Aca elimino por numero de respuesta" + Integer.toString(numeroRespuesta));
        instanciarRespuesta(numeroRespuesta, textButton);
    }
}
