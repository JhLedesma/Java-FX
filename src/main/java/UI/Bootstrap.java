package UI;

import BD.Excepciones.NoExistenObjetosException;
import BD.Proveedores.ProveedorMock;
import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;

import java.io.IOException;
import java.util.Arrays;

public class Bootstrap
{

    public static void iniciarRepositoriosDePrueba()
    {
        RepoAspirantes.getInstance().setProveedor(new ProveedorMock<Aspirante>());
    }

    public static void iniciarObjetos() throws IOException
    {
        chequearAspirantes();
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

    public static void iniciarAspirantes()
    {
        RepoAspirantes.getInstance().agregarListaDeObjetos(
                Arrays.asList(
                        new Aspirante("Jesus", "Ledesma", "21", "M", "Soltero", "09/04/1996", "Vieytes", "M", "Ingenieria en Sistemas")
                )
        );
    }

}

