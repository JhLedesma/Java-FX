package UI;

import BD.Excepciones.NoExistenObjetosException;
import BD.Proveedores.ProveedorMock;
import BD.Repositorios.RepoAspirantes;
import BD.Repositorios.RepoRespuestas;
import Model.Aspirante;
import Model.Respuesta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bootstrap
{



    public static void iniciarObjetos() throws IOException
    {
        //------------Aspirantes---------------//

        RepoAspirantes.getInstance().setProveedor(new ProveedorMock<Aspirante>());

        Aspirante aspirante = new Aspirante("Jesus", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante1 = new Aspirante("Julian", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante2 = new Aspirante("Juan", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante3 = new Aspirante("Jeremerias", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante4 = new Aspirante("Gonza", "Vieytes", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");
        Aspirante aspirante5 = new Aspirante("Mauro", "Valencia", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas");

        List<Aspirante> aspirantes = new ArrayList<Aspirante>();
        aspirantes.add(aspirante);
        aspirantes.add(aspirante1);
        aspirantes.add(aspirante2);
        aspirantes.add(aspirante3);
        aspirantes.add(aspirante4);
        aspirantes.add(aspirante5);

        RepoAspirantes.getInstance().agregarListaDeObjetos(aspirantes);
        chequearAspirantes();

        //------------Respuestas---------------//

        RepoRespuestas.getInstance().setProveedor(new ProveedorMock<Respuesta>());
        chequearRespuestas();
    }

    public static void chequearAspirantes()
    {
        try
        {
            RepoAspirantes.getInstance().buscarListaDeObjetos();
        }
        catch (NoExistenObjetosException excepcion)
        {
            iniciarAspirantes();
        }
    }

    public static void chequearRespuestas()
    {
        try
        {
            RepoRespuestas.getInstance().buscarListaDeObjetos();
        }
        catch (NoExistenObjetosException excepcion)
        {
            //Nada por ahora
        }
    }

    public static void iniciarAspirantes()
    {
        RepoAspirantes.getInstance().agregarListaDeObjetos(
                Arrays.asList(
                        new Aspirante("Ejemplo", "Ejemplo", "21", "M", "Soltero", "09/04/1996", "EspecialistaEjemplo", "M", "Ingenieria en Sistemas")
                )
        );
    }

    public static void iniciarRepositoriosDePrueba()
    {

    }

}

