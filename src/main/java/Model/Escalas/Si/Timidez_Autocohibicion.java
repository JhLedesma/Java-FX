package Model.Escalas.Si;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Timidez_Autocohibicion extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //14 Items: 8V y 6F
        itemsEscala.add(new ItemEscala(158,1));
        itemsEscala.add(new ItemEscala(161,1));
        itemsEscala.add(new ItemEscala(167,1));
        itemsEscala.add(new ItemEscala(185,1));
        itemsEscala.add(new ItemEscala(243,1));
        itemsEscala.add(new ItemEscala(265,1));
        itemsEscala.add(new ItemEscala(275,1));
        itemsEscala.add(new ItemEscala(289,1));
        itemsEscala.add(new ItemEscala(49,0));
        itemsEscala.add(new ItemEscala(262,0));
        itemsEscala.add(new ItemEscala(280,0));
        itemsEscala.add(new ItemEscala(321,0));
        itemsEscala.add(new ItemEscala(342,0));
        itemsEscala.add(new ItemEscala(360,0));
    }

    @Override
    protected void inicarPT() {

    }
}
