package Model.Escalas.Harris_Lingoes.Ma;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Imperturbabilidad extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //8 Items: 3V y 5F
        itemsEscala.add(new ItemEscala(155,1));
        itemsEscala.add(new ItemEscala(200,1));
        itemsEscala.add(new ItemEscala(220,1));
        itemsEscala.add(new ItemEscala(93,0));
        itemsEscala.add(new ItemEscala(136,0));
        itemsEscala.add(new ItemEscala(158,0));
        itemsEscala.add(new ItemEscala(167,0));
        itemsEscala.add(new ItemEscala(243,0));
    }

    @Override
    protected void inicarPT() {

    }
}
