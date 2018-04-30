package Model.Escalas.Harris_Lingoes.Se;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Alienacion_Emocional extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //11 Items: 8V y 3F
        itemsEscala.add(new ItemEscala(65,1));
        itemsEscala.add(new ItemEscala(92,1));
        itemsEscala.add(new ItemEscala(234,1));
        itemsEscala.add(new ItemEscala(273,1));
        itemsEscala.add(new ItemEscala(303,1));
        itemsEscala.add(new ItemEscala(323,1));
        itemsEscala.add(new ItemEscala(329,1));
        itemsEscala.add(new ItemEscala(332,1));
        itemsEscala.add(new ItemEscala(9,0));
        itemsEscala.add(new ItemEscala(210,0));
        itemsEscala.add(new ItemEscala(290,0));
    }

    @Override
    protected void inicarPT() {

    }
}
