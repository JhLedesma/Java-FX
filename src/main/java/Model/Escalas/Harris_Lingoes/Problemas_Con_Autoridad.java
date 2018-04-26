package Model.Escalas.Harris_Lingoes;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Problemas_Con_Autoridad extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //8 Items: 2V y 6F
        itemsEscala.add(new ItemEscala(35,1));
        itemsEscala.add(new ItemEscala(105,1));
        itemsEscala.add(new ItemEscala(34, 0));
        itemsEscala.add(new ItemEscala(70,0));
        itemsEscala.add(new ItemEscala(129,0));
        itemsEscala.add(new ItemEscala(160,0));
        itemsEscala.add(new ItemEscala(263,0));
        itemsEscala.add(new ItemEscala(266,0));
    }

    @Override
    protected void inicarPT() {

    }
}
