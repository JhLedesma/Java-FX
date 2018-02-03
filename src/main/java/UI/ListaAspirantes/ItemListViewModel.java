package UI.ListaAspirantes;

import Model.Aspirante;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemListViewModel implements ViewModel {

    private StringProperty nombre = new SimpleStringProperty();
    private StringProperty apellido = new SimpleStringProperty();
    private StringProperty edad = new SimpleStringProperty();
    private StringProperty sexo = new SimpleStringProperty();
    private StringProperty estadoCivil = new SimpleStringProperty();
    private StringProperty fecha = new SimpleStringProperty();
    private StringProperty especialista = new SimpleStringProperty();
    private StringProperty diagnostico = new SimpleStringProperty();
    private StringProperty titulacion = new SimpleStringProperty();

    public ItemListViewModel(Aspirante aspirante)
    {
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

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellido() {
        return apellido.get();
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public String getEdad() {
        return edad.get();
    }

    public StringProperty edadProperty() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad.set(edad);
    }

    public String getSexo() {
        return sexo.get();
    }

    public StringProperty sexoProperty() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }

    public String getEstadoCivil() {
        return estadoCivil.get();
    }

    public StringProperty estadoCivilProperty() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil.set(estadoCivil);
    }

    public String getFecha() {
        return fecha.get();
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getEspecialista() {
        return especialista.get();
    }

    public StringProperty especialistaProperty() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista.set(especialista);
    }

    public String getDiagnostico() {
        return diagnostico.get();
    }

    public StringProperty diagnosticoProperty() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico.set(diagnostico);
    }

    public String getTitulacion() {
        return titulacion.get();
    }

    public StringProperty titulacionProperty() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion.set(titulacion);
    }
}