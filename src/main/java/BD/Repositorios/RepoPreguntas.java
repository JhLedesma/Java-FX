package BD.Repositorios;

import BD.Excepciones.NoExisteObjetoConEseNombreException;
import BD.Excepciones.NoExistenObjetosException;
import BD.NombreRepositorio;
import BD.Repositorio;
import Model.Pregunta;

public class RepoPreguntas extends Repositorio<Pregunta> {

    private static RepoPreguntas instance = null;

    public RepoPreguntas(NombreRepositorio nombreTabla) {
        super(nombreTabla);
    }

    public static RepoPreguntas getInstance() {
        if (instance == null) {
            instance = new RepoPreguntas(NombreRepositorio.PREGUNTA);
        }
        return instance;
    }

    public Pregunta buscarObjeto(int numeroPregunta) throws NoExisteObjetoConEseNombreException {
        try {
            return buscarListaDeObjetos().stream().filter(x->x.getNumeroPregunta() == numeroPregunta).findFirst().orElseThrow(NoExisteObjetoConEseNombreException::new);
        }catch (NoExistenObjetosException e)
        {
            throw new NoExisteObjetoConEseNombreException();
        }
    }
}
