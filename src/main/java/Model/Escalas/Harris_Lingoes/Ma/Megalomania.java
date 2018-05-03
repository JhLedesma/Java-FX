package Model.Escalas.Harris_Lingoes.Ma;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Megalomania extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //9 Items: 9V y 0F
        itemsEscala.add(new ItemEscala(13,1));
        itemsEscala.add(new ItemEscala(50,1));
        itemsEscala.add(new ItemEscala(55,1));
        itemsEscala.add(new ItemEscala(61,1));
        itemsEscala.add(new ItemEscala(98,1));
        itemsEscala.add(new ItemEscala(145,1));
        itemsEscala.add(new ItemEscala(190,1));
        itemsEscala.add(new ItemEscala(211,1));
        itemsEscala.add(new ItemEscala(212,1));
    }

    @Override
    protected void inicarPT() {

    }
}
