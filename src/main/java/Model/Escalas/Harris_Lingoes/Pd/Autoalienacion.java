package Model.Escalas.Harris_Lingoes.Pd;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Autoalienacion extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //12 Items: 10V y 2F
        itemsEscala.add(new ItemEscala(31,1));
        itemsEscala.add(new ItemEscala(32,1));
        itemsEscala.add(new ItemEscala(52,1));
        itemsEscala.add(new ItemEscala(56,1));
        itemsEscala.add(new ItemEscala(71,1));
        itemsEscala.add(new ItemEscala(82,1));
        itemsEscala.add(new ItemEscala(99,1));
        itemsEscala.add(new ItemEscala(94,1));
        itemsEscala.add(new ItemEscala(113,1));
        itemsEscala.add(new ItemEscala(264,1));
        itemsEscala.add(new ItemEscala(9,0));
        itemsEscala.add(new ItemEscala(95,0));
    }

    @Override
    protected void inicarPT() {

    }
}
