package UI.ListaAspirantes;

import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import de.saxsys.mvvmfx.MvvmFX;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.DefaultNotificationCenter;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableStringValue;

public class ItemListViewModel implements ViewModel {

    private ReadOnlyStringWrapper  nombre = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  apellido = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  edad = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  sexo = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  estadoCivil = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  fecha = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  especialista = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  diagnostico = new ReadOnlyStringWrapper ();
    private ReadOnlyStringWrapper  titulacion = new ReadOnlyStringWrapper();

    private Aspirante aspirante;


    public ItemListViewModel(Aspirante aspirante)
    {
        this.aspirante = aspirante;
        this.nombre.set(aspirante.getNombre());
        this.apellido.set(aspirante.getApellido());
        this.edad.set(aspirante.getEdad());
        this.sexo.set(aspirante.getSexo());
        this.estadoCivil.set(aspirante.getEstadoCivil());
        this.fecha.set(aspirante.getFecha());
        this.especialista.set(aspirante.getEspecialista());
        this.diagnostico.set(aspirante.getDiagnostico());
        this.titulacion.set(aspirante.getTitulacion());
    }

    public void eliminarAspirante()
    {
        RepoAspirantes.getInstance().eliminarObjeto(aspirante);
        this.notificarAspiranteEliminado();
    }

    private void notificarAspiranteEliminado()
    {
        Model.NotificationCenter.getInstance().publish("AspiranteEliminado");
    }

    public ObservableStringValue nombreProperty()
    {
        return nombre.getReadOnlyProperty();
    }

    public ObservableStringValue apellidoProperty()
    {
        return apellido.getReadOnlyProperty();
    }

    public ObservableStringValue edadProperty()
    {
        return edad.getReadOnlyProperty();
    }

    public ObservableStringValue sexoProperty()
    {
        return sexo.getReadOnlyProperty();
    }

    public ObservableStringValue estadoCivilProperty()
    {
        return estadoCivil.getReadOnlyProperty();
    }

    public ObservableStringValue fechaProperty()
    {
        return fecha.getReadOnlyProperty();
    }

    public ObservableStringValue especialistaProperty()
    {
        return especialista.getReadOnlyProperty();
    }

    public ObservableStringValue diagnosticoProperty()
    {
        return diagnostico.getReadOnlyProperty();
    }

    public ObservableStringValue titulacionProperty()
    {
        return titulacion.getReadOnlyProperty();
    }

    public Aspirante getAspirante() {return aspirante;}


}