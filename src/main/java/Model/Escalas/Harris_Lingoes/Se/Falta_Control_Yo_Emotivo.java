package Model.Escalas.Harris_Lingoes.Se;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Falta_Control_Yo_Emotivo extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //14 Items: 11V y 3F
        itemsEscala.add(new ItemEscala(31,1));
        itemsEscala.add(new ItemEscala(38,1));
        itemsEscala.add(new ItemEscala(48,1));
        itemsEscala.add(new ItemEscala(65,1));
        itemsEscala.add(new ItemEscala(92,1));
        itemsEscala.add(new ItemEscala(233,1));
        itemsEscala.add(new ItemEscala(234,1));
        itemsEscala.add(new ItemEscala(273,1));
        itemsEscala.add(new ItemEscala(299,1));
        itemsEscala.add(new ItemEscala(303,1));
        itemsEscala.add(new ItemEscala(325,1));
        itemsEscala.add(new ItemEscala(9,0));
        itemsEscala.add(new ItemEscala(210,0));
        itemsEscala.add(new ItemEscala(290,0));
    }

    @Override
    protected void inicarPT() {

    }
}
