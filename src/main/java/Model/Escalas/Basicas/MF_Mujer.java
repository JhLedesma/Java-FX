package Model.Escalas.Basicas;

import Model.Escalas.Escala;
import Model.Escalas.ItemEscala;

public class MF_Mujer extends Escala
{
    @Override
    protected void iniciarItemsEscala()
    {
        //56 Items: 25V y 31F
        itemsEscala.add(new ItemEscala(4,1));
        itemsEscala.add(new ItemEscala(25,1));
        itemsEscala.add(new ItemEscala(62,1));
        itemsEscala.add(new ItemEscala(64,1));
        itemsEscala.add(new ItemEscala(67,1));
        itemsEscala.add(new ItemEscala(74,1));
        itemsEscala.add(new ItemEscala(80,1));
        itemsEscala.add(new ItemEscala(112,1));
        itemsEscala.add(new ItemEscala(119,1));
        itemsEscala.add(new ItemEscala(121,1));
        itemsEscala.add(new ItemEscala(128,1));
        itemsEscala.add(new ItemEscala(137,1));
        itemsEscala.add(new ItemEscala(177,1));
        itemsEscala.add(new ItemEscala(187,1));
        itemsEscala.add(new ItemEscala(191,1));
        itemsEscala.add(new ItemEscala(196,1));
        itemsEscala.add(new ItemEscala(205,1));
        itemsEscala.add(new ItemEscala(219,1));
        itemsEscala.add(new ItemEscala(236,1));
        itemsEscala.add(new ItemEscala(251,1));
        itemsEscala.add(new ItemEscala(256,1));
        itemsEscala.add(new ItemEscala(271,1));
        itemsEscala.add(new ItemEscala(1,0));
        itemsEscala.add(new ItemEscala(19,0));
        itemsEscala.add(new ItemEscala(26,0));
        itemsEscala.add(new ItemEscala(27,0));
        itemsEscala.add(new ItemEscala(63,0));
        itemsEscala.add(new ItemEscala(68,0));
        itemsEscala.add(new ItemEscala(69,0));
        itemsEscala.add(new ItemEscala(76,0));
        itemsEscala.add(new ItemEscala(86,0));
        itemsEscala.add(new ItemEscala(103,0));
        itemsEscala.add(new ItemEscala(104,0));
        itemsEscala.add(new ItemEscala(107,0));
        itemsEscala.add(new ItemEscala(120,0));
        itemsEscala.add(new ItemEscala(132,0));
        itemsEscala.add(new ItemEscala(133,0));
        itemsEscala.add(new ItemEscala(163,0));
        itemsEscala.add(new ItemEscala(166,0));
        itemsEscala.add(new ItemEscala(184,0));
        itemsEscala.add(new ItemEscala(193,0));
        itemsEscala.add(new ItemEscala(194,0));
        itemsEscala.add(new ItemEscala(197,0));
        itemsEscala.add(new ItemEscala(199,0));
        itemsEscala.add(new ItemEscala(201,0));
        itemsEscala.add(new ItemEscala(207,0));
        itemsEscala.add(new ItemEscala(209,0));
        itemsEscala.add(new ItemEscala(231,0));
        itemsEscala.add(new ItemEscala(235,0));
        itemsEscala.add(new ItemEscala(237,0));
        itemsEscala.add(new ItemEscala(239,0));
        itemsEscala.add(new ItemEscala(254,0));
        itemsEscala.add(new ItemEscala(257,0));
        itemsEscala.add(new ItemEscala(268,0));
        itemsEscala.add(new ItemEscala(272,0));
    }

    @Override
    protected void inicarPT() {

        //No corresponde puntos T de Hombre
        puntajeTMujer.put(40,30);
        puntajeTMujer.put(39,33);
        puntajeTMujer.put(38,35);
        puntajeTMujer.put(37,38);
        puntajeTMujer.put(36,40);
        puntajeTMujer.put(35,43);
        puntajeTMujer.put(34,45);
        puntajeTMujer.put(33,48);
        puntajeTMujer.put(32,50);
        puntajeTMujer.put(31,53);
        puntajeTMujer.put(30,55);
        puntajeTMujer.put(29,58);
        puntajeTMujer.put(28,60);
        puntajeTMujer.put(27,63);
        puntajeTMujer.put(26,65);
        puntajeTMujer.put(25,68);
        puntajeTMujer.put(24,70);
        puntajeTMujer.put(23,72);
        puntajeTMujer.put(22,75);
        puntajeTMujer.put(21,77);
        puntajeTMujer.put(20,80);
        puntajeTMujer.put(19,82);
        puntajeTMujer.put(18,85);
        puntajeTMujer.put(17,87);
        puntajeTMujer.put(16,90);
        puntajeTMujer.put(15,92);
        puntajeTMujer.put(14,95);
        puntajeTMujer.put(13,97);
        puntajeTMujer.put(12,100);
        puntajeTMujer.put(11,102);
        puntajeTMujer.put(10,105);
        puntajeTMujer.put(9,107);
        puntajeTMujer.put(8,110);
        puntajeTMujer.put(7,112);
        puntajeTMujer.put(6,115);
        puntajeTMujer.put(5,117);
        puntajeTMujer.put(4,120);

    }
}
