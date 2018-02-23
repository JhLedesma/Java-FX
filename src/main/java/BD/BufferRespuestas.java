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
        Respuesta respuesta = respuestas.stream().filter(x->x.getNumeroRespuesta() == numeroRespuesta).collect(Collectors.toList()).get(0);
        respuestas.remove(respuesta);
    }

    public Respuesta getRespuesta(int numeroRespuesta) throws NoExisteObjetoConEseNombreException
    {
        Respuesta respuesta = respuestas.stream().filter(x->x.getNumeroRespuesta() == numeroRespuesta).collect(Collectors.toList()).get(0);
        if(respuesta != null){
            return respuesta;
        }else{
            throw new NoExisteObjetoConEseNombreException();
        }
    }

    public List<Respuesta> getRespuestas()
    {
        return respuestas;
    }

    public Respuesta getUltimaRespuesta()
    {
        return respuestas.get(respuestas.size() -1);
    }

    public int getNumeroDeUltimaRespuesta()
    {
        return respuestas.get(respuestas.size() -1).getNumeroRespuesta();
    }

    public void guardarRespuestas()
    {
        if(respuestas != null)
        {
            RepoRespuestas.getInstance().agregarListaDeObjetos(respuestas);
        }
    }

    public void recuperarRespuestas()
    {
        setRespuestas(RepoRespuestas.getInstance().buscarListaDeObjetos());
        RepoRespuestas.getInstance().eliminarTodos();
    }


    public static void setRespuestas(List<Respuesta> respuestas) {
        BufferRespuestas.respuestas = respuestas;
    }
}
