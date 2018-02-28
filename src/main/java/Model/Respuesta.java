package Model;

import BD.TipoDeRepositorio;

public class Respuesta implements TipoDeRepositorio {
    int numeroRespuesta;
    int valorRespuesta;
    String textButton;

    public Respuesta(int numeroRespuesta, int valorRespuesta, String textButton) {
        this.numeroRespuesta = numeroRespuesta;
        this.valorRespuesta = valorRespuesta;
        this.textButton = textButton;
    }

    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }

    public int getNumeroRespuesta() { return numeroRespuesta; }

    public int getValorRespuesta() { return valorRespuesta; }

    @Override
    public String getNombre() { return null; }
}
