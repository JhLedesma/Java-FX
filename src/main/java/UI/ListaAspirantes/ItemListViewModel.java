package UI.ListaAspirantes;

import BD.Repositorios.RepoAspirantes;
import Model.Aspirante;
import de.saxsys.mvvmfx.MvvmFX;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.DefaultNotificationCenter;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.StringProperty;
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

    private StringProperty nombreEdit = new ReadOnlyStringWrapper();
    private StringProperty  apellidoEdit = new ReadOnlyStringWrapper();
    private StringProperty  edadEdit = new ReadOnlyStringWrapper();
    private StringProperty  sexoEdit = new ReadOnlyStringWrapper();
    private StringProperty  estadoCivilEdit = new ReadOnlyStringWrapper();
    private ReadOnlyStringWrapper  fechaEdit = new ReadOnlyStringWrapper();
    private StringProperty  especialistaEdit = new ReadOnlyStringWrapper();
    private ReadOnlyStringWrapper  diagnosticoEdit = new ReadOnlyStringWrapper();
    private StringProperty  titulacionEdit = new ReadOnlyStringWrapper();

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

        this.nombreEdit.set(nombre.get());
        this.apellidoEdit.set(apellido.get());
        this.edadEdit.set(edad.get());
        this.sexoEdit.set(sexo.get());
        this.estadoCivilEdit.set(estadoCivil.get());
        this.fechaEdit.set(fecha.get());
        this.especialistaEdit.set(especialista.get());
        this.diagnosticoEdit.set(diagnostico.get());
        this.titulacionEdit.set(titulacion.get());
    }

//-------------BotonEliminar--------------------//

    public void eliminarAspirante()
    {
        RepoAspirantes.getInstance().eliminarObjeto(aspirante);
        this.notificarAspiranteEliminado();
    }

    private void notificarAspiranteEliminado()
    {
        Model.NotificationCenter.getInstance().publish("AspiranteEliminado");
    }

//-----------------------BotonModificarDatos-----------------------//

    public void validarEditText()
    {
        String nombre_;
        String apellido_;
        String edad_;
        String sexo_;
        String estadoCivil_;
        String especialista_;
        String titulacion_;

        if(nombreEdit.get() != null && !nombreEdit.get().equals(nombre.get()))
        {
            nombre_ = nombreEdit.get();
            nombre.set(nombreEdit.get());
        }else{
            nombre_ = nombre.get();
        }
        if(apellidoEdit.get() != null && !apellidoEdit.get().equals(apellido.get()))
        {
            apellido_ = apellidoEdit.get();
            apellido.set(apellidoEdit.get());
        }else{
            apellido_ = apellido.get();
        }
        if(edadEdit.get() != null && !edadEdit.get().equals(edad.get()))
        {
            edad_ = edadEdit.get();
            edad.set(edadEdit.get());
        }else{
            edad_ = edad.get();
        }
        if(sexoEdit.get() != null && !sexoEdit.get().equals(sexo.get()))
        {
            sexo_ = sexoEdit.get();
            sexo.set(sexoEdit.get());
        }else{
            sexo_ = sexo.get();
        }
        if(estadoCivilEdit.get() != null && !estadoCivilEdit.get().equals(estadoCivil.get()))
        {
            estadoCivil_ = estadoCivilEdit.get();
            estadoCivil.set(estadoCivilEdit.get());
        }else{
            estadoCivil_ = estadoCivil.get();
        }
        if(especialistaEdit.get() != null && !especialistaEdit.get().equals(especialista.get()))
        {
            especialista_ = especialistaEdit.get();
            especialista.set(especialistaEdit.get());
        }else{
            especialista_ = especialista.get();
        }
        if(titulacionEdit.get() != null && !titulacionEdit.get().equals(titulacion.get()))
        {
            titulacion_ = titulacionEdit.get();
            titulacion.set(titulacionEdit.get());
        }else{
            titulacion_ = titulacion.get();
        }

        this.modificarAspirante(nombre_, apellido_, edad_, sexo_, estadoCivil_, fecha.get(), especialista_, diagnostico.get(), titulacion_);

    }

    private void modificarAspirante(String nombre, String apellido, String edad, String sexo, String estadoCivil, String fecha, String especialista, String diagnostico, String titulacion)
    {
        RepoAspirantes.getInstance().eliminarObjeto(aspirante);
        RepoAspirantes.getInstance().agregarObjeto(new Aspirante(nombre, apellido, edad, sexo, estadoCivil, fecha, especialista, diagnostico, titulacion));
    }

    public void restaurarModificacion()
    {
        this.nombreEdit.set(nombre.get());
        this.apellidoEdit.set(apellido.get());
        this.edadEdit.set(edad.get());
        this.sexoEdit.set(sexo.get());
        this.estadoCivilEdit.set(estadoCivil.get());
        this.fechaEdit.set(fecha.get());
        this.especialistaEdit.set(especialista.get());
        this.diagnosticoEdit.set(diagnostico.get());
        this.titulacionEdit.set(titulacion.get());
    }

//--------------------------------------------Getters------------------------------------------------//

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

    public ReadOnlyStringWrapper diagnosticoEditProperty() { return diagnosticoEdit; }

    public ReadOnlyStringWrapper fechaEditProperty() { return fechaEdit; }

    public StringProperty nombreEditProperty() { return nombreEdit; }

    public StringProperty apellidoEditProperty() { return apellidoEdit; }

    public StringProperty edadEditProperty() { return edadEdit; }

    public StringProperty sexoEditProperty() { return sexoEdit; }

    public StringProperty estadoCivilEditProperty() { return estadoCivilEdit; }

    public StringProperty especialistaEditProperty() { return especialistaEdit; }

    public StringProperty titulacionEditProperty() { return titulacionEdit; }

    public Aspirante getAspirante() {return aspirante;}


}