package Model.Escalas.Harris_Lingoes.Pa;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Sufrimiento extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //9 Items: 7V y 2F
        itemsEscala.add(new ItemEscala(22,1));
        itemsEscala.add(new ItemEscala(146,1));
        itemsEscala.add(new ItemEscala(271,1));
        itemsEscala.add(new ItemEscala(277,1));
        itemsEscala.add(new ItemEscala(285,1));
        itemsEscala.add(new ItemEscala(307,1));
        itemsEscala.add(new ItemEscala(334,1));
        itemsEscala.add(new ItemEscala(100,0));
        itemsEscala.add(new ItemEscala(224,0));
    }

    @Override
    protected void inicarPT() {

    }
}
