package Model.Escalas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Escala
{
    protected List<ItemEscala> itemsEscala = new ArrayList<>();
    protected HashMap<Integer,Integer> puntajeTVaron = new HashMap<Integer, Integer>();
    protected HashMap<Integer,Integer> puntajeTMujer = new HashMap<Integer, Integer>();

    public Escala()
    {
        iniciarItemsEscala();
        inicarPT();
    }

    protected abstract void iniciarItemsEscala();

    protected abstract void inicarPT();
}
