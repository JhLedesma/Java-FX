package BD;

import BD.Excepciones.NoExisteObjetoConEseNombreException;
import BD.Excepciones.NoExistenObjetosException;
import BD.Repositorios.RepoRespuestas;
import Model.Respuesta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BufferRespuestas
{
    private static BufferRespuestas instance;

    private static List<Respuesta> respuestas = new ArrayList<>();

    public static BufferRespuestas getInstance()
    {
        if (instance == null) {
            instance = new BufferRespuestas();
        }
        return instance;
    }

    public void agregar(Respuesta respuesta)
    {
        respuestas.add(respuesta);
    }

    public void agregar(List<Respuesta> respuestas)
    {
        respuestas.addAll(respuestas);
    }

    public void eliminar(Respuesta respuesta)
    {
        respuestas.remove(respuesta);
    }

    public void eliminar(int numeroRespuesta)
    {
        try
        {
            Respuesta respuesta = getRespuesta(numeroRespuesta);
            respuestas.remove(respuesta);
        }
        catch (NoExisteObjetoConEseNombreException e)
        {
            //No hago nada, ya que si no existe, da igual si se elimina o no, ademas de que no quiero que se detenga el programa, asi funciona el remove de las listas
        }
    }

    public Respuesta getRespuesta(int numeroRespuesta) throws NoExisteObjetoConEseNombreException
    {
        try
        {
            Respuesta respuesta = respuestas.stream().filter(x->x.getNumeroRespuesta() == numeroRespuesta).findFirst().get();
            return respuesta;
        }
        catch (Exception e)
        {
            throw new NoExisteObjetoConEseNombreException();
        }

    }

    public List<Respuesta> getRespuestas() throws NoExistenObjetosException
    {
        if(respuestas.size() != 0)
        {
            return respuestas;
        }
        else
        {
            throw new NoExistenObjetosException();
        }
    }

    public Respuesta getUltimaRespuesta() throws NoExisteObjetoConEseNombreException
    {
            return getRespuesta(respuestas.size());
    }


    public int getNumeroDeUltimaRespuesta() throws NoExisteObjetoConEseNombreException
    {
        return getUltimaRespuesta().getNumeroRespuesta();
    }


    public boolean existeRespuesta(int numeroRespuesta)
    {
      return respuestas.stream().anyMatch(x->x.getNumeroRespuesta() == numeroRespuesta);
    }


    public void guardarRespuestas()
    {
        if(respuestas.size() != 0)
        {
            RepoRespuestas.getInstance().agregarListaDeObjetos(respuestas);
        }
    }

    public void recuperarRespuestas()
    {
        try
        {
            setRespuestas(RepoRespuestas.getInstance().buscarListaDeObjetos());
            //RepoRespuestas.getInstance().eliminarTodos();
        }
        catch (NoExistenObjetosException e)
        {
            //No hace nada, ya que si no hay nada en el repo es porque no hay nada que recuperar
        }

    }


    public static void setRespuestas(List<Respuesta> respuestas_) {
        respuestas = respuestas_;
    }
}
