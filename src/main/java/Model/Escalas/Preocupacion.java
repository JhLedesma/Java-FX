package Model.Escalas;

public class Preocupacion extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //10 Items: 8V y 2F
        itemsEscala.add(new ItemEscala(38,1));
        itemsEscala.add(new ItemEscala(56,1));
        itemsEscala.add(new ItemEscala(92,1));
        itemsEscala.add(new ItemEscala(127,1));
        itemsEscala.add(new ItemEscala(130,1));
        itemsEscala.add(new ItemEscala(146,1));
        itemsEscala.add(new ItemEscala(170,1));
        itemsEscala.add(new ItemEscala(215,1));
        itemsEscala.add(new ItemEscala(75,0));
        itemsEscala.add(new ItemEscala(95,0));
    }

    @Override
    protected void inicarPT() {

    }
}
