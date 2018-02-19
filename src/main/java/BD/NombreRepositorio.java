package BD;

public enum NombreRepositorio {
    ASPIRANTE("Aspirante"),
    RESPUESTA("Respuesta");

    private String nombre;

    private NombreRepositorio(String nombre) {
        this.nombre = nombre;
    }

    public String darNombreRepositorio() {
        return this.nombre;
    }
}
