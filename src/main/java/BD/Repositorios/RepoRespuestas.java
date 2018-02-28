package BD.Repositorios;

import BD.NombreRepositorio;
import BD.Repositorio;
import Model.Respuesta;

public class RepoRespuestas extends Repositorio<Respuesta>
{
    private static RepoRespuestas instance = null;

    public RepoRespuestas(NombreRepositorio nombreTabla) {
        super(nombreTabla);
    }

    public static RepoRespuestas getInstance()
    {
        if(instance == null)
        {
            instance = new RepoRespuestas(NombreRepositorio.RESPUESTA);
        }

        return instance;
    }

}
