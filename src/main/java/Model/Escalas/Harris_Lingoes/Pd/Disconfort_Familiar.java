package Model.Escalas.Harris_Lingoes.Pd;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Disconfort_Familiar extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //9 Items: 5V y 4F
        itemsEscala.add(new ItemEscala(21,1));
        itemsEscala.add(new ItemEscala(54,1));
        itemsEscala.add(new ItemEscala(195,1));
        itemsEscala.add(new ItemEscala(202,1));
        itemsEscala.add(new ItemEscala(288,1));
        itemsEscala.add(new ItemEscala(83,0));
        itemsEscala.add(new ItemEscala(125,0));
        itemsEscala.add(new ItemEscala(214,0));
        itemsEscala.add(new ItemEscala(217,0));
    }

    @Override
    protected void inicarPT() {

    }
}
