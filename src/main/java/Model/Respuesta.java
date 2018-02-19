package Model;

import BD.TipoDeRepositorio;

public class Respuesta implements TipoDeRepositorio {
    int numeroRespuesta;
    int valorRespuesta;

    public Respuesta(int numeroRespuesta, int valorRespuesta) {
        this.numeroRespuesta = numeroRespuesta;
        this.valorRespuesta = valorRespuesta;
    }

    public int getNumeroRespuesta() { return numeroRespuesta; }

    public int getValorRespuesta() { return valorRespuesta; }

    @Override
    public String getNombre() { return null; }
}
