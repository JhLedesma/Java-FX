package Model.Escalas.Harris_Lingoes;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Alienacion_Social extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //13 Items: 10V y 3F
        itemsEscala.add(new ItemEscala(17,1));
        itemsEscala.add(new ItemEscala(22,1));
        itemsEscala.add(new ItemEscala(42,1));
        itemsEscala.add(new ItemEscala(56,1));
        itemsEscala.add(new ItemEscala(82,1));
        itemsEscala.add(new ItemEscala(99,1));
        itemsEscala.add(new ItemEscala(113,1));
        itemsEscala.add(new ItemEscala(219,1));
        itemsEscala.add(new ItemEscala(225,1));
        itemsEscala.add(new ItemEscala(259,1));
        itemsEscala.add(new ItemEscala(12,0));
        itemsEscala.add(new ItemEscala(129,0));
        itemsEscala.add(new ItemEscala(157,0));
    }

    @Override
    protected void inicarPT() {

    }
}
