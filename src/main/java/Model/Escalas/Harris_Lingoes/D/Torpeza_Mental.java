package Model.Escalas.Harris_Lingoes.D;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Torpeza_Mental extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //15 Items: 8V y 7F
        itemsEscala.add(new ItemEscala(15,1));
        itemsEscala.add(new ItemEscala(31,1));
        itemsEscala.add(new ItemEscala(38,1));
        itemsEscala.add(new ItemEscala(73,1));
        itemsEscala.add(new ItemEscala(92,1));
        itemsEscala.add(new ItemEscala(147,1));
        itemsEscala.add(new ItemEscala(170,1));
        itemsEscala.add(new ItemEscala(233,1));
        itemsEscala.add(new ItemEscala(9,0));
        itemsEscala.add(new ItemEscala(10,0));
        itemsEscala.add(new ItemEscala(43,0));
        itemsEscala.add(new ItemEscala(75,0));
        itemsEscala.add(new ItemEscala(109,0));
        itemsEscala.add(new ItemEscala(165,0));
        itemsEscala.add(new ItemEscala(188,0));
    }

    @Override
    protected void inicarPT() {

    }
}
