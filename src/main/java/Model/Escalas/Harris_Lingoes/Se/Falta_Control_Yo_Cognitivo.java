package Model.Escalas.Harris_Lingoes.Se;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Falta_Control_Yo_Cognitivo extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //10 Items: 9V y 1F
        itemsEscala.add(new ItemEscala(31,1));
        itemsEscala.add(new ItemEscala(32,1));
        itemsEscala.add(new ItemEscala(147,1));
        itemsEscala.add(new ItemEscala(170,1));
        itemsEscala.add(new ItemEscala(180,1));
        itemsEscala.add(new ItemEscala(299,1));
        itemsEscala.add(new ItemEscala(311,1));
        itemsEscala.add(new ItemEscala(316,1));
        itemsEscala.add(new ItemEscala(325,1));
        itemsEscala.add(new ItemEscala(165,0));
    }

    @Override
    protected void inicarPT() {

    }
}
