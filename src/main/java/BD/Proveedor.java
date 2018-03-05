package BD;

import BD.Excepciones.NoExisteObjetoConEseNombreException;
import BD.Excepciones.NoExistenObjetosException;

import java.util.List;

public interface Proveedor<T extends TipoDeRepositorio>{

    public void setLista(List<T> lista);

    public T darObjeto(String unNombre, String unTipo) throws NoExisteObjetoConEseNombreException;

    public List<T> darLista(String unTipo) throws NoExistenObjetosException;

    public List<String> darListaNombres(String unTipo);

    public void agregar(T unObjeto);

    public void agregarLista(List<T> listaObjetos);

    public void modificar(T unObjeto) throws NoExisteObjetoConEseNombreException;

    public void eliminar(T unObjeto);

    public T ejecutarQuery(Object query);

    public List<T> EjecutarQueryReturnList(Object query) throws NoExistenObjetosException;

    public void eliminarConQuery(Object query);
}
