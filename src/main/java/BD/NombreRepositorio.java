package BD;

public enum NombreRepositorio {
    EMPRESA("Empresa");

    private String nombre;

    private NombreRepositorio(String nombre) {
        this.nombre = nombre;
    }

    public String darNombreRepositorio() {
        return this.nombre;
    }
}
