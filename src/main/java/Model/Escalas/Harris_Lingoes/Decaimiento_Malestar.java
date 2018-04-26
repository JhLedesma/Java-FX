package Model.Escalas.Harris_Lingoes;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Decaimiento_Malestar extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //15 Items: 5V y 10F
        itemsEscala.add(new ItemEscala(31,1));
        itemsEscala.add(new ItemEscala(39,1));
        itemsEscala.add(new ItemEscala(65,1));
        itemsEscala.add(new ItemEscala(175,1));
        itemsEscala.add(new ItemEscala(218,1));
        itemsEscala.add(new ItemEscala(2,1));
        itemsEscala.add(new ItemEscala(3,1));
        itemsEscala.add(new ItemEscala(9,1));
        itemsEscala.add(new ItemEscala(10,1));
        itemsEscala.add(new ItemEscala(45,1));
        itemsEscala.add(new ItemEscala(95,1));
        itemsEscala.add(new ItemEscala(125,1));
        itemsEscala.add(new ItemEscala(141,1));
        itemsEscala.add(new ItemEscala(148,1));
        itemsEscala.add(new ItemEscala(152,1));
    }

    @Override
    protected void inicarPT() {

    }
}
