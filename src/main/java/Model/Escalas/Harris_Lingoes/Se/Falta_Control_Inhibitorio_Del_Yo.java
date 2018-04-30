package Model.Escalas.Harris_Lingoes.Se;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Falta_Control_Inhibitorio_Del_Yo extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //11 Items: 1V y 0F
        itemsEscala.add(new ItemEscala(23,1));
        itemsEscala.add(new ItemEscala(85,1));
        itemsEscala.add(new ItemEscala(168,1));
        itemsEscala.add(new ItemEscala(182,1));
        itemsEscala.add(new ItemEscala(218,1));
        itemsEscala.add(new ItemEscala(242,1));
        itemsEscala.add(new ItemEscala(274,1));
        itemsEscala.add(new ItemEscala(320,1));
        itemsEscala.add(new ItemEscala(322,1));
        itemsEscala.add(new ItemEscala(329,1));
        itemsEscala.add(new ItemEscala(355,1));
    }

    @Override
    protected void inicarPT() {

    }
}
