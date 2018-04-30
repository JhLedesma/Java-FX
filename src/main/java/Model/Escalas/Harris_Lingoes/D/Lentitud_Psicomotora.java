package Model.Escalas.Harris_Lingoes.D;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class Lentitud_Psicomotora extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //14 Items: 4V y 10F
        itemsEscala.add(new ItemEscala(38,1));
        itemsEscala.add(new ItemEscala(46,1));
        itemsEscala.add(new ItemEscala(170,1));
        itemsEscala.add(new ItemEscala(233,1));
        itemsEscala.add(new ItemEscala(9,0));
        itemsEscala.add(new ItemEscala(29,0));
        itemsEscala.add(new ItemEscala(37,0));
        itemsEscala.add(new ItemEscala(49,0));
        itemsEscala.add(new ItemEscala(55,0));
        itemsEscala.add(new ItemEscala(76,0));
        itemsEscala.add(new ItemEscala(134,0));
        itemsEscala.add(new ItemEscala(188,0));
        itemsEscala.add(new ItemEscala(189,0));
        itemsEscala.add(new ItemEscala(212,0));
    }

    @Override
    protected void inicarPT() {

    }
}
