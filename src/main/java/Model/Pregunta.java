package Model;

import BD.TipoDeRepositorio;

public class Pregunta implements TipoDeRepositorio
{
    int numeroPregunta;
    String textPregunta;

    public Pregunta(int numeroPregunta, String textPregunta) {
        this.numeroPregunta = numeroPregunta;
        this.textPregunta = textPregunta;
    }

    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(int numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public String getTextPregunta() {
        return textPregunta;
    }

    public void setTextPregunta(String textPregunta) {
        this.textPregunta = textPregunta;
    }

    @Override
    public String getNombre() {
        return null;
    }
}
