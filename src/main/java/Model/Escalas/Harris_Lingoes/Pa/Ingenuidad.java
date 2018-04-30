package Model.Escalas.Harris_Lingoes.Pa;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Ingenuidad extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //9 Items: 1V y 8F
        itemsEscala.add(new ItemEscala(16,1));
        itemsEscala.add(new ItemEscala(81,0));
        itemsEscala.add(new ItemEscala(96,0));
        itemsEscala.add(new ItemEscala(104,0));
        itemsEscala.add(new ItemEscala(110,0));
        itemsEscala.add(new ItemEscala(283,0));
        itemsEscala.add(new ItemEscala(284,0));
        itemsEscala.add(new ItemEscala(286,0));
        itemsEscala.add(new ItemEscala(315,0));
    }

    @Override
    protected void inicarPT() {

    }
}
