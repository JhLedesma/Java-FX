package Model.Escalas;

public class Malfuncionamiento_Fisico extends Escala
{

    @Override
    protected void iniciarItemsEscala()
    {
        //11 Items: 4V y 7F
        itemsEscala.add(new ItemEscala(18,1));
        itemsEscala.add(new ItemEscala(117,1));
        itemsEscala.add(new ItemEscala(175,1));
        itemsEscala.add(new ItemEscala(181,1));
        itemsEscala.add(new ItemEscala(2,0));
        itemsEscala.add(new ItemEscala(20,0));
        itemsEscala.add(new ItemEscala(45,0));
        itemsEscala.add(new ItemEscala(141,0));
        itemsEscala.add(new ItemEscala(142,0));
        itemsEscala.add(new ItemEscala(143,0));
        itemsEscala.add(new ItemEscala(148,0));
    }

    @Override
    protected void inicarPT() {

    }
}
