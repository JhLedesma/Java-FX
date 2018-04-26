package Model.Escalas.Harris_Lingoes;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Inhibicion_Agresion extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //7 Items: 0V y 7F
        itemsEscala.add(new ItemEscala(7,0));
        itemsEscala.add(new ItemEscala(14,0));
        itemsEscala.add(new ItemEscala(29,0));
        itemsEscala.add(new ItemEscala(115,0));
        itemsEscala.add(new ItemEscala(116,0));
        itemsEscala.add(new ItemEscala(135,0));
        itemsEscala.add(new ItemEscala(157,0));
    }

    @Override
    protected void inicarPT() {

    }
}
