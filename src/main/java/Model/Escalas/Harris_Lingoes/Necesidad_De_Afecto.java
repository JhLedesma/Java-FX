package Model.Escalas.Harris_Lingoes;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Necesidad_De_Afecto extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //12 Items: 1V y 11F
        itemsEscala.add(new ItemEscala(230,1));
        itemsEscala.add(new ItemEscala(26,0));
        itemsEscala.add(new ItemEscala(58,0));
        itemsEscala.add(new ItemEscala(76,0));
        itemsEscala.add(new ItemEscala(81,0));
        itemsEscala.add(new ItemEscala(98,0));
        itemsEscala.add(new ItemEscala(110,0));
        itemsEscala.add(new ItemEscala(124,0));
        itemsEscala.add(new ItemEscala(151,0));
        itemsEscala.add(new ItemEscala(213,0));
        itemsEscala.add(new ItemEscala(241,0));
        itemsEscala.add(new ItemEscala(263,0));
    }

    @Override
    protected void inicarPT() {

    }
}
