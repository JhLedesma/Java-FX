package UI.InputAlternativo;

import de.saxsys.mvvmfx.ViewModel;

import java.util.Arrays;
import java.util.List;

public class InputAlternativoViewModel implements ViewModel
{
    private List<String> listaNumeroPreguntas = Arrays.asList(new String[]{"1-10","11-20", "21-30", "31-40", "41-50", "51-60", "61-70" });
    private ParserRespuestas parserRespuestas = new ParserRespuestas();
}