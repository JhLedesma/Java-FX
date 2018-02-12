package UI.ListaAspirantes.ListaApirantes1920x1080;

import UI.ListaAspirantes.ItemListView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ItemListView1920x1080 extends ItemListView
{

    protected void configListView() {
        listView.setPrefHeight(190.0);
        listView.setVerticalGap(10.0);
        listView.depthProperty().set(1);
        listView.setExpanded(true);
        listView.setVisible(true);
    }

    protected void configSizeLabel(Label lbl)
    {
        lbl.setFont(Font.font("Arial", 18));
    }


}