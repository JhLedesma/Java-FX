package Model.Escalas.Harris_Lingoes.Ma;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Aceleracion_Psicomotora extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //11 Items: 9V y 2F
        itemsEscala.add(new ItemEscala(15,1));
        itemsEscala.add(new ItemEscala(85,1));
        itemsEscala.add(new ItemEscala(87,1));
        itemsEscala.add(new ItemEscala(122,1));
        itemsEscala.add(new ItemEscala(169,1));
        itemsEscala.add(new ItemEscala(206,1));
        itemsEscala.add(new ItemEscala(218,1));
        itemsEscala.add(new ItemEscala(242,1));
        itemsEscala.add(new ItemEscala(244,1));
        itemsEscala.add(new ItemEscala(100,0));
        itemsEscala.add(new ItemEscala(106,0));
    }

    @Override
    protected void inicarPT() {

    }
}
