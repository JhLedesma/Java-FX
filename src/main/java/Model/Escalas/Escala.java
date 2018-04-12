package Model.Escalas;

import java.util.ArrayList;
import java.util.List;

public abstract class Escala
{
    protected List<ItemEscala> itemsEscala = new ArrayList<>();

    public Escala()
    {
        iniciarItemsEscala();
        inicarPT();
    }

    protected abstract void iniciarItemsEscala();

    protected abstract void inicarPT();
}
