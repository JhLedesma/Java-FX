package BD.Repositorios;

import BD.NombreRepositorio;
import BD.Repositorio;
import Model.Aspirante;

public class RepoAspirantes extends Repositorio<Aspirante>
{
    private static RepoAspirantes instance = null;

    public RepoAspirantes(NombreRepositorio nombreTabla) {
        super(nombreTabla);
    }

    public static RepoAspirantes getInstance()
    {
        if(instance == null)
        {
            instance = new RepoAspirantes(NombreRepositorio.ASPIRANTE);
        }

        return instance;
    }
}
