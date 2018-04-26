package Model.Escalas;

public class Negacion_De_Ansiedad_Social extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //6 Items: 0V y 6F
        itemsEscala.add(new ItemEscala(129,0));
        itemsEscala.add(new ItemEscala(161,0));
        itemsEscala.add(new ItemEscala(167,0));
        itemsEscala.add(new ItemEscala(185,0));
        itemsEscala.add(new ItemEscala(243,0));
        itemsEscala.add(new ItemEscala(265,0));
    }

    @Override
    protected void inicarPT() {

    }
}
