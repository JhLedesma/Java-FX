package Model.Escalas.Si;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Alineacion_De_Si_Mismo_Y_Otros extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //17 Items: 14V y 3F
        itemsEscala.add(new ItemEscala(31,1));
        itemsEscala.add(new ItemEscala(56,1));
        itemsEscala.add(new ItemEscala(104,1));
        itemsEscala.add(new ItemEscala(110,1));
        itemsEscala.add(new ItemEscala(135,1));
        itemsEscala.add(new ItemEscala(284,1));
        itemsEscala.add(new ItemEscala(302,1));
        itemsEscala.add(new ItemEscala(308,1));
        itemsEscala.add(new ItemEscala(326,1));
        itemsEscala.add(new ItemEscala(328,1));
        itemsEscala.add(new ItemEscala(338,1));
        itemsEscala.add(new ItemEscala(347,1));
        itemsEscala.add(new ItemEscala(348,1));
        itemsEscala.add(new ItemEscala(358,1));
        itemsEscala.add(new ItemEscala(364,1));
        itemsEscala.add(new ItemEscala(368,1));
        itemsEscala.add(new ItemEscala(369,1));
    }

    @Override
    protected void inicarPT() {

    }
}
