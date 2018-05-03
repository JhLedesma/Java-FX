package Model.Escalas.Si;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Evitacion_Social extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //8 Items: 2V y 6F
        itemsEscala.add(new ItemEscala(337,1));
        itemsEscala.add(new ItemEscala(367,1));
        itemsEscala.add(new ItemEscala(86,0));
        itemsEscala.add(new ItemEscala(340,0));
        itemsEscala.add(new ItemEscala(353,0));
        itemsEscala.add(new ItemEscala(359,0));
        itemsEscala.add(new ItemEscala(363,0));
        itemsEscala.add(new ItemEscala(370,0));
    }

    @Override
    protected void inicarPT() {

    }
}
