package Model.Escalas.Harris_Lingoes.Pd;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Imperturbalidad_Social extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //6 Items: 0V y 6F
        itemsEscala.add(new ItemEscala(70,0));
        itemsEscala.add(new ItemEscala(129,0));
        itemsEscala.add(new ItemEscala(158,0));
        itemsEscala.add(new ItemEscala(167,0));
        itemsEscala.add(new ItemEscala(185,0));
        itemsEscala.add(new ItemEscala(243,0));
    }

    @Override
    protected void inicarPT() {

    }
}
