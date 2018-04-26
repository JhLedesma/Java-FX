package Model.Escalas.Harris_Lingoes;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Quejas_Somaticas extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //17 Items: 6V y 11F
        itemsEscala.add(new ItemEscala(11,1));
        itemsEscala.add(new ItemEscala(18,1));
        itemsEscala.add(new ItemEscala(40,1));
        itemsEscala.add(new ItemEscala(44,1));
        itemsEscala.add(new ItemEscala(101,1));
        itemsEscala.add(new ItemEscala(172,1));
        itemsEscala.add(new ItemEscala(8,0));
        itemsEscala.add(new ItemEscala(47,0));
        itemsEscala.add(new ItemEscala(91,0));
        itemsEscala.add(new ItemEscala(159,0));
        itemsEscala.add(new ItemEscala(164,0));
        itemsEscala.add(new ItemEscala(173,0));
        itemsEscala.add(new ItemEscala(176,0));
        itemsEscala.add(new ItemEscala(179,0));
        itemsEscala.add(new ItemEscala(208,0));
        itemsEscala.add(new ItemEscala(224,0));
        itemsEscala.add(new ItemEscala(249,0));
    }

    @Override
    protected void inicarPT() {

    }
}
