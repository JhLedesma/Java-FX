package Model;

public class Respuesta
{
    int numeroRespuesta;
    int valorResultado;

    public Respuesta(int numeroRespuesta, int valorResultado) {
        this.numeroRespuesta = numeroRespuesta;
        this.valorResultado = valorResultado;
    }

    public int getNumeroRespuesta() { return numeroRespuesta; }

    public int getValorResultado() { return valorResultado; }
}
