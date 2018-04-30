package Model.Escalas.Harris_Lingoes.Pa;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Ideas_Persecutorias extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //17 Items: 16V y 1F
        itemsEscala.add(new ItemEscala(17,1));
        itemsEscala.add(new ItemEscala(22,1));
        itemsEscala.add(new ItemEscala(42,1));
        itemsEscala.add(new ItemEscala(99,1));
        itemsEscala.add(new ItemEscala(113,1));
        itemsEscala.add(new ItemEscala(138,1));
        itemsEscala.add(new ItemEscala(144,1));
        itemsEscala.add(new ItemEscala(145,1));
        itemsEscala.add(new ItemEscala(162,1));
        itemsEscala.add(new ItemEscala(234,1));
        itemsEscala.add(new ItemEscala(259,1));
        itemsEscala.add(new ItemEscala(305,1));
        itemsEscala.add(new ItemEscala(333,1));
        itemsEscala.add(new ItemEscala(336,1));
        itemsEscala.add(new ItemEscala(355,1));
        itemsEscala.add(new ItemEscala(361,0));
    }

    @Override
    protected void inicarPT() {

    }
}
