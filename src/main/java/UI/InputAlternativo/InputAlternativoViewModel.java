package UI.InputAlternativo;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputAlternativoViewModel implements ViewModel
{

    private int numeroPreguntasActuales = 0;
    private List<String> listaNumeroPreguntas = Arrays.asList(new String[]{"1-10","11-20", "21-30", "31-40", "41-50", "51-60", "61-70","71-80", "81-90","91-100", "101-110", "111-120", "121-130", "131-140", "141-150", "151-160", "161-170", "171-180", "181-190", "191-200", "201-210", "211-220", "221-230", "231-240", "241-250", "251-260", "261-270", "271-280", "281-290", "291-300", "301-310", "311-320", "321-330", "331-340", "341-350", "351-360", "361-370", "371-380", "381-390", "391-400", "401-410", "411-420", "421-430", "431-440", "441-450", "451-460", "461-470", "471-480", "481-490", "491-500", "501-510", "511-520", "521-530", "531-540", "541-550", "551-560" ,"560-567"});
    private List<String> listaDeRespuestas = new ArrayList<>();
    private StringProperty stringDePregunta = new SimpleStringProperty("Preguntas del " + listaNumeroPreguntas.get(0));

    public StringProperty stringDePreguntaProperty(){
        return stringDePregunta;
    }

    public String getStringDePregunta(){
        return stringDePregunta.get();
    }

    public int getNumeroPreguntasActuales() {
        return numeroPreguntasActuales;
    }

    public void setStringDePregunta(String message){
        stringDePregunta.set(message);
    }

    public List<String> getListaDeRespuestas() {
        return listaDeRespuestas;
    }

    public List<String> getListaNumeroPreguntas() {
        return listaNumeroPreguntas;
    }

    public void setNumeroPreguntasActuales(int numeroPreguntasActuales) {
        this.numeroPreguntasActuales = numeroPreguntasActuales;
    }

}