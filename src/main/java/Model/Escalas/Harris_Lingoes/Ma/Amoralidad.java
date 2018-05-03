package Model.Escalas.Harris_Lingoes.Ma;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Amoralidad extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //6 Items: 5V y 1F
        itemsEscala.add(new ItemEscala(131,1));
        itemsEscala.add(new ItemEscala(227,1));
        itemsEscala.add(new ItemEscala(248,1));
        itemsEscala.add(new ItemEscala(250,1));
        itemsEscala.add(new ItemEscala(269,1));
        itemsEscala.add(new ItemEscala(263,0));
    }

    @Override
    protected void inicarPT() {

    }
}
