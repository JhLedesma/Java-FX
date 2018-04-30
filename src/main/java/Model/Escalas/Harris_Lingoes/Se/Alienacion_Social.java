package Model.Escalas.Harris_Lingoes.Se;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Alienacion_Social extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //21 Items: 16V y 5F
        itemsEscala.add(new ItemEscala(17,1));
        itemsEscala.add(new ItemEscala(21,1));
        itemsEscala.add(new ItemEscala(22,1));
        itemsEscala.add(new ItemEscala(42,1));
        itemsEscala.add(new ItemEscala(46,1));
        itemsEscala.add(new ItemEscala(138,1));
        itemsEscala.add(new ItemEscala(145,1));
        itemsEscala.add(new ItemEscala(190,1));
        itemsEscala.add(new ItemEscala(221,1));
        itemsEscala.add(new ItemEscala(256,1));
        itemsEscala.add(new ItemEscala(277,1));
        itemsEscala.add(new ItemEscala(281,1));
        itemsEscala.add(new ItemEscala(291,1));
        itemsEscala.add(new ItemEscala(292,1));
        itemsEscala.add(new ItemEscala(320,1));
        itemsEscala.add(new ItemEscala(333,1));
        itemsEscala.add(new ItemEscala(90,0));
        itemsEscala.add(new ItemEscala(276,0));
        itemsEscala.add(new ItemEscala(278,0));
        itemsEscala.add(new ItemEscala(280,0));
        itemsEscala.add(new ItemEscala(343,0));
    }

    @Override
    protected void inicarPT() {

    }
}
